import React from 'react';
import { connect } from 'react-redux';
import { Table, Icon, Divider, Button } from 'antd';
import createOrder from '../actions/createOrder';
const { Column } = Table;


const CartList = ({cartItems, cartDetailItems, clearCartItems, updateProductCount, removeCartItem})=>{
    return (
      <div>
        <Table dataSource={cartDetailItems}>
        <Column title="名称" dataIndex="name" key="name" />
        <Column title="单价" dataIndex="price" key="price" />
        <Column title="单位" dataIndex="unit" key="unit" />
        <Column title="数量" dataIndex="count" key="count" />
        <Column title="总价" dataIndex="totalPrice" key="totalPrice" />
        <Column
          title="操作"
          key="action"
          render={(text, record) => (
            <span>
              <a onClick={() => updateProductCount(record.key, record.count - 1)}>
                <Icon type="minus" />
              </a>
              <Divider type="vertical" />
              <a onClick={() => updateProductCount(record.key, record.count + 1)}>
                <Icon type="plus" />
              </a>
              <Divider type="vertical" />
              <a onClick={()=> removeCartItem(record.key)} className="ant-dropdown-link">
                <Icon type="close"/>
              </a>
            </span>
          )}
        />
      </Table>
      <div style={{margin:10, display: cartItems.length === 0 ? "none" : "block"}} >
        <Button type="primary" onClick={() => createOrder(cartItems, clearCartItems)}>生成订单</Button> 
      </div>
    </div>);
}

const getCartDetailItems = (products, cartItems) =>{
  return cartItems.map(cartItem => {
      let product = products.find(item => item.id === cartItem.productId);
      return {
        key: product.id,
        name: product.name,
        price: product.price,
        unit: product.unit,
        count: cartItem.productCount,
        totalPrice: cartItem.productCount * product.price
      };
  });
}

const mapStateToProps = ({ products, cartItems }) => ({
  cartDetailItems: getCartDetailItems(products, cartItems),
  cartItems
});

const mapDispatchToProps = dispatch => ({
  clearCartItems: () => dispatch({type:"CLEAR_CARTITEMS"}),
  updateProductCount: (id, productCount) => dispatch({
    type:"UPDATE_CARTITEM",
    id,
    productCount
  }),
  removeCartItem: id => dispatch({
    type:"REMOVE_CARTITEM",
    id
  }),
});

export default connect(mapStateToProps, mapDispatchToProps)(CartList);

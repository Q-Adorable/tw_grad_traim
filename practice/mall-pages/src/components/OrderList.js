import React,{Component} from 'react';
import { connect } from 'react-redux';
import { Row } from 'antd';
import OrderItemList from './OrderItemList'
import loadOrders from '../actions/loadOrders'

class OrderList extends Component{
    componentDidMount(){
        this.props.loadOrders();
      }    

    render(){
        const {orders, updateProductCount, removeOrderItem} = this.props;        
        return (<div>
            {orders.map(order => <Row key={order.id}>
                <OrderItemList {...order} updateProductCount={updateProductCount} removeOrderItem={removeOrderItem}/>
            </Row>)}
        </div>);
    }
} 

const mapStateToProps = ({ orders }) => ({
  orders
});

const mapDispatchToProps = dispatch => ({
    loadOrders: ()=> {dispatch(loadOrders())},
    updateProductCount: (orderId, orderItemId, productCount) => dispatch({
        type:"UPDATE_OrderItem",
        orderId,
        orderItemId,
        productCount
      }),
      removeOrderItem: (orderId, orderItemId) => dispatch({
        type:"REMOVE_OrderItem",
        orderId,
        orderItemId
      }),
});

export default connect(mapStateToProps, mapDispatchToProps)(OrderList);

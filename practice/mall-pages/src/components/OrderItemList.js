import React from 'react';
import { Table, Icon, Divider } from 'antd';
import removeOrderItemRequest from '../actions/removeOrderItem'
import updateOrderItemRequest from '../actions/updateOrderItem'

const { Column } = Table;

const OrderItemList = ({id, createTime, orderItems, updateProductCount, removeOrderItem})=>{
    let orderDetailItems = orderItems.map(item => {
        return {
            orderId: id,
            key: item.id,
            name: item.product.name,
            price: item.product.price,
            unit: item.product.unit,
            count: item.productCount,
            totalPrice: item.productCount * item.product.price,
        };
    });
    return (
        <div>
            <div style={{margin:10}}><span>订单编号：{id}</span><span style={{float:"right"}}>创建时间：{createTime}</span></div>
            <Table dataSource={orderDetailItems} bordered={true}>
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
                            <a onClick={() => {
                                let count = record.count - 1;
                                if(count > 0){
                                    updateProductCount(record.orderId, record.key, record.count - 1);
                                    updateOrderItemRequest(record.orderId, record.key, record.count - 1);
                                }
                            }}>
                                <Icon type="minus" />
                            </a>
                            <Divider type="vertical" />
                            <a onClick={() => {
                                updateProductCount(record.orderId, record.key, record.count + 1);
                                updateOrderItemRequest(record.orderId, record.key, record.count + 1);
                            }}>
                                <Icon type="plus" />
                            </a>
                            <Divider type="vertical" />
                            <a onClick={()=> {
                                removeOrderItem(record.orderId, record.key);
                                removeOrderItemRequest(record.orderId, record.key);
                                }} className="ant-dropdown-link">
                                <Icon type="close"/>
                            </a>
                        </span>
                    )}/>
            </Table>
        </div>);
}

export default OrderItemList;
``
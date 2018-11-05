import React from 'react';
import { Card, Col, Icon } from 'antd';

const { Meta } = Card;

const Product = ({id, name, price, unit, icon, addProductToCart})=>{
    return (
        <Col span={8}>
            <Card hoverable 
                style={{ width: 240 }} 
                cover={<img alt="example" 
                src={"./resources/imgs/default.png"} />}
                actions={[<Icon type="shopping-cart" onClick={() => {
                    addProductToCart(id);
                    alert("成功添加商品(" + name + ")到购物车");
                }}/>, <Icon type="edit"/>]}
                >
                <Meta title={name} description={"单价: " + price + " / " + unit}/>
            </Card>
        </Col>
        );
}

export default Product;
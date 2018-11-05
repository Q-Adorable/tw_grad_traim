import React, {Component} from 'react';
import {Layout} from 'antd';
import MallHeader from './PageHeader';
import MallFooter from './PageFooter';
import OrderList from './OrderList'

const {Content} = Layout;

class OrderPage extends Component {
    render() {
        return (
            <Layout className="layout">
                <MallHeader selectedKeys={['3']}></MallHeader>
                <Content style={{padding: '0 50px'}}>
                    <div style={{
                        background: '#fff',
                        padding: 24,
                        minHeight: 280,
                        marginTop: 30
                    }}>
                        <OrderList/>
                    </div>
                </Content>
                <MallFooter></MallFooter>
            </Layout>
        );
    }
}

export default OrderPage;

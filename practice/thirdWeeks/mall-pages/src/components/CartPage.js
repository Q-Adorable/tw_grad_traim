import React, {Component} from 'react';
import {Layout} from 'antd';
import MallHeader from './PageHeader';
import MallFooter from './PageFooter';
import CartList from './CartList';

const {Content} = Layout;

class CartPage extends Component {
    render() {
        return (
            <Layout className="layout">
                <MallHeader selectedKeys={['2']}></MallHeader>
                <Content style={{padding: '0 50px'}}>
                    <div style={{
                        background: '#fff',
                        padding: 24,
                        minHeight: 280,
                        marginTop: 30
                    }}>
                        <CartList />
                    </div>
                </Content>
                <MallFooter></MallFooter>
            </Layout>
        );
    }
}

export default CartPage;

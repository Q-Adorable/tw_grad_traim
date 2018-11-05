import React, {Component} from 'react';
import MallHeader from './PageHeader';
import MallFooter from './PageFooter';
import { Button, Layout } from 'antd';
import ProductList from './ProductList'

const {Content} = Layout;

class HomePage extends Component {
    render() {
        return (
            <Layout className="layout">
                <MallHeader selectedKeys={['1']}></MallHeader>
                <Content style={{padding: '0 50px'}}>
                    <div style={{
                        background: '#fff',
                        padding: 24,
                        minHeight: 280,
                        marginTop: 30
                    }}>
                    <div style={{margin:10}}>
                        <Button type="primary">添加商品</Button> 
                    </div>
                    <ProductList/>
                    </div>
                </Content>
                <MallFooter></MallFooter>
            </Layout>
        );
    }
}

export default HomePage;
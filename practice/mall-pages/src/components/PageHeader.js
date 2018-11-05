import React from 'react';
import {Layout, Menu} from 'antd';
import {Link} from 'react-router-dom';

const {Header} = Layout;

const PageHeader = ({selectedKeys}) => {
    return (<Header>
        <div className="logo"/>
        <Menu
            theme="dark"
            mode="horizontal"
            defaultSelectedKeys={selectedKeys}
            style={{lineHeight: '64px'}}
        >
            <Menu.Item key="1">
                <Link to="/">商城首页</Link>
            </Menu.Item>
            <Menu.Item key="2">
                <Link to="/cart">购物车</Link>
            </Menu.Item>
            <Menu.Item key="3">
                <Link to="/order">我的订单</Link>
            </Menu.Item>
        </Menu>
    </Header>
    );
}

export default PageHeader;

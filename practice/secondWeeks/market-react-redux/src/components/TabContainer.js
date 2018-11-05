import React from 'react';
import { Route } from 'react-router-dom';
import {
  TabContent, TabPane
} from 'reactstrap';
import ShopItems from './ShopItems';
import ShopCart from './ShopCart';
const TabContainer = () => {
  return (
    <TabContent>
      <TabPane className="TabPane">
        <Route exact path='/' component={ShopItems} />
        <Route exact path='/cart' component={ShopCart} />
      </TabPane>
    </TabContent>);
}
export default TabContainer;
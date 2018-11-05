import React, {Component} from 'react';
import HomePage from './HomePage'
import CartPage from './CartPage'
import OrderPage from './OrderPage'
import {BrowserRouter, Route} from 'react-router-dom';

class AppRouter extends Component {
    render() {
        return (      
        <BrowserRouter>
            <div>
              <Route  exact path="/" component={HomePage}/>
              <Route  path="/cart" component={CartPage}/>
              <Route  path="/order" component={OrderPage}/>
            </div>
        </BrowserRouter>
    );
    }
}

export default AppRouter;

import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import App from './App';
import ShopItems from './components/ShopItems';
import ShopCart from './components/ShopCart';

const AppRouter = (props) => {
  return (
    <Router>
      {/* <Route path='/:filter?' component={App}/> */}
      <App/>
    </Router>
  );
 };

export default AppRouter;
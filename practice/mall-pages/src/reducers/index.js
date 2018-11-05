import { combineReducers } from 'redux';
import products from './products';
import cartItems from './cartItems';
import orders from './orders';

const reducers = combineReducers({
  products,
  cartItems,
  orders
});

export default reducers;
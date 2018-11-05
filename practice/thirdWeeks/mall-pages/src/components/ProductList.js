import React, {Component} from 'react';
import { connect } from 'react-redux';
import Product from './Product'
import { Row } from 'antd';
import loadProducts from '../actions/loadProducts'

class ProductList extends Component {

    componentDidMount(){
        this.props.loadProducts();
      }    

    render() {
        const {products, addProductToCart} = this.props;
        return (
            <Row gutter={16}>
                {products.map(product => <Product key={product.id} {...product} addProductToCart={addProductToCart}/>)}
            </Row>);
    }
}

const mapStateToProps = ({ products }) => ({
    products
  });
  
  const mapDispatchToProps = dispatch => ({
    loadProducts: ()=> {dispatch(loadProducts())},
    addProductToCart: (productId) => dispatch({
        type: "ADD_PRODUCTTOCART",
        productId
    })
  });
  
  export default connect(mapStateToProps, mapDispatchToProps)(ProductList);
import request from 'superagent';

const loadProducts = ()=> {
    return dispatch => {
        request.get('/products')
            .end((err, res)=> {
                
                let products = res.body.map(product => {
                    return {
                        id: product.id,
                        icon: product.icon,
                        name: product.name,
                        unit: product.unit,
                        price: product.price,
                    };     
                });        
                dispatch({
                    type: 'INIT_PRODUCT',
                    data: products
                });
            })
    }
  };

export default loadProducts;
import request from 'superagent';

const loadOrders = ()=> {
    return dispatch => {
        request.get('/orders')
            .end((err, res)=> {
                let orders = res.body.map(order => {
                    return {
                        id: order.id,
                        createTime: order.createTime,
                        orderItems: order.orderItems
                    };
                });        
                dispatch({
                    type: 'INIT_ORDER',
                    data: orders
                });
            })
    }
  };

export default loadOrders;
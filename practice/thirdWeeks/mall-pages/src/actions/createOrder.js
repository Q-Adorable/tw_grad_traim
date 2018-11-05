import request from 'superagent';

const createOrder = (cartItems, clearCartItems)=> {
    request.post('/orders').
            send({
                orderItems: cartItems,
                userId: 1})
            .end((err, res)=> {
                if(res && res.statusCode === 201){
                    clearCartItems();
                    alert("成功生成订单");
                }
            })
  };

export default createOrder;
import request from 'superagent';

const updateOrderItem = (orderId, orderItemId, productCount)=> {
    request.put('/orders/' + orderId + "/orderitems/" + orderItemId)
            .send({
                productCount
            })
            .end((err, res)=> {
                if(res && res.statusCode === 204){
                    console.log("成功更新");
                }
            })
  };

export default updateOrderItem;
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/products/1'
    }
    response {
        status 200
        body(file("./product.json"))
        headers {
            header('Content-Type': "application/json;charset=UTF-8")
        }
    }
}
# Tasks

/products

- post()

  1. return 201

     - return 201 when create product — 5 7

     - return uri when create product — 10 8

     - save and find product in product repository  — 15 20

       (ProductRepository.createProduct,

       ProductMapper.save,

       ProductMapper.findById)

     - return 201 when create product with specified parameter — 5 3

  2. return 400

     - return 400 when name, description or price is null — 10 25

       (Exception handling)

     ​

- get()

  1. return 200

     - return 200 when get products — 5 3

     - get products in product repository — 10 8

       (ProductRepository.getAllProducts,

       ProductMapper.getAll)

     - return detail when get products — 5 5

       (toJason, toRefJason)

       ​

/products/{productId}

- get()

  1. return 200

     - return 200 when get product — 3 4

     - find product in product repository  — 5 6

       ((Optional)ProductRepository.findProductById)

     - return detail when get product — 5 3

  2. return 404

     - return 404 when no product exists — 5 3

  ​

/users

- post()

  1. return 201

     - return 201 when create user — 5 3

     - return uri when create user — 5 12

     - save and find user in user repository  — 15 17

       (UserRepository.createUser,

       UserMapper.save,

       UserMapper.findById)

     - return 201 when create user with specified parameter — 5 3

  2. return 400

     - find user by name in user repository  — 10 5

       (UserRepository.findUserByName,

       UserMapper.findByName)

     - return 400 when user exists — 5 3

     - return 400 when name is null — 5 3

/users/{userId}

- get()

  1. return 200

     - return 201 when find user by id — 5 5

     - find user by id in user repository — 7 3

       (UserRepository.findUserById)

     - return details when find user by id — 10 7

  2. return 404

     - return 404 when user not exists — 5 3



/users/{id}/orders

- post()

  1. return 201

     - return 201 when create order — 5 4

     - return uri when create order — 10 16

     - save and find order in user — 20 30

       (User.createOrder,

       OrderMapper.save,

       OrderMapper.findById)

     - return 201 when create oder with specified parameter — 10 2

  2. return 400

     - return 400 when name, address, phone, order_items, product_id or quantity is null — 5 7
     - return 400 when product_id is not found — 5 3

     ​

- get()

  1. return 200

     - return 200 when get orders — 5 2

     - get orders in user repository in user — 15 6

       (User.getAllOrders,

       OrderMapper.getAll)

     - return detail when get orders — 10 6

     ​

/users/{id}/orders/{orderId}

- get()

  1. return 200

     - return 200 when find order by id— 5 3

     - find order by order_id in user  — 10 3

       (User.findOrderById)

     - return detail when get order — 10 8

  2. return 404 when no order exists — 5 2

     ​

/users/{id}/orders/{orderId}/payments

- post()

  1. return 201

     - return 201 when create payment — 5 4

     - return uri when create payment — 10 7

     - save payment in order — 15 22

       (Order.createPayment,

       PaymentMapper.save,

       PaymentMapper.findById)

     - return 201 when create payment with specified parameter — 5 3

  2. return 400

     - return 400 when payment exists — 5 4
     - return 400 when pay_type or amount is null — 5 4

     ​

- get()

  1. return 200

     - return 200 when get payment — 5 3

     - find payment in order — 5 4

       (Order.getPayment)

     - return details when get payment — 5 10

  2. return 404 when no payment exists — 5 3



- total: 340(estimated)  475
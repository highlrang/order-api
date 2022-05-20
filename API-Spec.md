<h2>상품 API</h2>
<br>

<b>상품 목록<br>
<span style="color: pink;">GET</span> /api/v1/item</b>
```json
Response
{
  "statusCode": "1001", 
  "message": "success",
  "content": [
    {
      "id": 1,                        // 상품 아이디
      "name": "상품명",                // 상품명
      "brandName": "브랜드명",         // 브랜드명
      "price": 10000,                 // 가격
      "discountRate": 10,             // 할인율
      "discountPrice": 9000,          // 할인가
      "stock": null
    },
    ...
  ]
}
```

<b>상품 상세<br>
<span style="color: pink;">GET</span> /api/v1/item/{id}</b>
```json
Response
{
  "statusCode": "1001", 
  "message": "success",
  "content": {
      "id": 1,                
      "name": "상품명",        
      "brandName": "브랜드명", 
      "price": 10000,         
      "discountRate": 10,
      "discountPrice": 9000,
      "stock": 1000
    }
}

예외 사항 발생 시
{
  "statusCode": "4001",
  "message": "상품 정보를 불러오지 못했습니다.",
  "content": null
}
```

<br>

<h2>장바구니 API</h2><br>

<b>장바구니 상품 목록<br>
<span style="color: pink;">GET</span> /api/v1/cart</b>
```json
Response
{
  statusCode: "1001", 
  "message": "success",
  "content": [
    {
      "id": 1,                    // 장바구니 아이디
      "cartItems": [              // 장바구니에 담은 상품 목록
        {
          "id": 1,                // 장바구니상품 아이디
          "item": {               // 상품 정보
            "id": 1,
            "name": "상품명",        
            "brandName": "브랜드명", 
            "price": 10000,         
            "discountRate": 10,
            "discountPrice": 9000,
            "stock": 1000
          }
        },
        ...
      ]
    },
    ...
  ]
}
```
<br>

<b>장바구니 상품 담기<br>
<span style="color: pink;">POST</span> /api/v1/cart/{id}</b>
```json
Request
{
  "itemId": 1,          // 상품 아이디
  "quantity": 1,        // 수량
}

Response
{
  "statusCode": "1001", 
  "message": "success",
  "content": null
}

Fail Response
{
  "statusCode": "4001",
  "message": "장바구니에 상품을 추가하지 못했습니다.",
  "content": null
}
```
<br>

<b>장바구니 상품 삭제<br>
<span style="color: pink;">DELETE</span> /api/v1/cart/{id}/item</b>
```json
Request
{
  "cartItemId": [1, 2, ...],    // 장바구니상품 아이디
}

Response
{
  "statusCode": "1001", 
  "message": "success",
  "content": null
}

Fail Response
{
  "statusCode": "4001",
  "message": "장바구니에서 상품을 제거하지 못했습니다.",
  "content": null
}
```
<br>


<h2>주문 API</h2><br>
<b>상품 주문하기 -> 장바구니에서 여러 개 주문도 가능<br>
<span style="color: pink;">POST</span> /api/v1/order</b>
```json
Request
{
  orderItems: [
    {
      "itemId": 1,          // 상품 아이디
      "quantity": 1,        // 수량
      "price": 9000,        // 상품 가격(결제할 금액)
    }, ...
  ],
  "address": {              // 배송지 주소
    "basicAddress": "주소", 
    "detailAddress": "상세 주소",
    "poseCode": "123-456"
  }
},

Response
{
  "statusCode": "1001", 
  "message": "success",
  "content": null
}

Fail Response
{
  "statusCode": "4001",
  "message": "상품 주문에 실패하였습니다.",
  "content": null
}
```
<br>

<b>주문 내역 목록<br>
<span style="color: pink;">GET</span> /api/v1/order</b>
```json
Response
[
  {
    "id": 1,         // 주문 아이디
    "orderItems": [  // 주문상품 목록
      {
        "itemName": "상품명",
        "price": 10000,
        "quantity": 1
      },
      {
        "itemName": "상품명",
        "price": 5000
        "quantity": 2
      }
    ],
    "orderStatus": "주문상태",      // 주문상태
    "createdDate": "2022-05-20",   // 주문날짜
    "totalPrice": 20000            // 총 주문 금액
  },
  ...
]
```
<br>

<b>주문 내역 상세<br>
<span style="color: pink;">GET</span> /api/v1/order/{id}</b>
```json
Response
{
  "id": 1,         // 주문 아이디
  "orderItems": [  // 주문상품 목록
    {
      "itemName": "상품명",
      "price": 10000,
      "quantity": 1
    },
    {
      "itemName": "상품명",
      "price": 5000
      "quantity": 2
    }
  ],
  "orderStatus": "주문상태",      // 주문상태
  "createdDate": "2022-05-20",   // 주문날짜
  "totalPrice": 20000            // 총 주문 금액
}
```
<br>

<b>주문 취소<br>
<span style="color: pink;">PATCH</span> /api/v1/order/{id}/cancel</b>
```json
Response
{
  "statusCode": "1001",
  "message": "success",
  "content": null
}

Fail Response
{
  "statusCode": "4001",
  "message": "주문 취소에 실패하였습니다.",
  "content": null
}
```
<br>
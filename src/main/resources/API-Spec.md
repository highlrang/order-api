<h2>상품 API</h2>
<br>

<b>상품 목록<br>
<span style="color: pink;">GET</span> /api/v1/item</b>
```json
요청 데이터
{
  "brandId?": "number; 브랜드 아이디",
  "categoryId?": "number; 카테고리 아이디",
  "search?": "string; 검색 문자열",
  "sort?": "string; 정렬 기준 속성"
}

응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": [
    {
      "id": "number; 상품 아이디",              
      "name": "string; 상품명",
      "brandName": "string; 브랜드명",
      "price": "number; 가격",
      "discountRate": "number; 할인율",
      "discountPrice": "number; 할인가"
    },
    {
      "id": "number; 상품 아이디",              
      "name": "string; 상품명",
      "brandName": "string; 브랜드명",
      "price": "number; 가격",
      "discountRate": "number; 할인율",
      "discountPrice": "number; 할인가"
    }
  ]
}
```

<b>상품 상세<br>
<span style="color: pink;">GET</span> /api/v1/item/{id}</b>
```json
응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": {
      "id": "number; 상품 아이디",              
      "name": "string; 상품명",
      "brandName": "string; 브랜드명",
      "price": "number; 가격",
      "discountRate": "number; 할인율",
      "discountPrice": "number; 할인가"
    }
}

예외 응답 객체
{
  "statusCode": "number; 4001",
  "message": "string; 상품 정보를 불러오지 못했습니다.",
  "content": null
}
```

<br>

<h2>장바구니 API</h2><br>

<b>장바구니 상품 목록<br>
<span style="color: pink;">GET</span> /api/v1/cart</b>
```json
응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": {
      "id": "number; 장바구니 아이디",
      "cartItems": [              
        {
          "id": "number; 장바구니상품 아이디",
          "item": {
            "id": "number; 상품 아이디",
            "name": "string; 상품명",        
            "brandName": "string; 브랜드명", 
            "price": "number; 가격",         
            "discountRate": "number; 할인율",
            "discountPrice": "number; 할인가"
          }
        },
        {
          "id": "number; 장바구니상품 아이디",
          "item": {
            "id": "number; 상품 아이디",
            "name": "string; 상품명",        
            "brandName": "string; 브랜드명", 
            "price": "number; 가격",         
            "discountRate": "number; 할인율",
            "discountPrice": "number; 할인가"
          }
        }
      ]
    }
}
```
<br>

<b>장바구니 상품 담기<br>
<span style="color: pink;">POST</span> /api/v1/cart/{id}</b>
```json
요청 데이터
{
  "itemId": "number; 상품 아이디",
  "quantity": "number; 상품 수량",
}

응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": null
}

예외 응답 객체
{
  "statusCode": "4001",
  "message": "string; 장바구니에 상품을 추가하지 못했습니다.",
  "content": null
}
```
<br>

<b>장바구니 상품 삭제<br>
<span style="color: pink;">DELETE</span> /api/v1/cart/{id}/item</b>
```json
요청 데이터
{
  "cartItemId": "[number; 장바구니상품 아이디 배열]"
}

응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": null
}

예외 응답 객체
{
  "statusCode": "4001",
  "message": "string; 장바구니에서 상품을 제거하지 못했습니다.",
  "content": null
}
```
<br>


<h2>주문 API</h2><br>

<b>상품 주문하기 -> 장바구니에서 여러 개 주문도 가능<br>
<span style="color: pink;">POST</span> /api/v1/order</b>
```json
요청 데이터
{
  "orderItems": [
    {
      "itemId": "number; 상품 아이디",
      "quantity": "number; 상품 수량",
      "price": "number; 상품 가격(또는 할인가)",
    },
    {
      "itemId": "number; 상품 아이디",
      "quantity": "number; 상품 수량",
      "price": "number; 상품 가격(또는 할인가)",
    }
  ],
  "address": {
    "basicAddress": "string; 주소", 
    "detailAddress": "string; 상세 주소",
    "poseCode": "string; 우편 번호"
  }
},

응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": null
}

예외 응답 객체
{
  "statusCode": "4001",
  "message": "string; 상품 주문에 실패하였습니다.",
  "content": null
}
```
<br>

<b>주문 내역 목록<br>
<span style="color: pink;">GET</span> /api/v1/order</b>
```json
응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": {
    "id": "number; 주문 아이디",
    "orderItems": [
      {
        "itemName": "string; 상품명",
        "price": "number; 상품 가격(또는 할인가)",
        "quantity": "string; 상품 수량"
      },
      {
        "itemName": "string; 상품명",
        "price": "number; 상품 가격(또는 할인가)",
        "quantity": "string; 상품 수량"
      }
    ],
    "orderStatus": "string; 주문상태",
    "createdDate": "string; 주문 날짜(yyyy-MM-dd)",
    "totalPrice": "number; 총 주문금액"
  }

```
<br>

<b>주문 내역 상세<br>
<span style="color: pink;">GET</span> /api/v1/order/{id}</b>
```json
응답 객체
{
  "statusCode": "1001", 
  "message": "success",
  "content": {
    "id": "number; 주문 아이디",
    "orderItems": [
      {
        "itemName": "string; 상품명",
        "price": "number; 상품 가격(또는 할인가)",
        "quantity": "number; 상품 수량"
      },
      {
        "itemName": "string; 상품명",
        "price": "number; 상품 가격(또는 할인가)",
        "quantity": "number; 상품 수량"
      }
    ],
    "orderStatus": "string; 주문상태",
    "createdDate": "string; 주문 날짜(yyyy-MM-dd)",
    "totalPrice": "number; 총 주문금액"
}
```
<br>

<b>주문 취소<br>
<span style="color: pink;">PATCH</span> /api/v1/order/{id}/cancel</b>
```json
응답 객체
{
  "statusCode": "1001",
  "message": "success",
  "content": null
}

예외 응답 객체
{
  "statusCode": "4001",
  "message": "주문 취소에 실패하였습니다.",
  "content": null
}
```
<br>

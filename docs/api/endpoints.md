## Auth

| Method | URL            | Auth   | Description                              | Params                         |
| ------ | -------------- | ------ | ---------------------------------------- | ------------------------------ |
| POST   | /auth/register | public | Create account (student/staff)           | body: username, password, role |
| POST   | /auth/login    | public | Login and get JWT token                  | body: username, password       |
| POST   | /auth/logout   | user   | Logout (optional if using stateless JWT) | -                              |
| POST   | /auth/refresh  | user   | Refresh access token                     | body: refreshToken             |


## Items

| Method | URL                       | Auth    | Description              | Params                               |
| ------ | ------------------------- | ------- | ------------------------ | ------------------------------------ |
| GET    | /items                    | public  | Browse/search items      | type, query, sort, order, page, size |
| GET    | /items/{itemId}           | public  | View single item details | path: itemId                         |
| POST   | /items                    | manager | Add new item             | body: item details                   |
| PUT    | /items/{itemId}           | manager | Update item details      | path: itemId, body: updated details  |
| DELETE | /items/{itemId}           | manager | Delete item              | path: itemId                         |
| PATCH  | /items/{itemId}/threshold | manager | Update stock threshold   | path: itemId, body: threshold        |


## Cart

| Method | URL                  | Auth | Description             | Params                       |
| ------ | -------------------- | ---- | ----------------------- | ---------------------------- |
| GET    | /cart                | user | View current user cart  | -                            |
| POST   | /cart/items          | user | Add item to cart        | body: itemId, quantity       |
| PATCH  | /cart/items/{itemId} | user | Change quantity of item | path: itemId, body: quantity |
| DELETE | /cart/items/{itemId} | user | Remove item from cart   | path: itemId                 |
| DELETE | /cart                | user | Clear cart              | -                            |


## Orders & Payments

| Method | URL                   | Auth | Description                  | Params                               |
| ------ | --------------------- | ---- | ---------------------------- | ------------------------------------ |
| POST   | /orders               | user | Checkout cart → create order | -                                    |
| GET    | /orders               | user | View user orders             | -                                    |
| GET    | /orders/{orderId}     | user | View single order            | path: orderId                        |
| POST   | /orders/{orderId}/pay | user | Make payment (mock/demo)     | path: orderId, body: payment details |
| GET    | /payments/{paymentId} | user | View payment info            | path: paymentId                      |



## Notifications

| Method | URL                 | Auth | Description             | Params               |
| ------ | ------------------- | ---- | ----------------------- | -------------------- |
| GET    | /notifications      | user | View user notifications | -                    |
| PATCH  | /notifications/{id} | user | Mark notification read  | path: notificationId |



## Store

| Method | URL            | Auth    | Description          | Params                 |
| ------ | -------------- | ------- | -------------------- | ---------------------- |
| GET    | /store/timings | manager | View store timings   | -                      |
| PUT    | /store/timings | manager | Update store timings | body: open/close times |




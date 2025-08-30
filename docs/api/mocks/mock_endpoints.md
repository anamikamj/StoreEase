# StoreEase API Mock Endpoints

This document lists all API endpoints with example requests and responses.  
Use this for human-readable reference and manual testing.

---

## Authentication Endpoints

### POST /auth/login

- **Request:** `examples/auth_login_request.json`
- **Success (200):** `examples/auth_login_post_200.json`
- **Errors:** 400 → `examples/error_400.json`, 401 → `examples/error_401.json`

### POST /auth/logout

- **Success (200):** `examples/auth_logout_post_200.json`
- **Errors:** 400 → `examples/error_400.json`, 401 → `examples/error_401.json`

### POST /auth/refresh

- **Request:** `examples/auth_refresh_request.json`
- **Success (200):** `examples/auth_refresh_post_200.json`
- **Errors:** 401 → `examples/error_401.json`

### POST /auth/register

- **Request:** `examples/auth_register_request.json`
- **Success (201):** `examples/auth_register_post_201.json`
- **Errors:** 400 → `examples/error_400.json`

---

## Cart Endpoints

### GET /cart

- **Success (200):** `examples/cart_get_200.json`
- **Errors:** 401 → `examples/error_401.json`

### POST /cart/add

- **Request:** `examples/cart_post_add_request.json`
- **Success (201):** `examples/cart_post_add_201.json`
- **Errors:** 400 → `examples/error_400.json`, 404 → `examples/error_404.json`

### PATCH /cart/item

- **Request:** `examples/cart_patch_update_request.json`
- **Success (200):** `examples/cart_patch_item_200.json`
- **Errors:** 400 → `examples/error_400.json`

### DELETE /cart/item

- **Success (200):** `examples/cart_delete_item_200.json`
- **Errors:** 404 → `examples/error_404.json`

### DELETE /cart/clear

- **Success (200):** `examples/cart_delete_clear_200.json`

---

## Items Endpoints

### GET /items

- **Success (200):** `examples/items_get_list_200.json`

### GET /items/{id}

- **Success (200):** `examples/items_get_single_200.json`
- **Errors:** 404 → `examples/error_404.json`

### POST /items/add

- **Request:** `examples/items_post_request.json`
- **Success (201):** `examples/items_post_add_201.json`
- **Errors:** 400 → `examples/error_400.json`

### PUT /items/update

- **Request:** `examples/items_put_request.json`
- **Success (200):** `examples/items_put_update_200.json`
- **Errors:** 400 → `examples/error_400.json`

### PATCH /items/threshold

- **Request:** `examples/items_patch_threshold_request.json`
- **Success (200):** `examples/items_patch_threshold_200.json`
- **Errors:** 400 → `examples/error_400.json`

### DELETE /items/{id}

- **Success (200):** `examples/items_delete_200.json`
- **Errors:** 404 → `examples/error_404.json`

---

## Notifications Endpoints

### GET /notifications

- **Success (200):** `examples/notifications_get_200.json`

### PATCH /notifications/read

- **Success (200):** `examples/notifications_patch_read_200.json`

---

## Orders Endpoints

### GET /orders

- **Success (200):** `examples/orders_get_list_200.json`

### GET /orders/{id}

- **Success (200):** `examples/orders_get_single_200.json`
- **Errors:** 404 → `examples/error_404.json`

### POST /orders

- **Request:** `examples/orders_post_request.json`
- **Success (200):** `examples/orders_post_pay_200.json`
- **Errors:** 400 → `examples/error_400.json`

### POST /orders/checkout

- **Request:** `examples/orders_pay_post_request.json`
- **Success (201):** `examples/order_post_checkout_201.json`
- **Errors:** 400 → `examples/error_400.json`

---

## Payments Endpoints

### GET /payments

- **Success (200):** `examples/payments_get_200.json`

---

## Store Endpoints

### GET /store/timings

- **Success (200):** `examples/store_get_timings_200.json`

### PUT /store/timings

- **Request:** `examples/store_timings_put_request.json`
- **Success (200):** `examples/store_put_timings_200.json`
- **Errors:** 400 → `examples/error_400.json`

---

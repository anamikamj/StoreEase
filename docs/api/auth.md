# Authentication & Authorization Overview

This document describes the authentication and authorization mechanisms used in the StoreEase API.

## Authentication

All API endpoints require authentication except for registration and login.

- **Login:** `POST /auth/login`
  - Request: username + password
  - Response: JWT token + refresh token

- **Logout:** `POST /auth/logout`
  - Invalidate current token

- **Token Refresh:** `POST /auth/refresh`
  - Request: refresh token
  - Response: new JWT token + refresh token

- **Register:** `POST /auth/register`
  - Request: username, password, email
  - Response: confirmation of registration

## Authorization

Endpoints may have role-based access:

- **User:** Can access their cart, orders, notifications, and profile
- **Admin:** Can manage items, orders, and store settings

### Example Header

\`\`\`
Authorization: Bearer <JWT_TOKEN>
\`\`\`

### Notes

- Tokens expire after a defined period.
- Refresh tokens are used to get new access tokens without logging in again.

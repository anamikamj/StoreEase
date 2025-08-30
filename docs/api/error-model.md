# Standard Error Response Format

All API errors follow a consistent structure to make error handling easier for clients.

## Generic Error Structure

```json
{
  "error": "Short error message",
  "details": "Optional detailed explanation",
  "code": 400
}

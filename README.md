# Katalon Web Automation

Web UI automation testing portfolio menggunakan Katalon Studio + Groovy.  
Target aplikasi: [ParaBank](https://parabank.parasoft.com) (simulasi aplikasi perbankan).

## Tech Stack
- Katalon Studio 10.2.4
- Groovy
- Locator strategy: XPath, CSS Selector
- CI/CD: Azure Pipelines

## Test Coverage

### Authentication
| Test Case | Scenario | Expected |
|-----------|----------|----------|
| TC-01 | Login valid | Redirect ke account overview |
| TC-02 | Login invalid | Error message tampil |

### Register
| Test Case | Scenario | Expected |
|-----------|----------|----------|
| TC-03 | Register user baru | Welcome message tampil |
| TC-04 | Register username duplikat | Error message tampil |

### Transfer
| Test Case | Scenario | Expected |
|-----------|----------|----------|
| TC-TRF-01 | Transfer dengan amount valid | "Transfer Complete!" |
| TC-TRF-02 | Transfer tanpa amount | Error message tampil |

### Find Transaction
| Test Case | Scenario | Expected |
|-----------|----------|----------|
| TC-FTR-01 | Cari transaksi by amount | Result table tampil |
| TC-FTR-02 | Cari transaksi by date | Result table tampil |

### Loan
| Test Case | Scenario | Expected |
|-----------|----------|----------|
| TC-Loan-01 | Request loan valid | Status "Approved" |

## Key Patterns
- **Custom Keyword** — `WebHelper.groovy` untuk reusable login flow
- **Object Repository** — semua locator tersentralisasi, dipisah per module
- **Modular Structure** — Scripts, Object Repository, dan Keywords diorganisir per fitur

## How to Run
1. Clone repo
2. Buka di Katalon Studio
3. Jalankan: `Test Suites/TS-Web_Regession`

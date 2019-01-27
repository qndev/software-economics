### Use Case Points (UCP)

* ####  Unadjusted Use Case Weight (UUCW)

| Use Case Classification | No. of Transactions       | Weight     |
| ----------------------- | ------------------------- | ---------- |
| Simple                  | 1 to 3 transactions       | 5          |
| Average                 | 4 to 7 transactions       | 10         |
| Complex                 | 8 or more transactions    | 15         |

* #### Unadjusted Actor Weight (UAW)

| Actor Classification    | Type of Actor                                                                              | Weight     |
| ----------------------- | ------------------------------------------------------------------------------------------ | ---------- |
| Simple                  | External system that must interact with the system using a well-defined API                | 1          |
| Average                 | External system that must interact with the system using standard communication protocols  | 2          |
| Complex                 | Human actor using a GUI application interface                                              | 3          |

* #### Technical Complexity Factor (TCF)

  #### TCF = 0.6 + (TF/100)

| Factor    | Description                           | Weight     |
| --------- | ------------------------------------- | ---------- |
| T1        | Distributed system                    | 2.0        |
| T2        | Response time/performance objectives  | 1.0        |
| T3        | End-user efficiency                   | 1.0        |
| T4        | Internal processing complexity        | 1.0        |
| T5        | Code reusability                      | 1.0        |
| T6        | Easy to install                       | 0.5        |
| T7        | Easy to use                           | 0.5        |
| T8        | Portability to other platforms        | 2.0        |
| T9        | System maintenance                    | 1.0        |
| T10       | Concurrent/parallel processing        | 1.0        |
| T11       | Security features                     | 1.0        |
| T12       | Access for third parties              | 1.0        |
| T13       | End user training                     | 1.0        |

* #### Environmental Complexity Factor (ECF)

  #### ECF = 1.4 + (-0.03 x EF)

| Factor    | Description                                | Weight     |
| --------- | ------------------------------------------ | ---------- |
| E1        | Familiarity with development process used  | 1.5        |
| E2        | Application experience                     | 0.5        |
| E3        | Object-oriented experience of team         | 1.0        |
| E4        | Lead analyst capability                    | 0.5        |
| E5        | Motivation of the team                     | 1.0        |
| E6        | Stability of requirements                  | 2.0        |
| E7        | Part-time staff                            | -1.0       |
| E8        | Difficult programming language             | -1.0       |

* #### Use Case Points (UCP)

  #### UCP = (UUCW + UAW) x TCF x ECF

* #### Unadjusted Use Case Weight (UUCW)
 
  #### UUCW = (Total No. of Simple Use Cases x 5) + (Total No. Average Use Cases x 10) + (Total No. Complex Use Cases x 15)

* #### Unadjusted Actor Weight (UAW)

  #### UAW = (Total No. of Simple Actors x 1) + (Total No. Average Actors x 2) + (Total No. Complex Actors x 3)

* #### Use Case Points (UCP)

  #### UCP = (UUCW + UAW) x TCF x ECF

* #### Review App Demo


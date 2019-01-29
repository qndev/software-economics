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

  * #### ECF = 1.4 + (-0.03 x EF)

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

  
  * #### Corresponding interpolation values (S) of Environmental Complexity Factor (ECF)

  | Result    | Interpolation value (S)  |
  | --------- | ------------------------ |
  | > 0       | 0.05                     |
  | > 1       | 0.1                      |
  | > 2       | 0.6                      |
  | > 3       | 1.0                      |

  * #### Experience Stability Estimate (ES)

  $$ES = \sum_{i=1}^8 S_i$$

  | Result    | Estimate duration (P - hours per use case point)    |
  | --------- | --------------------------------------------------- |
  | < 1       | 48                                                  |
  | >= 1      | 32                                                  |
  | >= 3      | 20                                                  |

* #### Unadjusted Use Case Weight (UUCW)
 
  #### UUCW = (Total No. of Simple Use Cases x 5) + (Total No. Average Use Cases x 10) + (Total No. Complex Use Cases x 15)

* #### Unadjusted Actor Weight (UAW)

  #### UAW = (Total No. of Simple Actors x 1) + (Total No. Average Actors x 2) + (Total No. Complex Actors x 3)

* #### Use Case Points (UCP - AUCP)

  #### UCP(AUCP) = (UUCW + UAW) x TCF x ECF (UCP)

* #### Estimate Effort (EE)

  #### EE = AUCPxP (Hours)

* #### Step by step Use Case Points Methods

  ![New Project](/images/UseCasePointsMethod.png)

* #### Review App Demo

  * #### Create New Project
  ![New Project](/images/project.png)
  
  * #### Use Case & Actor
  ![New Project](/images/usecase.png)
  
  * #### Technical Complexity Factor
  ![New Project](/images/tcf.png)
  
  * #### Environmental Complexity Factor
  ![New Project](/images/ecf.png)
  
  * #### Estimate Effort
  ![New Project](/images/effort.png)

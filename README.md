# surlizer

> Simple Url Shortener in stage-wise implementation to improve performance

- Stage 1 : functional correctness, in memory storage
- Stage 2 : Migration to DB
- Stage 3 : in memory cache
## Performance Risk Analysis

1. for stage 1 : could find a breaking point to system
    - a breaking point where in memory map will not be able to handle data and the server could go out of memory
2. for stage 2 : could see increase in response time
    - after adding a db, expect to see increase in response time due to read/write time in storage
3. for stage 3 : could encounter bottleneck at cache update query
    - after adding cache, we may see a decrease in retrieval time, but may need to optimise cache update

## Stage - 1

available heap memory - 52Mb

### test scenario 1

#### flow

each user creates a short url and retrieves the same (redirection time not included)

#### input - 1
number of urls : 500
number of user : 50
iterations : 10

#### result - 1.1.

| **transaction**    | **samples** | **avg** | **min** | **max** | **std. Dev**       | **error** | **throughput**     |
|--------------------|-------------|---------|---------|---------|--------------------|-----------|--------------------|
| create short url   | 500         | 4       | 1       | 339     | 16.08548861551927  | 0.0       | 26.499894000424    |
| retreive short url | 500         | 2       | 1       | 26      | 1.683111404512488  | 19.4%     | 26.981814257190656 |
| TOTAL              | 1000        | 3       | 1       | 339     | 11.496969339786897 | 09.7%     | 52.99417064122946  |

> !!! Bug : wrong retrieval 
> $$$ Fix : replaces HashMap with ConcurrentHashMap

#### result - 1.2.

| **transaction**    | **samples** | **avg** | **min** | **max** | **std. Dev**       | **error** | **throughput**     |
|--------------------|-------------|---------|---------|---------|--------------------|-----------|--------------------|
| create short url   | 500         | 1       | 0       | 5       | 0.7896809482316257 | 0.0       | 26.48585655260091  |
| retreive short url | 500         | 0       | 0       | 2       | 0.5156549233741495 | 2.6%      | 26.490066225165563 |
| TOTAL              | 1000        | 1       | 0       | 5       | 0.7513081924217251 | 1.3%      | 52.96610169491526  |

> error rate reduced, but not eradicated


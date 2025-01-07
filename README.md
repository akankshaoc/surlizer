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



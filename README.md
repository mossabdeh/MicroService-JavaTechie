# Tutorial: Building a Microservices Architecture with Spring Cloud

Follow the video step by step: [Link to the video](https://www.youtube.com/watch?v=tljuDMmfJz8)

**Note:** Step 4 is optional (Hystrix part).

## Tutorial Agenda:
1. Create 2 microservices from scratch
2. Register microservices in the Eureka Service Discovery
3. Integrate Spring Cloud Gateway for routing user requests
4. *(Optional)* Integrate Hystrix & Hystrix Dashboard to identify failures for downstream services
5. Use Spring Cloud Config Server using Git to centralize configuration across applications
6. Implement ELK Stack to centralize logging across all microservices
7. Use Zipkin & Sleuth to centralize tracing in microservices architecture

## Additional Information:

- **Netflix Hystrix in Spring:** It is a fault tolerance library used to handle fault tolerance issues at the application level.

- **ELK Stack:**
    - *Elasticsearch:* A search and analytics engine.
    - *Logstash:* A server-side pipeline for data processing (ETL type). Its mission is to simultaneously ingest data from a multitude of sources, transform it, and send it to a storage system like Elasticsearch.
    - *Kibana:* Allows users to visualize data with tables and graphs in Elasticsearch.
---

**Note to Readers:**
If you're interested in a deeper exploration of the topics covered in this tutorial, I've written an essay that delves into the concepts and provides additional insights. You can find the essay in the repository's PDF file. [Link to the PDF](./path/to/your/file.pdf)

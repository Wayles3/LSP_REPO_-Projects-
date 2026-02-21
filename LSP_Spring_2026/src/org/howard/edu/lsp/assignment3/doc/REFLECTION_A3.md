# Assignment 3 Reflection

## Design Differences
In Assignment 2, my implementation was largely procedural within a single main method. 
In Assignment 3, I decomposed the logic into specific classes (Product, CSVReader, 
[span_7](start_span)DataTransformer, CSVWriter) each with a single responsibility[span_7](end_span).

## OO Concepts Used
* **[span_8](start_span)Encapsulation**: Used private fields in the Product class accessed via getters and setters[span_8](end_span).
* **Abstraction**: The ETLPipeline class interacts with the Transformer without needing 
[span_9](start_span)to know the internal logic of the transformation[span_9](end_span).

## Testing
I verified correctness by comparing the output of `transformed_products.csv` from 
[span_10](start_span)this assignment against my Assignment 2 output to ensure they are identical[span_10](end_span).

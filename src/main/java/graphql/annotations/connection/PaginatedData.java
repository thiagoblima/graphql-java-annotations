/**
 * Copyright 2016 Yurii Rashkovskii
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 */
package graphql.annotations.connection;

/**
 * This class is the result of a connection. Every Graphql connection field must return this interface
 * <p>
 * NOTE: this interface extends Iterable. The data is retrieved from the "iterator" function.
 * Please implement the iterator with data structure that has order
 *
 * @param <T> the data of which we paginated over
 */
public interface PaginatedData<T> extends Iterable<T> {

    /**
     * Whether or not this is the last page
     *
     * @return true if there is a next page, false otherwise
     */
    boolean hasNextPage();

    /**
     * Whether or not this is the first page
     *
     * @return true if there is a previous page, false otherwise
     */
    boolean hasPreviousPage();

    /**
     * get the encoded cursor of the entity
     *
     * @param entity the entity
     * @return String representation of the cursor of the entity
     */
    String getCursor(T entity);
}

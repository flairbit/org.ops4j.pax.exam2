/*
 * Copyright 2017 Harald Wellmann
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.ops4j.pax.exam.regression.javaee;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ops4j.pax.exam.invoker.junit5.PaxExam;
import org.ops4j.pax.exam.sample1.model.Book;
import org.ops4j.pax.exam.sample1.service.LibraryService;

@ExtendWith(PaxExam.class)
public class TitleTest {

    @Inject
    private LibraryService service;

    @Test
    public void byTitle() {
        List<Book> books = service.findBooksByTitle("East of Eden");
        assertThat(books).hasSize(1);

        Book book = books.get(0);
        assertThat(book.getAuthor().getLastName()).isEqualTo("Steinbeck");
    }
}
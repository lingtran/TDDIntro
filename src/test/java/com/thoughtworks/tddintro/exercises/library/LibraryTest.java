package com.thoughtworks.tddintro.exercises.library;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private BufferedReader bufferedReader;
    private String titleOne;
    private String titleTwo;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(books, printStream, bufferedReader);
        titleOne = "The Fellowship of the Ring";
        titleTwo = "The Return of the King";
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        books.add(titleOne);

        library.listBooks();

        verify(printStream).println(titleOne + "\n");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library.listBooks();

        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        books.add(titleOne);
        books.add(titleTwo);

        library.listBooks();

        String result = String.format("%s\n%s\n", titleOne, titleTwo);

        verify(printStream).println(result);
    }

    @Test
    public void shouldAddBookToCollectionWhenEnteredByUser() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Hobbit");
        library.enterBook();
        assertThat(books, hasItems("The Hobbit"));
    }

    @Test
    public void shouldDeleteBookFromCollectionWhenRemovedByUser() throws IOException {
        String titleThree = "The Two Towers";
        books.add(titleThree);

        assertThat(books, hasItems(titleThree));

        when(bufferedReader.readLine()).thenReturn(titleThree);
        library.removeBook();

        assertThat(books, not(hasItems(titleThree)));
    }
}

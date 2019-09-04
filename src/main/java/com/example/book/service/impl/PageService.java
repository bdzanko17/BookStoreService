package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.model.EntityInput.PageEntityInput;
import com.example.book.model.Page;
import com.example.book.repository.BookRepository;
import com.example.book.repository.PageRepository;
import com.example.book.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageService implements IPageService {

    private PageRepository pageRepository;
    private BookRepository bookRepository;

    @Autowired
    public PageService(PageRepository pageRepository, BookRepository bookRepository) {
        this.pageRepository = pageRepository;
        this.bookRepository = bookRepository;
    }


    public Page savePage(PageEntityInput pagee) {
       Optional<Book> bookOptional =  bookRepository.getBookEntityById(pagee.getBookID());
       if(bookOptional.isPresent()){
           Page page2Save  = new Page();
           page2Save.setContent(pagee.getContent());
           page2Save.setOrdinalNumber(pagee.getOrdinalNumber());
           page2Save.setBook(bookOptional.get());
           return pageRepository.save(page2Save);

       }else  throw new IllegalAccessError("There is no book with that ID");
    }

    public Page getPage(Long id) {
        Optional<Page> pageeOptional = pageRepository.getPageEntityById(id);
        if(pageeOptional.isPresent())
        return pageRepository.getOne(id);
        else throw new IllegalStateException();
    }

    @Override
    public void deletePage(Long id) {
        pageRepository.delete(pageRepository.getOne(id));
    }

    @Override
    public List<Page> getPages() {
        return  pageRepository.findAll();
    }

}
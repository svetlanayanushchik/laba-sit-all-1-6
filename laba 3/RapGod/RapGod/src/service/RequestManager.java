package service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import entity.Author;
import entity.News;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;


public class RequestManager {

    private static String SQL_SELECT_ALL = "from Author";
    private static String SQL_SELECT_NEWS_BY_ID = "from News where newsId = 1";
    private static EntityManager entityManager;

    private static RequestManager requestManager = new RequestManager();

    private RequestManager() {
        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory =
                persistenceProvider.createEntityManagerFactory("NewPersistenceUnit", new HashMap());
        entityManager = entityManagerFactory.createEntityManager();
    }

    public String selectAll(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        List<Author> authors = entityManager.
                createQuery(SQL_SELECT_ALL, Author.class).getResultList();
        servletRequest.setAttribute("authorList", authors);
        return "/selectAllAuthors.jsp";
    }

    public String selectNewsById(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

        News news = entityManager.
                createQuery(SQL_SELECT_NEWS_BY_ID, News.class).getSingleResult();
        servletRequest.setAttribute("news", news);
        return "/selectNewsById.jsp";
    }

    public static RequestManager getInstance() {
        return requestManager;
    }
}

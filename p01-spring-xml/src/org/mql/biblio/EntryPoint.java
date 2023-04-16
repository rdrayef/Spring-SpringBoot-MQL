package org.mql.biblio;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.models.Author;
import org.mql.biblio.web.actions.AuthorController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

public class EntryPoint {
	private ApplicationContext context;

	public EntryPoint() {
		init();
		exp02();
	}

	void init() {
		// Chargement du contexte
		context = new ClassPathXmlApplicationContext("beans.xml");

	}

	void exp01() {
		System.out.println("exp01()");
		Author a1 = context.getBean("a1", Author.class);
		System.out.println(a1);
	}

	void exp02() {
		AuthorDao dao = context.getBean("authorDaoMemory", AuthorDao.class);
		List<Author> authors = dao.selectAll();

		for (Author author : authors) {
			System.out.println(author);
		}
	}

	void exp03() {
		BiblioService service = context.getBean(BiblioService.class);
		List<Author> authors = service.authors();

		for (Author author : authors) {
			System.out.println(author.getName());
		}
	}

	void exp04() {
		class TestModel implements Model {
			private Hashtable<String, Object> atts = new Hashtable<String, Object>();

			public Model addAllAttributes(Collection<?> attributeValues) {
				return null;
			}

			public Model addAllAttributes(Map<String, ?> attributes) {
				return null;
			}

			public Model addAttribute(Object attributeValue) {
				return null;
			}

			public Model addAttribute(String name, Object model) {
				atts.put(name, model);
				return this;
			}

			public Map<String, Object> asMap() {
				return null;
			}

			public boolean containsAttribute(String attributeName) {
				return false;
			}

			@Override
			public Object getAttribute(String name) {
				return atts.get(name);
			}

			@Override
			public Model mergeAttributes(Map<String, ?> attributes) {
				// TODO Auto-generated method stub
				return null;
			}

		}
		AuthorController controller = context.getBean(AuthorController.class);

		TestModel model = new TestModel();
		String view = controller.getAllAuthors(model);
		System.out.println("view: " + view);
		List<Author> authors = (List<Author>) model.getAttribute("authors");

		for (Author author : authors) {
			System.out.println(author.getName());
		}
	}

	public static void main(String[] args) {
		new EntryPoint();
	}

}

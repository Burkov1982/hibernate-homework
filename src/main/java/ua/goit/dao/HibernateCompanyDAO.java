package ua.goit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.goit.dao.model.Company;

import java.util.List;

public class HibernateCompanyDAO {
    private final SessionFactory sessionFactory;

    public HibernateCompanyDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Company findById(Integer id) throws Exception{
        Company company = null;
        try (Session session = sessionFactory.openSession()) {
            company = session.get(Company.class, id);
            System.out.println(company.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    public void create(Company company) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.save(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Company company) throws Exception{
        try (Session session = sessionFactory.openSession()) {
            session.update(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Company company) throws Exception{
        try (Session session = sessionFactory.openSession()) {
            session.delete(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Company> getAll() throws Exception{
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT a FROM Company a", Company.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

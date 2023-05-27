package org.acme;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class dataConnectorService {
   
	@Inject
	EntityManager em;
	
	
	
	@Transactional
	public void AutoTransact(String user_id, Double spending, calendar cal, String filepath) {
		userPortfolio portfolio = em.find(userPortfolio.class, user_id);
        cal.refreshDate();
		if(portfolio!=null) {
			if(portfolio.getUser_id().equals(user_id)) {
			System.out.println("data not null, data exists "+portfolio.getUser_id());
			//i didnt add first joined that i assume no error on this
			String current_year = portfolio.getCurrent_year();
			String current_month = portfolio.getCurrent_month();
		    String current_week = portfolio.getCurrent_week();
			String current_day = portfolio.getCurrent_day();

			String last_updated_date = portfolio.getLast_updated_date();
			Double yearly_spent = portfolio.getCurrentYearSpent();
			Double monthly_spent = portfolio.getCurrentMonthSpent();
			Double weekly_spent = portfolio.getCurrentWeekSpent();
			Double daily_spent = portfolio.getCurrentDaySpent();
			
			if(!current_year.equals(cal.getYear())) {
				yearly_spending_data year = new yearly_spending_data();
				year.setYear(current_year);
				year.setUser_id(user_id);
				year.setYear_spent(yearly_spent);
				em.persist(year);
				current_year = cal.getYear();
				portfolio.setCurrent_year(current_year);
				yearly_spent = 0.0;
				System.out.println("updated year");
				}
			if(!current_month.equals(cal.getMonthOfYear())) {
				monthly_spending_data month = new monthly_spending_data();
				month.setMonth_of_year(current_month);
				month.setUser_id(user_id);
				month.setMonth_spent(monthly_spent);
				em.persist(month);
				current_month = cal.getMonthOfYear();
				portfolio.setCurrent_month(current_month);
				monthly_spent = 0.0;
				System.out.println("updated month");
			}
			if(!current_week.equals(cal.getWeekofMonth())) {
				weekly_spending_data week = new weekly_spending_data();
				week.setWeek_of_month_year(current_week);
				week.setUser_id(user_id);
				week.setWeek_spent(weekly_spent);
				em.persist(week);
				current_week = cal.getWeekofMonth();
				portfolio.setCurrent_week(current_week);
				weekly_spent = 0.0;
				System.out.println("updated week");
				
			}
			if(!current_day.equals(cal.getDate())) {
				daily_spending_data day = new daily_spending_data();
				day.setDate(current_day);
				day.setUser_id(user_id);
				day.setDaily_spent(daily_spent);
				em.persist(day);
				current_day = cal.getDate();
				portfolio.setCurrent_day(current_day);
				daily_spent = 0.0;
				System.out.println("updated day");
			}
			yearly_spent += spending;
			monthly_spent += spending;
			weekly_spent += spending;
			daily_spent += spending;
			last_updated_date = cal.getFullDate();
			portfolio.setCurrentYearSpent(yearly_spent);
			portfolio.setCurrentMonthSpent(monthly_spent);
			portfolio.setCurrentWeekSpent(weekly_spent);
			portfolio.setCurrentDaySpent(daily_spent);
			portfolio.setLast_updated_date(last_updated_date);
			em.merge(portfolio);
			System.out.println("portfolio update succeed");
		 }
		}
		  if(portfolio==null) {
			  portfolio = new userPortfolio();
			  System.out.println("data not exists, creating new data");
			  portfolio.setUser_id(user_id);
			  portfolio.setFirst_joined_date(cal.getFullDate());
			  portfolio.setLast_updated_date(cal.getFullDate());
			  portfolio.setCurrent_year(cal.getYear());
			  portfolio.setCurrent_month(cal.getMonthOfYear());
			  portfolio.setCurrent_week(cal.getWeekofMonth());
			  portfolio.setCurrent_day(cal.getDate());
			  portfolio.setCurrentYearSpent(spending);
			  portfolio.setCurrentMonthSpent(spending);
			  portfolio.setCurrentWeekSpent(spending);
			  portfolio.setCurrentDaySpent(spending);
			  em.persist(portfolio);
		  }
		    spending_info spend = new spending_info();
		    spend.setUser_ID(user_id);
		    spend.setTotal_price(spending);
		    spend.setfilepath(filepath);
		    spend.setDate(cal.getFullDate());
		    em.persist(spend);
		    System.out.println("user_spent recorded");
		     
			
		
		
		
	}
	public userPortfolio findPortfolio(String user_id) {
		userPortfolio portfolio = em.find(userPortfolio.class, user_id);
		if(portfolio!=null) {
			return portfolio;
		}
	return null;
	}
	
	public List<yearly_spending_data> listUserYearlySpending(String userId) {
	    CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<yearly_spending_data> query = builder.createQuery(yearly_spending_data.class);
	    Root<yearly_spending_data> root = query.from(yearly_spending_data.class);
	    
	    // Add predicates to filter by user_id
	    Predicate userIdPredicate = builder.equal(root.get("user_id"), userId);
	    query.where(userIdPredicate);
	    
	    // Order by date in descending order
	    query.orderBy(builder.desc(root.get("year")));
	    
	    // Execute query
	    TypedQuery<yearly_spending_data> typedQuery = em.createQuery(query);
	    List<yearly_spending_data> userSpendings = typedQuery.getResultList();
	    for(int i =0; i<userSpendings.size();i++) {
	    	System.out.println("User : " +userSpendings.get(i).getUser_id()+" Year : "+userSpendings.get(i).getYear()+" spent :"+ userSpendings.get(i).getYear_spent());
	    }
	    
	    return userSpendings;
	}
}

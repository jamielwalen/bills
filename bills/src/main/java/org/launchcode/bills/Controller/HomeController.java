package org.launchcode.bills.Controller;

import org.launchcode.bills.Models.Bills;
import org.launchcode.bills.Models.Data.BillsCreationDTO;
import org.launchcode.bills.Models.MonthlyBill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.launchcode.bills.Models.Data.BillsDao;
import org.launchcode.bills.Models.Data.MonthlyBillDao;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping(value = {"home",""})
public class HomeController {

    @Autowired
    private BillsDao billsDao;

    @Autowired
    private MonthlyBillDao monthlyBillDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String monthlyBillFormAdd(Model model) {

        BillsCreationDTO bto = new BillsCreationDTO();
        BillsCreationDTO bto2 = new BillsCreationDTO();
        for (Bills bill : billsDao.findAll()) {
            String a = bill.getDtype();
            if (a == null) {
                bto.addBills(bill);
            }


        }

        model.addAttribute("title", "Bills");
        model.addAttribute("bto", bto);
        return "bills/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processAddMonthlyBillForm(@ModelAttribute BillsCreationDTO bto,
                                            //Errors errors,
                                            Model model) {

        System.out.println("this is really really stupid");
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Bills");
//            System.out.println("this is really really stupid");
//            return "bills/index";
//        }
        for (Bills bill : billsDao.findAll()) {
            String a = bill.getDtype();
            if (a == null) {
                bto.addBills(bill);
            }}

            for (MonthlyBill bill2 : bto.getBills()) {
                bill2.setMonth(bto.getMonth());
                bill2.setDtype("MonthlyBill");
                bill2.setYear(bto.getYear());
                bill2.setAmount((float) bto.getAmount());
                monthlyBillDao.save(bill2);
            }



//        for (MonthlyBill bill : bto.getBills()) {
//            //bill.setAmount(10);
//
//            monthlyBillDao.save(bill);
//            System.out.println(bill.getName());
//        }
////        for (Integer billId : billsIds) {
////            monthlyBill.setName(bills.getName(billsDao.findById(billId)));
////            monthlyBill.setBusiness(bills.getBusiness(billsDao.findById(billId)));
////            monthlyBill.setType(bills.getType(billsDao.findById(billId)));
////            monthlyBill.setWebsite(bills.getWebsite(billsDao.findById(billId)));
////
////            monthlyBillDao.save(monthlyBill);
////        }


            return "redirect:/home";
        }
    }







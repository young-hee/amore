/*
 * This software is the confidential and proprietary information of
 * UZEN Co.,Ltd., Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with UZEN.
 */
package kr.ap.comm.support.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * @author Ria@g1project.net
 * @since {version}
 *
 */

@Component
public class CSFormValidator implements Validator{

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub
        
        if (target == null)
            return;
        
        /*if (target instanceof InquiryForPost) {
            
            hasErrors(checkTitle(errors, inquiryForPost.getInquiryTitle(), "inquiryTitle"));
            hasErrors(checkBody(errors, inquiryForPost.getInquiryBodyText(), "inquiryBodyText"));
            hasErrors(checkEmail(errors, inquiryForPost.getCustomerEmailAddress()));
            hasErrors(checkCellNum(errors, inquiryForPost.getCustomerPhoneNo1().getPhoneNo()));
        }else if (target instanceof ReviewForPost) {
            ReviewForPost reviewForPost = (ReviewForPost)target;
            
            hasErrors(checkTitle(errors, reviewForPost.getProdReviewTitle(), "prodReviewTitle"));
            hasErrors(checkBody(errors, reviewForPost.getProdReviewBodyText(),"prodReviewBodyText"));*/
       // }
        
    }

    @Override
    public boolean supports(Class clazz) {
        // TODO Auto-generated method stub
        return true; 
    }
        
    private boolean hasErrors(Errors errors) {
        if (errors.hasErrors()) {
            return true;
        }
        return false;
    }
    
    private Errors checkCellNum(Errors errors, String cellNum) {
        String regex = "(010|011|016|017|018|019)\\d{7,8}";
        if (!cellNum.isEmpty() && !Pattern.matches(regex, cellNum)) {
            errors.rejectValue("customerPhoneNo1.phoneNo", "error.format.cellNum", "전화번호를 정확히 입력해 주세요.");
        }
        return errors;
    }
    
    private Errors checkEmail(Errors errors, String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (email != null && !email.isEmpty() && !Pattern.matches(regex, email)) {
            errors.rejectValue("customerEmailAddress", "error.format.email", "유효한 email형식이 아닙니다.");
        }
        return errors;
    }
    
    private Errors checkTitle(Errors errors, String title, String field) {
        if(StringUtils.isEmpty(title)) {
            errors.rejectValue(field, "error.null.title", "제목을 입력해주세요");
        } else {
            String regex = "^[\\s]*$";
            if(Pattern.matches(regex, title)) {
                errors.rejectValue(field, "error.format.title", "제목을 입력해주세요");
            }
        }
        
        return errors;
    }
    
    private Errors checkBody(Errors errors, String body, String field) {
        if(StringUtils.isEmpty(body)) {
            errors.rejectValue(field, "error.null.body", "내용을 입력해주세요");
        } else {
            String regex = "^[\\s]*$";
            if(Pattern.matches(regex, body)) {
                errors.rejectValue(field, "error.format.body", "내용을 입력해주세요");
            }
        }
        
        return errors;
    }
}

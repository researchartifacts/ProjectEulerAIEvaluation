package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class Haiku45OneByOneQ22 {

    public ResponseDto Question22() {
        ResponseDto responseDto = new ResponseDto();
        String[] names = {"MARY","PATRICIA","JENNIFER","LINDA","BARBARA","ELIZABETH","SUSAN","JESSICA","SARAH","KAREN","NANCY","BETTY","MARGARET","SANDRA","ASHLEY","KIMBERLY","EMILY","DONNA","MICHELLE","DOROTHY","CAROL","AMANDA","MELISSA","DEBORAH","STEPHANIE","REBECCA","SHARON","LAURA","CYNTHIA","KATHLEEN","AMY","ANGELA","SHIRLEY","ANNA","BRENDA","PAMELA","EMMA","NICOLE","HELEN","SAMANTHA","KATHERINE","CHRISTINE","DEBRA","RACHEL","CATHERINE","CAROLYN","JANET","RUTH","MARIA","HEATHER","DIANE","VIRGINIA","JULIE","JOYCE","VICTORIA","OLIVIA","KELLY","CHRISTINA","LAUREN","JOAN","EVELYN","JUDITH","MEGAN","CHERYL","ANDREA","HANNAH","JACQUELINE","MARTHA","GLORIA","TERESA","ANN","SARA","MADISON","FRANCES","KATHRYN","JANICE","JEAN","ABIGAIL","ALICE","JULIA","JUDY","SOPHIA","GRACE","DENISE","AMBER","DORIS","MARILYN","DANIELLE","BEVERLY","ISABELLA","THERESA","DIANA","NATALIE","BRITTANY","CHARLOTTE","MARIE","KAYLA","ALEXIS"};
        Arrays.sort(names);
        long sum = 0;
        for (int i = 0; i < names.length; i++) {
            long nameValue = 0;
            for (char c : names[i].toCharArray()) {
                nameValue += c - 'A' + 1;
            }
            sum += nameValue * (i + 1);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}

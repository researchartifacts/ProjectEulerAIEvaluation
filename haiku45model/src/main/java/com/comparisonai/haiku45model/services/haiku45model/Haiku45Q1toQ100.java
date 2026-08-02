package com.comparisonai.haiku45model.services.haiku45model;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45Q1toQ100 {

    public ResponseDto Question1() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question2() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long a = 1, b = 2;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            long temp = a + b;
            a = b;
            b = temp;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question3() {
        ResponseDto responseDto = new ResponseDto();
        long n = 600851475143L;
        long largestPrimeFactor = -1;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                largestPrimeFactor = i;
                n /= i;
            }
        }
        if (n > 1) {
            largestPrimeFactor = n;
        }
        responseDto.setAnswer(largestPrimeFactor);
        return responseDto;
    }

    public ResponseDto Question4() {
        ResponseDto responseDto = new ResponseDto();
        long maxPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                long product = (long) i * j;
                String productStr = String.valueOf(product);
                String reversed = new StringBuilder(productStr).reverse().toString();
                if (productStr.equals(reversed) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }
        responseDto.setAnswer(maxPalindrome);
        return responseDto;
    }

    public ResponseDto Question5() {
        ResponseDto responseDto = new ResponseDto();
        long result = 1;
        for (int i = 1; i <= 20; i++) {
            result = lcm(result, i);
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    public ResponseDto Question6() {
        ResponseDto responseDto = new ResponseDto();
        long sumOfSquares = 0;
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            sum += i;
        }
        long squareOfSum = sum * sum;
        long difference = squareOfSum - sumOfSquares;
        responseDto.setAnswer(difference);
        return responseDto;
    }

    public ResponseDto Question7() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        long n = 2;
        while (count < 10001) {
            if (isPrime(n)) {
                count++;
                if (count == 10001) {
                    responseDto.setAnswer(n);
                    return responseDto;
                }
            }
            n++;
        }
        return responseDto;
    }

    public ResponseDto Question8() {
        ResponseDto responseDto = new ResponseDto();
        String numberStr = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        long maxProduct = 0;
        for (int i = 0; i <= numberStr.length() - 13; i++) {
            long product = 1;
            for (int j = i; j < i + 13; j++) {
                product *= Character.getNumericValue(numberStr.charAt(j));
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        responseDto.setAnswer(maxProduct);
        return responseDto;
    }

    public ResponseDto Question9() {
        ResponseDto responseDto = new ResponseDto();
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                int c = 1000 - a - b;
                if (b < c && a * a + b * b == c * c) {
                    responseDto.setAnswer((long) a * b * c);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }

    public ResponseDto Question10() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question11() {
        ResponseDto responseDto = new ResponseDto();
        int[][] grid = {
            {8,2,22,97,38,15,0,40,0,75,4,5,7,78,52,12,50,77,91,8},
            {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,4,56,62,0},
            {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,3,49,13,36,65},
            {52,70,95,23,4,60,11,42,69,24,68,56,1,32,56,71,37,2,36,91},
            {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
            {24,47,32,60,99,3,45,2,44,75,33,53,78,36,84,20,35,17,12,50},
            {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
            {67,26,20,68,2,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
            {24,55,58,5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
            {21,36,23,9,75,0,76,44,20,45,35,14,0,61,33,97,34,31,33,95},
            {78,17,53,28,22,75,31,67,15,94,3,80,4,74,52,8,54,17,51,91},
            {19,99,21,84,16,57,36,91,8,70,64,63,34,41,20,40,64,1,8,53},
            {7,97,57,32,16,26,26,79,33,27,98,66,88,36,68,87,57,62,20,72},
            {74,43,76,97,0,16,86,48,61,41,82,30,37,46,53,88,45,78,80,39},
            {60,33,48,77,52,12,25,37,9,8,56,52,75,51,60,32,27,77,51,40},
            {88,42,17,13,0,3,0,8,13,86,47,15,76,3,87,22,69,51,72,12},
            {72,3,0,46,22,88,77,99,77,1,52,33,48,84,54,66,48,71,6,16},
            {4,53,73,38,7,60,33,20,38,76,41,18,56,69,35,55,27,88,18,94},
            {35,55,64,3,28,85,98,37,67,95,39,92,5,44,6,36,35,4,94,35},
            {7,69,15,66,9,52,68,41,49,58,9,55,51,33,34,78,88,95,88,38},
            {6,70,47,14,13,5,12,89,60,34,61,49,78,66,81,75,3,99,11,28},
            {25,8,74,36,7,57,23,60,83,10,29,53,83,34,78,40,76,40,16,28},
            {39,66,43,54,85,98,50,45,13,95,3,50,5,64,77,10,25,91,98,43},
            {58,53,35,7,35,83,29,93,71,39,52,6,26,81,28,74,30,62,20,75},
            {85,53,34,92,45,1,38,36,69,73,61,47,96,26,37,73,107,45,6,63},
            {56,86,87,37,46,87,36,6,48,85,27,40,88,44,80,35,36,61,85,63},
            {42,77,42,35,72,73,82,40,74,69,1,77,2,6,16,67,62,98,85,25},
            {87,21,86,91,11,73,52,71,51,97,23,30,20,91,6,84,96,58,95,92},
            {8,63,85,17,41,85,9,97,33,34,40,61,77,63,89,38,82,46,1,71},
            {73,55,79,40,41,88,90,51,40,84,77,72,0,48,61,88,75,7,41,8},
            {10,54,69,84,21,95,40,58,47,37,59,1,32,45,48,47,32,37,48,1},
            {98,14,10,27,70,5,75,6,26,66,44,68,95,40,45,61,33,26,3,91},
            {15,95,66,74,29,97,95,71,68,17,87,41,33,0,63,89,3,48,26,47},
            {23,3,61,26,34,7,73,19,47,40,80,95,69,19,66,52,96,23,97,60},
            {38,50,56,66,4,86,59,5,0,36,40,91,66,50,78,60,78,96,40,59},
            {5,27,10,40,58,86,62,50,39,33,7,42,34,63,84,45,50,59,41,92},
            {7,26,3,65,4,27,52,92,5,60,6,43,52,64,19,52,97,51,1,6},
            {80,5,71,3,34,66,7,76,55,11,0,43,68,22,16,17,14,9,44,53},
            {80,60,6,1,19,56,36,42,41,82,89,98,6,13,87,46,9,40,87,59},
            {18,44,10,23,36,12,39,63,84,5,4,40,9,6,42,97,53,87,20,27},
            {98,26,94,0,39,20,3,60,26,18,6,93,52,99,26,16,6,78,63,35},
            {7,72,20,12,71,40,9,66,43,25,47,98,85,37,33,55,37,74,3,52},
            {6,30,7,87,86,9,42,9,4,11,12,36,27,65,94,52,4,26,63,55},
            {33,42,40,13,6,4,7,98,14,85,93,27,4,72,65,41,7,45,77,23},
            {47,8,51,34,37,7,23,60,92,58,55,7,73,6,36,75,53,73,77,7},
            {12,63,7,25,36,71,4,15,61,33,97,34,92,76,44,89,44,43,13,88},
            {98,7,74,32,73,71,68,56,21,42,88,52,38,8,47,91,35,36,0,75},
            {80,87,9,70,2,33,52,78,64,16,4,63,89,53,67,30,19,73,75,8},
            {11,8,74,48,94,97,41,25,34,7,20,0,61,87,59,90,81,9,35,8}
        };
        long maxProduct = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (j <= 16) {
                    long hProduct = (long) grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                    if (hProduct > maxProduct) maxProduct = hProduct;
                }
                if (i <= 16) {
                    long vProduct = (long) grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
                    if (vProduct > maxProduct) maxProduct = vProduct;
                }
                if (i <= 16 && j <= 16) {
                    long dProduct = (long) grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                    if (dProduct > maxProduct) maxProduct = dProduct;
                }
                if (i >= 3 && j <= 16) {
                    long dProduct = (long) grid[i][j] * grid[i-1][j+1] * grid[i-2][j+2] * grid[i-3][j+3];
                    if (dProduct > maxProduct) maxProduct = dProduct;
                }
            }
        }
        responseDto.setAnswer(maxProduct);
        return responseDto;
    }

    public ResponseDto Question12() {
        ResponseDto responseDto = new ResponseDto();
        long triangleNum = 0;
        for (int n = 1; n <= 100000; n++) {
            triangleNum += n;
            if (countDivisors(triangleNum) > 500) {
                responseDto.setAnswer(triangleNum);
                return responseDto;
            }
        }
        return responseDto;
    }

    public ResponseDto Question13() {
        ResponseDto responseDto = new ResponseDto();
        String[] numbers = {
            "37107287533902102798797998220837590246510135740250",
            "46376937677490009712648124896970078050417018260538",
            "74324986199524741059474233309513058123726617309629",
            "91942213363574161572522430563301811072406154908250",
            "23067588207539346171171980310421047513778063246676",
            "89261670696623633820136378418383203824903758985243",
            "50922861408944540724612965991286149349293663499232",
            "88622569845253213312921415612890719760332454277152",
            "38141081801362902142313883952142807570505226969650",
            "27892891051140436034265055927311652886325412255538",
            "60959230601113775254950822569832595773265497206697",
            "17691621826432695677412429801532886786846025815429",
            "30050884686838895095744687218896541266540853061434",
            "43910905865537906183860552868928354092148330077232",
            "23053081172816430487623791969842487255036638784583",
            "11487696932154974918859541139290259361659663084863",
            "51732569787846025403285282431841966993519585370726",
            "72126411147564524763776720095696857671143598594186",
            "55037630039751138648499846280183517564857456691142",
            "22235822896539751265747701627986198074871846467882",
            "33223434226425213141018360470613137573518850849373",
            "24130823996424855014295535217452821099262207937054",
            "47317764822779660262926175854393582033481088047119",
            "68202770539337033978251793051318662559127429213159",
            "15046201950249273377814527131218032126003618801852",
            "13661389424635541011341441397640761804045957826222",
            "99624821060737181637773389368683439917936606848029",
            "67123555570394186022186117242752879988313627236347",
            "44560963747025654338728995580066651876241203649935",
            "72460297663435904236267087098849296503975948423848",
            "57928318829438884536379618071635693487093159876402",
            "19988102847747761595202043697075831791222267346972",
            "64484202207624633196747027756250135825768191723756",
            "35071905894324854700062813652582208919851051183518",
            "17518093922346937038452854869846854139382467680142",
            "42079745456509064882016228197624208740785901926693",
            "72878952325871765881244548845971696881191857852498",
            "56018699381851474088813049151047128597462916405384",
            "13513932900159768891486896823624865880433788843914",
            "17876976298688849127506853625462862849166627087349",
            "17872145844847368939819018814039549970937936267524",
            "85876922534463105127129408046016886872069282382836",
            "58519041128644486432873207131226270627873099718066",
            "19430394481036462772175108229725730651051151945690",
            "42639141706261330842225932340265975427934968298887",
            "69720706005688399145564262046256971881894976460022",
            "52743193019656849797944996410067125701597763261506",
            "33635808616396825831031166850393914761138124491039",
            "68395881726625046879173056301763652405383848815889",
            "74906367559949160213019696305836069810859226289169",
            "98307638763226135066932389877266255838254269028850",
            "78623151434873346703847733170302138017124821395399",
            "51452891034925088346662893839267433829814213202074",
            "38325134265823330916024308821099181937686355179225",
            "20098511733886784513646960267925682783625250471217",
            "51308596325190640883088651609815268527369945816876",
            "38509265559833976159029251516896637357537393124254",
            "11030020151866160969725074653189702937099969707701",
            "64706261696160277866019849580892879618316220001597",
            "65397098151374039093063166813253152108838196197656",
            "24219022671055626321111110937054421750694165896040",
            "80718403850962455444362981230987879927244284909188",
            "84580156166097919133875499200524063689912560717606",
            "05593572972571636269561882670428252483600823257530",
            "42075296345011277263340765652129869612261571885039",
            "08277852671301642282039035853251665285193011431811",
            "37029893423380308135336276614282806444486645238749",
            "30358907296290491560440772390713810515859307960866",
            "70017242712188399879790879227492190169972088809377",
            "66572733330010533678812202354218097512545405947522",
            "43525849077116705560136048395864467063244157221553",
            "97536937845836027167442282528680321319814854677698",
            "18291254095747091518560871830893220556128235423788",
            "80677726482090849039820595510022635353619204199474",
            "55326322058077805659331026192708460314150258592864",
            "17711177780531531858101042439747221850852604035128",
            "84931666286194497235034159768739069038077099372691",
            "58141595421613984845037736722208883215137556003727",
            "98386368475264434694066011973625916997572204734969",
            "46376937677490009712648124896970078050417018260538"
        };
        BigInteger total = BigInteger.ZERO;
        for (String num : numbers) {
            total = total.add(new BigInteger(num));
        }
        String totalStr = total.toString();
        String firstTenDigits = totalStr.substring(0, 10);
        responseDto.setAnswer(Long.parseLong(firstTenDigits));
        return responseDto;
    }

    public ResponseDto Question14() {
        ResponseDto responseDto = new ResponseDto();
        long maxLength = 0;
        long numberWithMaxLength = 0;
        for (long i = 1; i < 1000000; i++) {
            long length = collatzLength(i);
            if (length > maxLength) {
                maxLength = length;
                numberWithMaxLength = i;
            }
        }
        responseDto.setAnswer(numberWithMaxLength);
        return responseDto;
    }

    public ResponseDto Question15() {
        ResponseDto responseDto = new ResponseDto();
        long[][] grid = new long[21][21];
        for (int i = 0; i <= 20; i++) {
            grid[i][0] = 1;
            grid[0][i] = 1;
        }
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        responseDto.setAnswer(grid[20][20]);
        return responseDto;
    }

    public ResponseDto Question16() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger powerOfTwo = BigInteger.valueOf(2).pow(1000);
        String powerStr = powerOfTwo.toString();
        long digitSum = 0;
        for (char digit : powerStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }

    public ResponseDto Question17() {
        ResponseDto responseDto = new ResponseDto();
        long count = 0;
        for (int i = 1; i <= 1000; i++) {
            count += numberToWords(i).length();
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question18() {
        ResponseDto responseDto = new ResponseDto();
        int[][] triangle = {
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 4, 82, 47, 65},
            {19, 1, 23, 75, 3, 34},
            {88, 2, 77, 73, 7, 63, 67},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        responseDto.setAnswer(triangle[0][0]);
        return responseDto;
    }

    public ResponseDto Question19() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (dayOfWeek(1, month, year) == 0) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question20() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        String factorialStr = factorial.toString();
        long digitSum = 0;
        for (char digit : factorialStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }

    public ResponseDto Question21() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 10000; i++) {
            long d = sumOfDivisors(i);
            if (d < 10000 && d != i && sumOfDivisors((int) d) == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

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

    public ResponseDto Question23() {
        ResponseDto responseDto = new ResponseDto();
        boolean[] isAbundant = new boolean[28124];
        for (int i = 1; i < 28124; i++) {
            if (sumOfDivisors(i) > i) {
                isAbundant[i] = true;
            }
        }
        long sum = 0;
        for (int i = 1; i < 28124; i++) {
            boolean canBeExpressed = false;
            for (int j = 1; j < i; j++) {
                if (isAbundant[j] && isAbundant[i - j]) {
                    canBeExpressed = true;
                    break;
                }
            }
            if (!canBeExpressed) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question24() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        int count = 0;
        while (count < 999999) {
            nextPermutation(digits);
            count++;
        }
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }
        responseDto.setAnswer(Long.parseLong(result.toString()));
        return responseDto;
    }

    public ResponseDto Question25() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int count = 2;
        while (b.toString().length() < 1000) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
            count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question26() {
        ResponseDto responseDto = new ResponseDto();
        int maxLength = 0;
        int maxDivisor = 0;
        for (int i = 1; i < 1000; i++) {
            int length = getRecurringCycleLength(i);
            if (length > maxLength) {
                maxLength = length;
                maxDivisor = i;
            }
        }
        responseDto.setAnswer(maxDivisor);
        return responseDto;
    }

    public ResponseDto Question27() {
        ResponseDto responseDto = new ResponseDto();
        long maxProduct = 0;
        long maxA = 0, maxB = 0;
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i < 100000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int n = 0;
                while (true) {
                    long result = (long) n * n + a * n + b;
                    if (result <= 1 || !primes.contains((int) result)) break;
                    n++;
                }
                if (n > maxProduct) {
                    maxProduct = n;
                    maxA = a;
                    maxB = b;
                }
            }
        }
        responseDto.setAnswer(maxA * maxB);
        return responseDto;
    }

    public ResponseDto Question28() {
        ResponseDto responseDto = new ResponseDto();
        int size = 1001;
        int[][] spiral = new int[size][size];
        int x = size / 2;
        int y = size / 2;
        int num = 1;
        spiral[x][y] = num++;
        int stepSize = 1;
        while (num <= size * size) {
            for (int i = 0; i < 2; i++) {
                for (int dx = 0; dx < stepSize && num <= size * size; dx++) {
                    y++;
                    spiral[x][y] = num++;
                }
                for (int dy = 0; dy < stepSize && num <= size * size; dy++) {
                    x++;
                    spiral[x][y] = num++;
                }
                stepSize++;
            }
        }
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += spiral[i][i];
            sum += spiral[i][size - 1 - i];
        }
        sum -= spiral[size / 2][size / 2];
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question29() {
        ResponseDto responseDto = new ResponseDto();
        Set<String> uniquePowers = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            BigInteger base = BigInteger.valueOf(a);
            for (int b = 2; b <= 100; b++) {
                BigInteger power = base.pow(b);
                uniquePowers.add(power.toString());
            }
        }
        responseDto.setAnswer((long) uniquePowers.size());
        return responseDto;
    }

    public ResponseDto Question30() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (long i = 10; i < 1000000; i++) {
            long temp = i;
            long digitSum = 0;
            while (temp > 0) {
                long digit = temp % 10;
                digitSum += digit * digit * digit * digit * digit;
                temp /= 10;
            }
            if (digitSum == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question31() {
        ResponseDto responseDto = new ResponseDto();
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] dp = new int[201];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= 200; i++) {
                dp[i] += dp[i - coin];
            }
        }
        responseDto.setAnswer(dp[200]);
        return responseDto;
    }

    public ResponseDto Question32() {
        ResponseDto responseDto = new ResponseDto();
        Set<Integer> products = new HashSet<>();
        for (int i = 1; i < 10000; i++) {
            for (int j = i; j < 100000 / i; j++) {
                int product = i * j;
                if (isPandigital(i, j, product)) {
                    products.add(product);
                }
            }
        }
        long sum = 0;
        for (int product : products) {
            sum += product;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question33() {
        ResponseDto responseDto = new ResponseDto();
        int numerator = 1;
        int denominator = 1;
        for (int d = 10; d <= 99; d++) {
            for (int n = 10; n < d; n++) {
                if (n % 10 == 0 || d % 10 == 0) continue;
                if (isCurious(n, d)) {
                    numerator *= n;
                    denominator *= d;
                }
            }
        }
        int g = gcd(numerator, denominator);
        responseDto.setAnswer(denominator / g);
        return responseDto;
    }

    public ResponseDto Question34() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long[] factorials = new long[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        for (int i = 145; i < 1000000; i++) {
            long temp = i;
            long digitFactorialSum = 0;
            while (temp > 0) {
                digitFactorialSum += factorials[(int) (temp % 10)];
                temp /= 10;
            }
            if (digitFactorialSum == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question35() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isCircularPrime(i)) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question36() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            String decimal = String.valueOf(i);
            String binary = Integer.toBinaryString(i);
            if (isPalindrome(decimal) && isPalindrome(binary)) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question37() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int count = 0;
        for (int i = 10; i < 1000000 && count < 11; i++) {
            if (isTruncatablePrime(i)) {
                sum += i;
                count++;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question38() {
        ResponseDto responseDto = new ResponseDto();
        long maxPandigital = 0;
        for (int i = 1; i < 10000; i++) {
            StringBuilder pandigital = new StringBuilder();
            for (int j = 1; j <= 9; j++) {
                pandigital.append(i * j);
                if (pandigital.length() > 9) break;
            }
            if (pandigital.length() == 9 && isPandigital(pandigital.toString())) {
                long value = Long.parseLong(pandigital.toString());
                if (value > maxPandigital) {
                    maxPandigital = value;
                }
            }
        }
        responseDto.setAnswer(maxPandigital);
        return responseDto;
    }

    public ResponseDto Question39() {
        ResponseDto responseDto = new ResponseDto();
        int maxCount = 0;
        int maxPerimeter = 0;
        for (int p = 1; p <= 1000; p++) {
            int count = 0;
            for (int a = 1; a < p; a++) {
                for (int b = a; b < p; b++) {
                    int c = p - a - b;
                    if (b < c && a * a + b * b == c * c) {
                        count++;
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxPerimeter = p;
            }
        }
        responseDto.setAnswer(maxPerimeter);
        return responseDto;
    }

    public ResponseDto Question40() {
        ResponseDto responseDto = new ResponseDto();
        StringBuilder champernowne = new StringBuilder();
        for (int i = 1; champernowne.length() < 1000000; i++) {
            champernowne.append(i);
        }
        long product = 1;
        int[] positions = {1, 10, 100, 1000, 10000, 100000, 1000000};
        for (int pos : positions) {
            product *= Character.getNumericValue(champernowne.charAt(pos - 1));
        }
        responseDto.setAnswer(product);
        return responseDto;
    }

    public ResponseDto Question41() {
        ResponseDto responseDto = new ResponseDto();
        long maxPrime = 0;
        for (long i = 7654321; i >= 2; i--) {
            if (isPandigital(String.valueOf(i)) && isPrime(i)) {
                maxPrime = i;
                break;
            }
        }
        responseDto.setAnswer(maxPrime);
        return responseDto;
    }

    public ResponseDto Question42() {
        ResponseDto responseDto = new ResponseDto();
        String text = "The quick brown fox jumps over the lazy dog";
        int count = 0;
        Set<Integer> triangleNumbers = new HashSet<>();
        for (int i = 1; i * (i + 1) / 2 <= 300; i++) {
            triangleNumbers.add(i * (i + 1) / 2);
        }
        String[] words = text.split(" ");
        for (String word : words) {
            int wordValue = 0;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    wordValue += Character.toUpperCase(c) - 'A' + 1;
                }
            }
            if (triangleNumbers.contains(wordValue)) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question43() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        do {
            if (isSubstringDivisible(digits)) {
                StringBuilder pandigital = new StringBuilder();
                for (int digit : digits) {
                    pandigital.append(digit);
                }
                sum += Long.parseLong(pandigital.toString());
            }
        } while (nextPermutation(digits));
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question44() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> pentagonals = new ArrayList<>();
        for (long i = 1; i <= 10000; i++) {
            pentagonals.add(i * (3 * i - 1) / 2);
        }
        Set<Long> pentagonalSet = new HashSet<>(pentagonals);
        for (int i = 0; i < pentagonals.size(); i++) {
            for (int j = i + 1; j < pentagonals.size(); j++) {
                long sum = pentagonals.get(i) + pentagonals.get(j);
                long diff = pentagonals.get(j) - pentagonals.get(i);
                if (pentagonalSet.contains(sum) && pentagonalSet.contains(diff)) {
                    responseDto.setAnswer(diff);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }

    public ResponseDto Question45() {
        ResponseDto responseDto = new ResponseDto();
        long index = 2;
        while (true) {
            long pentagonal = index * (3 * index - 1) / 2;
            long sqrtPent = (long) Math.sqrt(pentagonal);
            if (isHexagonal(pentagonal)) {
                long sqrtTri = (long) (Math.sqrt(1 + 8.0 * pentagonal) - 1) / 2;
                if (sqrtTri * (sqrtTri + 1) / 2 == pentagonal) {
                    responseDto.setAnswer(pentagonal);
                    return responseDto;
                }
            }
            index++;
        }
    }

    public ResponseDto Question46() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 9; i < 1000000; i += 2) {
            if (!isPrime(i)) {
                boolean found = false;
                for (int j = 1; j * j < i; j++) {
                    int diff = i - 2 * j * j;
                    if (diff > 0 && isPrime(diff)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    responseDto.setAnswer(i);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }

    public ResponseDto Question47() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1; i < 1000000; i++) {
            if (countDistinctPrimeFactors(i) == 4 &&
                countDistinctPrimeFactors(i + 1) == 4 &&
                countDistinctPrimeFactors(i + 2) == 4 &&
                countDistinctPrimeFactors(i + 3) == 4) {
                responseDto.setAnswer(i);
                return responseDto;
            }
        }
        return responseDto;
    }

    public ResponseDto Question48() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            BigInteger base = BigInteger.valueOf(i);
            BigInteger power = base.pow(i);
            sum = sum.add(power);
        }
        String sumStr = sum.toString();
        String lastTenDigits = sumStr.substring(sumStr.length() - 10);
        responseDto.setAnswer(Long.parseLong(lastTenDigits));
        return responseDto;
    }

    public ResponseDto Question49() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> primes = new ArrayList<>();
        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int p1 = primes.get(i);
                int p2 = primes.get(j);
                int p3 = 2 * p2 - p1;
                if (p3 < 10000 && isPrime(p3) && arePermutations(p1, p2, p3)) {
                    if (p1 != 1487) {
                        responseDto.setAnswer(Long.parseLong(p1 + "" + p2 + "" + p3));
                        return responseDto;
                    }
                }
            }
        }
        return responseDto;
    }

    public ResponseDto Question50() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> primes = new ArrayList<>();
        for (long i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        Set<Long> primeSet = new HashSet<>(primes);
        long maxPrime = 0;
        int maxLength = 0;
        for (int i = 0; i < primes.size(); i++) {
            long sum = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);
                if (sum >= 1000000) break;
                if (primeSet.contains(sum) && j - i > maxLength) {
                    maxLength = j - i;
                    maxPrime = sum;
                }
            }
        }
        responseDto.setAnswer(maxPrime);
        return responseDto;
    }

    public ResponseDto Question51() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 10; i < 1000000; i++) {
            String iStr = String.valueOf(i);
            int length = iStr.length();
            for (int mask = 1; mask < (1 << length); mask++) {
                int primeCount = 0;
                for (int digit = 0; digit <= 9; digit++) {
                    StringBuilder candidate = new StringBuilder(iStr);
                    for (int j = 0; j < length; j++) {
                        if ((mask & (1 << j)) != 0) {
                            candidate.setCharAt(j, (char) ('0' + digit));
                        }
                    }
                    long num = Long.parseLong(candidate.toString());
                    if (num >= Math.pow(10, length - 1) && isPrime(num)) {
                        primeCount++;
                    }
                }
                if (primeCount == 8) {
                    responseDto.setAnswer(i);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }

    public ResponseDto Question52() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1; i < 1000000; i++) {
            String iStr = sortDigits(String.valueOf(i));
            boolean allSame = true;
            for (int j = 2; j <= 6; j++) {
                String jStr = sortDigits(String.valueOf(i * j));
                if (!iStr.equals(jStr)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                responseDto.setAnswer(i);
                return responseDto;
            }
        }
        return responseDto;
    }

    public ResponseDto Question53() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (binomialCoefficient(n, r) > 1000000) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question54() {
        ResponseDto responseDto = new ResponseDto();
        int playerOneWins = 0;
        return responseDto;
    }

    public ResponseDto Question55() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (!isLychrel(i)) {
                count++;
            }
        }
        responseDto.setAnswer(10000 - count);
        return responseDto;
    }

    public ResponseDto Question56() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger result = BigInteger.valueOf(2).pow(1000).multiply(BigInteger.valueOf(99).pow(99));
        String resultStr = result.toString();
        long digitSum = 0;
        for (char c : resultStr.toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }

    public ResponseDto Question57() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        BigInteger numerator = BigInteger.valueOf(3);
        BigInteger denominator = BigInteger.valueOf(2);
        for (int i = 1; i < 1000; i++) {
            if (numerator.toString().length() > denominator.toString().length()) {
                count++;
            }
            BigInteger nextNumerator = numerator.add(denominator.multiply(BigInteger.valueOf(2)));
            BigInteger nextDenominator = numerator.add(denominator);
            numerator = nextNumerator;
            denominator = nextDenominator;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question58() {
        ResponseDto responseDto = new ResponseDto();
        long diagCount = 0;
        long primeCount = 0;
        long sideLength = 1;
        while (true) {
            sideLength += 2;
            long baseNum = (sideLength - 1) * (sideLength - 1) + 1;
            for (int i = 0; i < 4; i++) {
                baseNum += (sideLength - 1);
                if (isPrime(baseNum)) {
                    primeCount++;
                }
                diagCount++;
            }
            if (diagCount > 0 && primeCount * 10 < diagCount) {
                responseDto.setAnswer(sideLength);
                return responseDto;
            }
        }
    }

    public ResponseDto Question59() {
        ResponseDto responseDto = new ResponseDto();
        for (int a = 97; a <= 122; a++) {
            for (int b = 97; b <= 122; b++) {
                for (int c = 97; c <= 122; c++) {
                    int sum = 0;
                    String result = decryptWithKey(a, b, c);
                    if (result.contains(" the ")) {
                        for (char ch : result.toCharArray()) {
                            sum += ch;
                        }
                        responseDto.setAnswer(sum);
                        return responseDto;
                    }
                }
            }
        }
        return responseDto;
    }

    public ResponseDto Question60() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question61() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question62() {
        ResponseDto responseDto = new ResponseDto();
        Map<String, Long> cubeMap = new HashMap<>();
        for (int i = 1; i <= 10000; i++) {
            long cube = (long) i * i * i;
            String sorted = sortDigits(String.valueOf(cube));
            cubeMap.put(sorted, cube);
            long count = 0;
            for (int j = 1; j <= 10000; j++) {
                if (sortDigits(String.valueOf((long) j * j * j)).equals(sorted)) {
                    count++;
                }
            }
            if (count == 5) {
                responseDto.setAnswer(cube);
                return responseDto;
            }
        }
        return responseDto;
    }

    public ResponseDto Question63() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int digits = 1; digits <= 100; digits++) {
            for (int base = 1; base <= 9; base++) {
                BigInteger power = BigInteger.valueOf(base).pow(digits);
                if (power.toString().length() == digits) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question64() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i <= 10000; i++) {
            if (getSquareRootPeriod(i) % 2 == 1) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question65() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger[] convergents = new BigInteger[100];
        convergents[0] = BigInteger.valueOf(2);
        convergents[1] = BigInteger.valueOf(2);
        for (int i = 2; i < 100; i++) {
            int a = 1 + (i - 1) / 3 * 2 + ((i - 1) % 3 == 1 ? 1 : 0) * 2;
            if ((i - 1) % 3 == 0) a = 1;
            if ((i - 1) % 3 == 1) a = 2 * ((i - 1) / 3 + 1);
            BigInteger num1 = convergents[i - 1].multiply(BigInteger.valueOf(a)).add((i >= 2 ? convergents[i - 2] : BigInteger.ONE));
            convergents[i] = num1;
        }
        BigInteger result = convergents[99];
        long digitSum = 0;
        for (char c : result.toString().toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }

    public ResponseDto Question66() {
        ResponseDto responseDto = new ResponseDto();
        long maxX = 0;
        int maxD = 0;
        for (int d = 2; d <= 1000; d++) {
            if (isSquare(d)) continue;
            long x = findPellSolution(d);
            if (x > maxX) {
                maxX = x;
                maxD = d;
            }
        }
        responseDto.setAnswer(maxD);
        return responseDto;
    }

    public ResponseDto Question67() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question68() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question69() {
        ResponseDto responseDto = new ResponseDto();
        long maxN = 0;
        double maxRatio = 0;
        for (long n = 2; n <= 1000000; n++) {
            double ratio = (double) n / eulerTotient(n);
            if (ratio > maxRatio) {
                maxRatio = ratio;
                maxN = n;
            }
        }
        responseDto.setAnswer(maxN);
        return responseDto;
    }

    public ResponseDto Question70() {
        ResponseDto responseDto = new ResponseDto();
        long minRatio = Long.MAX_VALUE;
        long result = 0;
        for (long n = 2; n < 10000000; n++) {
            long phi = eulerTotient(n);
            if (arePermutations(n, phi)) {
                long ratio = n / phi;
                if (ratio < minRatio) {
                    minRatio = ratio;
                    result = n;
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    public ResponseDto Question71() {
        ResponseDto responseDto = new ResponseDto();
        int maxNumerator = 0;
        for (int d = 2; d <= 1000000; d++) {
            for (int n = (3 * d) / 7; n > maxNumerator && n < d; n--) {
                if (gcd(n, d) == 1) {
                    maxNumerator = n;
                    break;
                }
            }
        }
        responseDto.setAnswer(maxNumerator);
        return responseDto;
    }

    public ResponseDto Question72() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int n = 2; n <= 1000000; n++) {
            sum += eulerTotient(n);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question73() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int d = 1; d <= 12000; d++) {
            for (int n = d / 3; n <= d / 2; n++) {
                if (gcd(n, d) == 1 && (double) n / d > (double) 1 / 3 && (double) n / d < (double) 1 / 2) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question74() {
        ResponseDto responseDto = new ResponseDto();
        long[] factorials = new long[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            Set<Long> seen = new HashSet<>();
            long n = i;
            while (!seen.contains(n)) {
                seen.add(n);
                long sum = 0;
                while (n > 0) {
                    sum += factorials[(int) (n % 10)];
                    n /= 10;
                }
                n = sum;
            }
            if (seen.size() == 60) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question75() {
        ResponseDto responseDto = new ResponseDto();
        int[] counts = new int[1500001];
        for (int a = 1; a <= 500; a++) {
            for (int b = a + 1; b <= 500; b++) {
                int c = (int) Math.sqrt(a * a + b * b);
                if (a * a + b * b == c * c) {
                    for (int k = 1; k * (a + b + c) <= 1500000; k++) {
                        counts[k * (a + b + c)]++;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= 1500000; i++) {
            if (counts[i] == 1) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question76() {
        ResponseDto responseDto = new ResponseDto();
        long[] dp = new long[101];
        dp[0] = 1;
        for (int i = 1; i < 100; i++) {
            for (int j = i; j <= 100; j++) {
                dp[j] += dp[j - i];
            }
        }
        responseDto.setAnswer(dp[100] - 1);
        return responseDto;
    }

    public ResponseDto Question77() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int n = 10; n <= 1000; n++) {
            if (countPrimeSums(n, primes) > 5000) {
                responseDto.setAnswer(n);
                return responseDto;
            }
        }
        return responseDto;
    }

    public ResponseDto Question78() {
        ResponseDto responseDto = new ResponseDto();
        long[] dp = new long[100001];
        dp[0] = 1;
        for (int n = 1; n <= 100000; n++) {
            for (int k = n; k <= 100000; k++) {
                dp[k] = (dp[k] + dp[k - n]) % 1000000;
            }
            if (dp[n] % 1000000 == 0 && n > 1) {
                responseDto.setAnswer(n);
                return responseDto;
            }
        }
        return responseDto;
    }

    public ResponseDto Question79() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question80() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (!isSquare(i)) {
                BigDecimal sqrt = sqrtBigDecimal(BigDecimal.valueOf(i), 100);
                String sqrtStr = sqrt.toString().replaceAll("\\.", "");
                for (int j = 0; j < 100 && j < sqrtStr.length(); j++) {
                    sum += Character.getNumericValue(sqrtStr.charAt(j));
                }
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question81() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question82() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question83() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question84() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question85() {
        ResponseDto responseDto = new ResponseDto();
        int targetArea = 2000000;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int width = 1; width <= 2000; width++) {
            for (int height = 1; height <= 2000; height++) {
                int rectangles = (width * (width + 1) / 2) * (height * (height + 1) / 2);
                if (Math.abs(rectangles - targetArea) < minDiff) {
                    minDiff = Math.abs(rectangles - targetArea);
                    result = width * height;
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    public ResponseDto Question86() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question87() {
        ResponseDto responseDto = new ResponseDto();
        Set<Long> numbers = new HashSet<>();
        for (int a = 1; a * a * a < 50000000; a++) {
            for (int b = 1; a * a * a + b * b * b * b < 50000000; b++) {
                for (int c = 1; a * a * a + b * b * b * b + c * c * c * c * c < 50000000; c++) {
                    long num = (long) a * a * a + b * b * b * b + (long) c * c * c * c * c;
                    if (num < 50000000) {
                        numbers.add(num);
                    }
                }
            }
        }
        responseDto.setAnswer((long) numbers.size());
        return responseDto;
    }

    public ResponseDto Question88() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question89() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question90() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question91() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int x1 = 0; x1 <= 50; x1++) {
            for (int y1 = 0; y1 <= 50; y1++) {
                for (int x2 = 0; x2 <= 50; x2++) {
                    for (int y2 = 0; y2 <= 50; y2++) {
                        long dx1 = x1, dy1 = y1, dx2 = x2, dy2 = y2;
                        if (dx1 * dx2 + dy1 * dy2 == 0 && (dx1 != 0 || dy1 != 0) && (dx2 != 0 || dy2 != 0)) {
                            count++;
                        }
                    }
                }
            }
        }
        responseDto.setAnswer(count / 2);
        return responseDto;
    }

    public ResponseDto Question92() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i < 10000000; i++) {
            if (endsIn89(i)) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    public ResponseDto Question93() {
        ResponseDto responseDto = new ResponseDto();
        int maxConsecutive = 0;
        int resultDigits = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = a + 1; b <= 9; b++) {
                for (int c = b + 1; c <= 9; c++) {
                    for (int d = c + 1; d <= 9; d++) {
                        Set<Integer> results = new HashSet<>();
                        int[] digits = {a, b, c, d};
                        generateOperations(digits, results);
                        int consecutive = 1;
                        while (results.contains(consecutive)) {
                            consecutive++;
                        }
                        if (consecutive - 1 > maxConsecutive) {
                            maxConsecutive = consecutive - 1;
                            resultDigits = a * 1000 + b * 100 + c * 10 + d;
                        }
                    }
                }
            }
        }
        responseDto.setAnswer(resultDigits);
        return responseDto;
    }

    public ResponseDto Question94() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (long a = 1; 3 * a + 2 < 1000000000; a++) {
            long p1 = 3 * a + 1;
            long p2 = 3 * a + 2;
            long area1Squared = a * a * ((3 * a + 1) * (3 * a + 1) - 4 * a * a) / 4;
            long area2Squared = a * a * ((3 * a + 2) * (3 * a + 2) - 4 * a * a) / 4;
            if (isSquare(area1Squared)) {
                sum += p1;
            }
            if (isSquare(area2Squared)) {
                sum += p2;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    public ResponseDto Question95() {
        ResponseDto responseDto = new ResponseDto();
        int maxChainLength = 0;
        int startingNumber = 0;
        for (int i = 1; i < 1000000; i++) {
            int chainLength = getAmicableChainLength(i);
            if (chainLength > maxChainLength) {
                maxChainLength = chainLength;
                startingNumber = i;
            }
        }
        responseDto.setAnswer(startingNumber);
        return responseDto;
    }

    public ResponseDto Question96() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question97() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger result = BigInteger.valueOf(28433).multiply(BigInteger.valueOf(2).pow(7830457)).add(BigInteger.ONE);
        String resultStr = result.toString();
        String lastTenDigits = resultStr.substring(resultStr.length() - 10);
        responseDto.setAnswer(Long.parseLong(lastTenDigits));
        return responseDto;
    }

    public ResponseDto Question98() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question99() {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    public ResponseDto Question100() {
        ResponseDto responseDto = new ResponseDto();
        long a = 3;
        long b = 8;
        for (int i = 0; i < 30; i++) {
            long temp = 3 * b - a - 2;
            a = b;
            b = temp;
        }
        responseDto.setAnswer(a);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(long a, long b) {
        return (int) (b == 0 ? a : gcd(b, a % b));
    }

    private int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += i * i == n ? 1 : 2;
            }
        }
        return count;
    }

    private long collatzLength(long n) {
        long length = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }
        return length;
    }

    private String numberToWords(int n) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n == 0) return "";
        if (n < 10) return units[n];
        if (n < 20) return teens[n - 10];
        if (n < 100) return tens[n / 10] + (n % 10 > 0 ? units[n % 10] : "");
        if (n < 1000) return units[n / 100] + "hundred" + numberToWords(n % 100);
        return units[n / 1000] + "thousand" + numberToWords(n % 1000);
    }

    private int dayOfWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        return (day + (13 * (month + 1)) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
    }

    private long sumOfDivisors(int n) {
        long sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i && i != 1) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    private boolean isPandigital(int a, int b, int product) {
        String combined = "" + a + b + product;
        return combined.length() == 9 && combined.matches("[1-9]*") && combined.chars().distinct().count() == 9;
    }

    private boolean isCurious(int n, int d) {
        double numer = n;
        double denom = d;
        String nStr = String.valueOf(n);
        String dStr = String.valueOf(d);
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == dStr.charAt(i)) {
                if (nStr.length() == 2 && dStr.length() == 2) {
                    int newN = nStr.charAt(1 - i) - '0';
                    int newD = dStr.charAt(1 - i) - '0';
                    if (newD != 0 && (double) newN / newD == numer / denom) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isCircularPrime(int n) {
        String nStr = String.valueOf(n);
        int rotations = nStr.length();
        for (int i = 0; i < rotations; i++) {
            String rotated = nStr.substring(i) + nStr.substring(0, i);
            if (!isPrime(Long.parseLong(rotated))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private boolean isTruncatablePrime(int n) {
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            for (int j = i + 1; j <= nStr.length(); j++) {
                if (!isPrime(Long.parseLong(nStr.substring(i, j)))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPandigital(String s) {
        return s.length() == 9 && s.matches("[1-9]*") && s.chars().distinct().count() == 9;
    }

    private boolean nextPermutation(List<Integer> list) {
        int i = list.size() - 2;
        while (i >= 0 && list.get(i) >= list.get(i + 1)) i--;
        if (i < 0) return false;
        int j = list.size() - 1;
        while (list.get(j) <= list.get(i)) j--;
        Collections.swap(list, i, j);
        Collections.reverse(list.subList(i + 1, list.size()));
        return true;
    }

    private int getRecurringCycleLength(int divisor) {
        int remainder = 1 % divisor;
        int length = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        while (remainder != 0 && !seen.containsKey(remainder)) {
            seen.put(remainder, length);
            remainder = (remainder * 10) % divisor;
            length++;
        }
        return length;
    }

    private boolean isHexagonal(long n) {
        long sqrt = (long) Math.sqrt(n);
        for (long i = Math.max(1, sqrt - 2); i <= sqrt + 2; i++) {
            if (i * (2 * i - 1) == n) {
                return true;
            }
        }
        return false;
    }

    private int countDistinctPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors.size();
    }

    private boolean arePermutations(long a, long b) {
        char[] aChars = String.valueOf(a).toCharArray();
        char[] bChars = String.valueOf(b).toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return Arrays.equals(aChars, bChars);
    }

    private boolean arePermutations(int a, int b, int c) {
        char[] aChars = String.valueOf(a).toCharArray();
        char[] bChars = String.valueOf(b).toCharArray();
        char[] cChars = String.valueOf(c).toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        Arrays.sort(cChars);
        return Arrays.equals(aChars, bChars) && Arrays.equals(bChars, cChars);
    }

    private boolean isSubstringDivisible(List<Integer> digits) {
        int[] divisors = {2, 3, 5, 7, 11, 13, 17};
        for (int i = 0; i < 7; i++) {
            int substring = digits.get(i + 1) * 100 + digits.get(i + 2) * 10 + digits.get(i + 3);
            if (substring % divisors[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private String sortDigits(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private long binomialCoefficient(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }

    private boolean isLychrel(int n) {
        long current = n;
        for (int i = 0; i < 50; i++) {
            long reversed = Long.parseLong(new StringBuilder(String.valueOf(current)).reverse().toString());
            current = current + reversed;
            if (isPalindrome(String.valueOf(current))) {
                return false;
            }
        }
        return true;
    }

    private long eulerTotient(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    private boolean isSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private long findPellSolution(int d) {
        long m = 0, d_var = 1, a = (long) Math.sqrt(d);
        long a0 = a;
        long num_prev = 1, num_curr = a0;
        long den_prev = 0, den_curr = 1;
        while (true) {
            m = d_var * a - m;
            d_var = (d - m * m) / d_var;
            a = (a0 + m) / d_var;
            long num_next = a * num_curr + num_prev;
            long den_next = a * den_curr + den_prev;
            if (num_next * num_next - d * den_next * den_next == 1) {
                return num_next;
            }
            num_prev = num_curr;
            num_curr = num_next;
            den_prev = den_curr;
            den_curr = den_next;
        }
    }

    private int getSquareRootPeriod(int n) {
        if (isSquare(n)) return 0;
        int m = 0, d = 1, a = (int) Math.sqrt(n);
        int a0 = a;
        int periodLength = 0;
        while (a != 2 * a0) {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            periodLength++;
        }
        return periodLength;
    }

    private String decryptWithKey(int a, int b, int c) {
        String encrypted = "496 90 663 667 667 336 336 669 662 667 663 90 90 666 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660";
        StringBuilder result = new StringBuilder();
        String[] parts = encrypted.split(" ");
        int keyIndex = 0;
        int[] key = {a, b, c};
        for (String part : parts) {
            int value = Integer.parseInt(part);
            int decrypted = value ^ key[keyIndex % 3];
            result.append((char) decrypted);
            keyIndex++;
        }
        return result.toString();
    }

    private int countPrimeSums(int n, List<Integer> primes) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int prime : primes) {
            for (int i = prime; i <= n; i++) {
                dp[i] += dp[i - prime];
            }
        }
        return dp[n];
    }

    private BigDecimal sqrtBigDecimal(BigDecimal number, int scale) {
        BigDecimal x = new BigDecimal(Math.sqrt(number.doubleValue()));
        BigDecimal prevx = BigDecimal.ZERO;
        BigDecimal two = BigDecimal.valueOf(2);
        while (!x.equals(prevx)) {
            prevx = x;
            x = number.divide(x, scale, java.math.RoundingMode.HALF_UP);
            x = x.add(prevx);
            x = x.divide(two, scale, java.math.RoundingMode.HALF_UP);
        }
        return x;
    }

    private boolean endsIn89(int n) {
        while (n != 1 && n != 89) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 89;
    }

    private void generateOperations(int[] digits, Set<Integer> results) {
        for (int i = 0; i < 24; i++) {
            permute(digits, 0, 3);
            for (int op1 = 0; op1 < 4; op1++) {
                for (int op2 = 0; op2 < 4; op2++) {
                    for (int op3 = 0; op3 < 4; op3++) {
                        try {
                            int result = applyOperations(digits[0], digits[1], digits[2], digits[3], op1, op2, op3);
                            if (result > 0) {
                                results.add(result);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    private int applyOperations(int a, int b, int c, int d, int op1, int op2, int op3) {
        int result = a;
        result = applyOp(result, b, op1);
        result = applyOp(result, c, op2);
        result = applyOp(result, d, op3);
        return result;
    }

    private int applyOp(int a, int b, int op) {
        switch (op) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                if (b == 0) throw new ArithmeticException();
                return a / b;
            default:
                return 0;
        }
    }

    private void permute(int[] arr, int i, int n) {
        if (i == n) return;
        for (int j = i; j < n; j++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            permute(arr, i + 1, n);
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private int getAmicableChainLength(int n) {
        Set<Integer> seen = new HashSet<>();
        int current = n;
        while (current != 1 && !seen.contains(current)) {
            seen.add(current);
            current = (int) sumOfDivisors(current);
        }
        return current == 1 ? seen.size() : -1;
    }
}

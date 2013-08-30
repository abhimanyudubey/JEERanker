package JEERanker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class helper {
	public static boolean isTop(graph G, List<Integer> L, double I){
		ListIterator<Integer> i = L.listIterator();
		boolean out = true;
		while(i.hasNext()){
			int x = i.nextIndex();
			if(I<x)
				out = false;
		}
		return out;
	}
	public static boolean hasItem(int[] a, int key){
		int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return true;
        }
        return false;
	}
	@SuppressWarnings("null")
	public static List<item> merge(List<item> A, List<item> B){
			List<item> C = null;
			C.addAll(A);
			C.addAll(B);
			return C;
	}
	public static String getCollege(char I){
		switch(I){
		case 'A':
			return "IIT Bhubaneswar";
		case 'B':
			return "IIT Bombay";
		case 'C':
			return "IIT Mandi";
		case 'D':
			return "IIT Delhi";
		case 'E':
			return "IIT Indore";
		case 'G':
			return "IIT Kharagpur";
		case 'H':
			return "IIT Hyderabad";
		case 'J':
			return "IIT Rajasthan";
		case 'K':
			return "IIT Kanpur";
		case 'M':
			return "IIT Madras";
		case 'N':
			return "IIT Gandhinagar";
		case 'P':
			return "IIT Patna";
		case 'R':
			return "IIT Roorkee";
		case 'S':
			return "ISM Dhanbad";
		case 'U':
			return "IIT Ropar";
		case 'V':
			return "IIT BHU";
		case 'W':
			return "IIT Guwahati";
		}
		return null;
	}
	public static String getCourse(String x){
		return x;
	}
	public static String getCourseName(String search) throws IOException{
		String[][] ss = {{"Civil Engineering (Bachelors)","4109"},{"Electrical Engineering (Bachelors)","4111"},{"Mechanical Engineering (Bachelors)","4125"},{"Aerospace Engineering (Bachelors)","4101"},{"Chemical Engineering (Bachelors)","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering (Bachelors)","4110"},{"Electrical Engineering","4111"},{"Engineering Physics (Bachelors)","4117"},{"Mechanical Engineering","4125"},{"Metallurgical Engineering and Materials Science (Bachelors)","4128"},{"Chemical Engineering (Dual Degree/Masters)","5210"},{"Electrical Engineering with M.Tech. in Communications and Signal Processing (Dual Degree/Masters)","5219"},{"Electrical Engineering with M.Tech. in Microelectronics (Dual Degree/Masters)","5221"},{"Energy Engineering with M.Tech. in Energy Systems Engineering (Dual Degree/Masters)","5226"},{"Engineering Physics with M.Tech. in Engineering Physics with specialization in Nano Science (Dual Degree/Masters)","5229"},{"Mechanical Engineering with M.Tech. in Computer Aided Design and Automation (Dual Degree/Masters)","5234"},{"Mechanical Engineering with M.Tech. in Computer Integrated Manufacturing (Dual Degree/Masters)","5235"},{"Metallurgical Engineering and Materials Science with M.Tech. in Ceramics and Composites (Dual Degree/Masters)","5244"},{"Metallurgical Engineering and Materials Science with M.Tech. in Metallurgical Process Engineering (Dual Degree/Masters)","5245"},{"Chemistry (Dual Degree/Masters)","5503"},{"Chemical Engineering","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Electrical Engineering (Power) (Bachelors)","4112"},{"Engineering Physics","4117"},{"Mechanical Engineering","4125"},{"Production and Industrial Engineering (Bachelors)","4136"},{"Textile Technology (Bachelors)","4139"},{"Biochemical Engineering and Biotechnology (Dual Degree/Masters)","5205"},{"Chemical Engineering","5210"},{"Computer Science and Engineering (Dual Degree/Masters)","5216"},{"Electrical Engineering with M.Tech. in Information and Communication Technology (Dual Degree/Masters)","5220"},{"Mathematics and Computing (Dual Degree/Masters)","5305"},{"Chemical Engineering","4107"},{"Electrical Engineering","4111"},{"Mechanical Engineering","4125"},{"Biotechnology (Bachelors)","4104"},{"Chemical Engineering","4107"},{"Chemical Science and Technology (Bachelors)","4108"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electronics and Communication Engineering (Bachelors)","4114"},{"Electronics and Electrical Engineering (Bachelors)","4116"},{"Engineering Physics","4117"},{"Mathematics and Computing (Bachelors)","4124"},{"Mechanical Engineering","4125"},{"Design (Bachelors)","4401"},{"Chemical Engineering","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Engineering Science (Bachelors)","4118"},{"Mechanical Engineering","4125"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Mechanical Engineering","4125"},{"Aerospace Engineering","4101"},{"Biological Sciences and Bioengineering (Bachelors)","4103"},{"Chemical Engineering","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Materials Science and Engineering (Bachelors)","4123"},{"Mechanical Engineering","4125"},{"Chemistry (Bachelors)","4201"},{"Economics (Bachelors)","4202"},{"Mathematics and Scientific Computing (Bachelors)","4203"},{"Physics (Bachelors)","4204"},{"Aerospace Engineering","4101"},{"Agricultural and Food Engineering (Bachelors)","4102"},{"Biotechnology and Biochemical Engineering (Bachelors)","4105"},{"Chemical Engineering","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Electronics and Electrical Communication Engineering (Bachelors)","4115"},{"Industrial Engineering (Bachelors)","4120"},{"Instrumentation Engineering (Bachelors)","4121"},{"Manufacturing Science and Engineering (Bachelors)","4122"},{"Mechanical Engineering","4125"},{"Metallurgical and Materials Engineering (Bachelors)","4127"},{"Mining Engineering (Bachelors)","4130"},{"Ocean Engineering and Naval Architecture (Bachelors)","4133"},{"Architecture (Dual Degree/Masters)","5101"},{"Aerospace Engineering (Dual Degree/Masters)","5201"},{"Agricultural and Food Engineering with M.Tech. in any of the listed specializations (Dual Degree/Masters)","5203"},{"Biotechnology and Biochemical Engineering (Dual Degree/Masters)","5208"},{"Chemical Engineering","5210"},{"Civil Engineering with any of the listed specialization (Dual Degree/Masters)","5215"},{"Computer Science and Engineering","5216"},{"Electrical Engineering with M.Tech. in any of the listed specializations (Dual Degree/Masters)","5222"},{"Electronics and Electrical Communication Engineering with M.Tech. in any of the listed specializations (Dual Degree/Masters)","5225"},{"Industrial Engineering with M.Tech. in Industrial Engineering and Management (Dual Degree/Masters)","5230"},{"Manufacturing Science and Engineering with M.Tech. in Industrial Engineering and Management (Dual Degree/Masters)","5231"},{"Mechanical Engineering with M.Tech. in any of the listed specializations (Dual Degree/Masters)","5239"},{"Metallurgical and Materials Engineering with M.Tech. in Metallurgical and Materials Engineering (Dual Degree/Masters)","5243"},{"Mining Engineering (Dual Degree/Masters)","5247"},{"Mining Safety Engineering (Dual Degree/Masters)","5248"},{"Ocean Engineering and Naval Architecture (Dual Degree/Masters)","5251"},{"Quality Engineering Design and Manufacturing (Dual Degree/Masters)","5253"},{"Applied Geology (Dual Degree/Masters)","5501"},{"Chemistry","5503"},{"Economics (Dual Degree/Masters)","5504"},{"Exploration Geophysics (Dual Degree/Masters)","5505"},{"Mathematics and Computing (Dual Degree/Masters)","5506"},{"Physics (Dual Degree/Masters)","5507"},{"Aerospace Engineering","4101"},{"Chemical Engineering","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Engineering Physics","4117"},{"Mechanical Engineering","4125"},{"Metallurgical and Materials Engineering","4127"},{"Naval Architecture and Ocean Engineering (Bachelors)","4132"},{"Aerospace Engineering","5201"},{"Aerospace Engineering with M.Tech. in Applied Mechanics with specialization in Biomedical Engineering (Dual Degree/Masters)","5202"},{"Biological Engineering (Dual Degree/Masters)","5207"},{"Chemical Engineering","5210"},{"Civil Engineering with M.Tech. in Applied Mechanics in any of the listed specializations (Dual Degree/Masters)","5212"},{"Civil Engineering (Infrastructural Civil Engineering) (Dual Degree/Masters)","5213"},{"Civil Engineering with any of the listed specialization","5215"},{"Computer Science and Engineering","5216"},{"Electrical Engineering (Dual Degree/Masters)","5217"},{"Electrical Engineering with M.Tech in Applied Mechanics with specialization in Biomedical Engineering (Dual Degree/Masters)","5218"},{"Engineering Design (Automotive Engineering) (Dual Degree/Masters)","5227"},{"Engineering Design (Biomedical Design) (Dual Degree/Masters)","5228"},{"Mechanical Engineering (Thermal Engineering) (Dual Degree/Masters)","5236"},{"Mechanical Engineering (Intelligent Manufacturing) (Dual Degree/Masters)","5237"},{"Mechanical Engineering (Product design) (Dual Degree/Masters)","5238"},{"Metallurgical and Materials Engineering (Dual Degree/Masters)","5241"},{"Naval Architecture and Ocean Engineering (Dual Degree/Masters)","5249"},{"Naval Architecture and Ocean Engineering with M.Tech in Applied Mechanics in any of the listed specializations (Dual Degree/Masters)","5250"},{"Biological Sciences (Dual Degree/Masters)","5601"},{"Physics (Dual Degree/Masters)","5602"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Mechanical Engineering","4125"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Mechanical Engineering","4125"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Mechanical Engineering","4125"},{"Systems Science (Bachelors)","4138"},{"Biotechnology","4104"},{"Chemical Engineering","4107"},{"Civil Engineering","4109"},{"Computer Science and Engineering","4110"},{"Electrical Engineering","4111"},{"Electronics and Communication Engineering","4114"},{"Mechanical Engineering","4125"},{"Metallurgical and Materials Engineering","4127"},{"Polymer Science and Technology (Bachelors)","4135"},{"Production and Industrial Engineering","4136"},{"Pulp and Paper Engineering (Bachelors)","4137"},{"Architecture","5101"},{"Chemical Engineering with M.Tech. in Hydrocarbon Engineering (Dual Degree/Masters)","5211"},{"Civil Engineering with M.Tech. in Structural Engineering (Dual Degree/Masters)","5214"},{"Electrical Engineering with M.Tech. in Power Electronics (Dual Degree/Masters)","5223"},{"Electronics and Communication Engineering with M.Tech. in Wireless Communication  (Dual Degree/Masters)","5224"},{"Metallurgical and Materials Engineering with M.Tech. in Materials Engineering  (Dual Degree/Masters)","5242"},{"Geological Technology  (Dual Degree/Masters)","5302"},{"Geophysical Technology  (Dual Degree/Masters)","5303"},{"Process Engineering with MBA  (Dual Degree/Masters)","5403"},{"Applied Mathematics  (Dual Degree/Masters)","5502"},{"Chemistry ","5503"},{"Physics ","5507"},{"Computer Science and Engineering ","4110"},{"Electrical Engineering ","4111"},{"Mechanical Engineering ","4125"},{"Chemical Engineering ","4107"},{"Computer Science and Engineering ","4110"},{"Electrical Engineering ","4111"},{"Electronics and Communication Engineering ","4114"},{"Environmental Engineering  (Bachelors)","4119"},{"Mechanical Engineering ","4125"},{"Mineral Engineering  (Bachelors)","4129"},{"Mining Engineering ","4130"},{"Mining Machinery Engineering  (Bachelors)","4131"},{"Petroleum Engineering  (Bachelors)","4134"},{"Mineral Engineering with M.Tech in Mineral Engineering  (Dual Degree/Masters)","5246"},{"Mining Engineering with M.Tech. in Mining Engineering ","5247"},{"Petroleum Engineering with M.Tech in Petroleum Management  (Dual Degree/Masters)","5252"},{"Mathematics and Computing ","5305"},{"Mineral Engineering with MBA  (Dual Degree/Masters)","5401"},{"Mining Engineering with MBA  (Dual Degree/Masters)","5402"},{"Applied Geology  (Dual Degree/Masters)","5701"},{"Applied Geophysics  (Dual Degree/Masters)","5702"},{"Ceramic Engineering  (Bachelors)","4106"},{"Chemical Engineering ","4107"},{"Civil Engineering ","4109"},{"Computer Science and Engineering ","4110"},{"Electrical Engineering ","4111"},{"Electronics Engineering  (Bachelors)","4113"},{"Mechanical Engineering ","4125"},{"Metallurgical Engineering  (Bachelors)","4126"},{"Mining Engineering ","4130"},{"Pharmaceutics  (Bachelors)","4301"},{"Biochemical Engineering  (Dual Degree/Masters)","5204"},{"Bioengineering with M.Tech in Biomedical Technology  (Dual Degree/Masters)","5206"},{"Ceramic Engineering  (Dual Degree/Masters)","5209"},{"Civil Engineering with M.Tech. in Structural Engineering ","5214"},{"Computer Science and Engineering ","5216"},{"Electrical Engineering with M.Tech. in Power Electronics ","5223"},{"Material Science and Technology  (Dual Degree/Masters)","5232"},{"Mechanical Engineering  (Dual Degree/Masters)","5233"},{"Metallurgical Engineering  (Dual Degree/Masters)","5240"},{"Mining Engineering ","5247"},{"Engineering Physics  (Dual Degree/Masters)","5301"},{"Industrial Chemistry  (Dual Degree/Masters)","5304"},{"Mathematics and Computing ","5305"},{"Pharmaceutics  (Dual Degree/Masters)","5801"}};
		for(int i=0;i<ss.length;i++){
			if(ss[i][1].contains(search)){
				return ss[i][0];
			}
		}
		return "";
		/*
		@SuppressWarnings("resource")
		BufferedReader file = new BufferedReader(new FileReader("courses.csv"));
		String line;
		List<String> index = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		String str = "{";
		while((line = file.readLine())!=null){
			String[] aline = line.split(",");
			String anae = aline[1];
			String code = aline[2];
			code = code.substring(1);
			code = code.replace(" ", "");
			if(!index.contains(code)){
				index.add(code);
				if(code.charAt(0)=='4')
					anae=anae.concat(" (Bachelors)");
				else
					anae=anae.concat(" (Dual Degree/Masters)");
				name.add(anae);
			}
			str+="{\""+anae+"\",\""+code+"\"},";
		}
		str=str.substring(0,str.length()-1);
		str+="};";
		System.out.println(str);
		ListIterator<String> iter = index.listIterator();
		ListIterator<String> itername = name.listIterator();
		while(iter.hasNext()){
			String a = iter.next();
			String b = itername.next();
			if(a.contains(search)){
				return b;
			}
		}
		return null;*/
	} 
}

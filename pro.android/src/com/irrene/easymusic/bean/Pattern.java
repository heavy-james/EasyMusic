package com.irrene.easymusic.bean;

import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;

public class Pattern extends Section {
	
	public static class Attribute{
		public static final int RHYTHM_2_4 = 1;
		public static final int RHYTHM_3_4 = 2;
		public static final int RHYTHM_4_4 = 3;
		public static final int RHYTHM_6_8 = 4;
		
		public static final String RHYTHM_NAME_2_4 = "2/4";
		public static final String RHYTHM_NAME_3_4 = "3/4";
		public static final String RHYTHM_NAME_4_4 = "4/4";
		public static final String RHYTHM_NAME_6_8 = "6/8";
	}
	
	List<Cadence> mCandences;
	
	public static final String PATTERN_DENOMINATOR = "dinominator";
	public static final String PATTERN_MOLECULE = "molecule";
	
	
	private int molecule = 0;
	private int dinominator = 1;
	
	private Pattern(int molecule,int dinominator){
		this.molecule = molecule;
		this.dinominator = dinominator;
	}
	
	@Override
	public String getTypeName() {
		return "Pattern";
	}

	public List<Cadence> getmCandences() {
		return mCandences;
	}

	private boolean initCadences(){
		if(molecule < 1 || dinominator > 8 || molecule > dinominator){
			return false;
		}
		mCandences = new ArrayList<Cadence>(molecule);
		for(int i = 0; i < molecule; i++){
			Cadence temp = new Cadence();
			temp.setLength(Cadence.Length.LENGTH_ONE_BEAT);
			if(dinominator == 2 && molecule == 4){//四二拍初始化
				switch(i){
				case 0:
					temp.setForce(Cadence.Force.FORCE_STRONG);
				case 1:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				}
			}else if(dinominator == 4 && molecule == 4){//四四拍初始化
				switch(i){
				case 0:
					temp.setForce(Cadence.Force.FORCE_STRONG);
				case 1:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				case 2:
					temp.setForce(Cadence.Force.FORCE_SECOND_STRONG);
				case 3:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				}
			}else if(dinominator == 4 && molecule == 3){//四三拍初始化
				switch(i){
				case 0:
					temp.setForce(Cadence.Force.FORCE_STRONG);
				case 1:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				case 2:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				}
			}else if(dinominator == 8 && molecule == 6){//八六拍初始化
				switch(i){
				case 0:
					temp.setForce(Cadence.Force.FORCE_STRONG);
				case 1:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				case 2:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				case 3:
					temp.setForce(Cadence.Force.FORCE_SECOND_STRONG);
				case 4:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				case 5:
					temp.setForce(Cadence.Force.FORCE_WEAK);
				}
			}
			mCandences.add(temp);
		}
		return true;
	}
	
	public static Pattern create(int molecule,int dinominator){
		Pattern result = new Pattern(molecule, dinominator);
		if(result.initCadences()){
			return result;
		}
		return null;
	}
	
	public static Pattern create(String pattern){
		if(!TextUtils.isEmpty(pattern)){
			String[] values = pattern.split("/");
			if(values.length == 2){
				int molecule = Integer.parseInt(values[0]);
				int dinominator = Integer.parseInt(values[1]);
				Pattern result = create(molecule, dinominator);
				return result;
			}
		}
		return null;
	}
}

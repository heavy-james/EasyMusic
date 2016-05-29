package com.irene.easymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class Pattern extends Section {
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
			if(dinominator == 4 && molecule == 4){//四四拍初始化
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
			}else if(dinominator == 4 && molecule <= 3){//四三拍和四二拍初始化
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
}

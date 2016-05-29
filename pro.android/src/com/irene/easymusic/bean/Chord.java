package com.irene.easymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class Chord extends Section {
	private List<Sound> mSounds;
	private Sound mBase;
	private int mAttri;
	private int mFistDistance;
	private int mSecondDistance;
	private int mThirdDistance;
	private int mReverseTag;
	private int mChordType;
	private String mSuspendFlag = null;
	
	
	public static final String SUSPEND_2 = "sus2";
	public static final String SUSPEND_4 = "sus4";
	

	public static class Type {
		public static final int TYPE_THREE = 3;
		public static final int TYPE_SEVEN = 7;
		public static final int TYPE_NINE = 9;
		public static final int TYPE_ELEVEN = 11;
		public static final int TYPE_THIRTEEN = 13;
	}
	
	
	public static class DistanceTwo{
		public static final int DIS_MINOR = 1;
		public static final int DIS_MAJOR = 2;
	} 
	
	public static class DistanceThree{
		public static final int DIS_DIMINISHED = 2;
		public static final int DIS_MINOR = 3;
		public static final int DIS_MAJOR = 4;
		public static final int DIS_AUGMENTED = 5;
	}
	
	public static class DistanceFour{
		public static final int DIS_MAJOR = 5;
		public static final int DIS_AUGMENTED = 6;
	}

	
	public static class Attribute {

		public static class Three {
			//增三和弦
			public static final int ATTRI_AUGMENTED_3 = 4;
			//小三和弦
			public static final int ATTRI_MINOR_3 = 2;
			//大三和弦
			public static final int ATTRI_MAJOR_3 = 3;
			//减三和弦
			public static final int ATTRI_DIMINISHED_3 = 1;
		}

		public static class Seven {
			// 大小七和弦
			public static final int ATTRI_MAJ_MIN_7 = 1;
			// 大七和弦
			public static final int ATTRI_MAJOR_7 = 2;
			// 小七和弦
			public static final int ATTRI_MINOR_7 = 3;
			// 小大七和弦
			public static final int ATTRI_MIN_MAJ_7 = 4;
			// 半减七和弦、减小七和弦
			public static final int ATTRI_DIM_MIN_7 = 5;
			// 减七和弦
			public static final int ATTRI_DIMINISHED_7 = 6;
			// 增七和弦
			public static final int ATTRI_AUGMENTED_7 = 7;
			// 增大七和弦
			public static final int ATTRI_AUG_MAJ_7 = 8;
		}
	}

	public static class ReverseLevel {
		public static final int LEVEL_ORIGIN = 0;
		public static final int LEVEL_ONE = 1;
		public static final int LEVEL_TWO = 2;
		public static final int LEVEL_THREE = 3;
	}

	
	public Sound getNextInnerSound(Sound sound,int distance){
		Sound temp = new Sound();
		if(distance == 3){
			switch(distance){
			case DistanceThree.DIS_AUGMENTED:
				temp.setName(sound.getName() + 5);
				break;
			case DistanceThree.DIS_DIMINISHED:
				temp.setName(sound.getName() + 2);
				break;
			case DistanceThree.DIS_MAJOR:
				temp.setName(sound.getName() + 4);
				break;
			case DistanceThree.DIS_MINOR:
				temp.setName(sound.getName() + 3);
				break;
			default:
				temp = null;
			}
		}
		return temp;
	}
	
	public Sound getSuspendSound(){
		Sound temp = new Sound();
		if(SUSPEND_2.equals(mSuspendFlag)){
			switch(mAttri){
			case DistanceTwo.DIS_MAJOR:
				temp.setName(mBase.getName() + 2);
				mFistDistance = DistanceTwo.DIS_MAJOR;
				break;
			case DistanceTwo.DIS_MINOR:
				temp.setName(mBase.getName() + 1);
				mFistDistance = DistanceTwo.DIS_MAJOR;
				break;
			default:
				temp = null;
			}
		}else if(SUSPEND_4.equals(mSuspendFlag)){
			switch(mAttri){
			case DistanceFour.DIS_AUGMENTED:
				temp.setName(mBase.getName() + 6);
				mFistDistance = DistanceFour.DIS_AUGMENTED;
				break;
			case DistanceFour.DIS_MAJOR:
				temp.setName(mBase.getName() + 5);
				mFistDistance = DistanceTwo.DIS_MAJOR;
				break;
			default:
				temp = null;
			}
		}
		return temp;
	}
	
	public Sound getChordInnerSound(int position){
		return mSounds.get(position);
	}
	
	public boolean initChordThree(int attri){
		boolean result = false;
		mSounds = new ArrayList<Sound>();
		mSounds.add(mBase);
		//三音
		Sound sound3 = null;
		//五音
		Sound sound5 = null;
		switch (attri) {
		case Attribute.Three.ATTRI_AUGMENTED_3:
			sound3 = mSuspendFlag == null ? getNextInnerSound(mBase, DistanceThree.DIS_MAJOR) : getSuspendSound();
			if(null != sound3){
				mFistDistance = mSuspendFlag == null ? DistanceThree.DIS_MAJOR : mFistDistance;
				mSounds.add(sound3);
			}else{
				return false;
			}
			sound5 = getNextInnerSound(sound3, DistanceThree.DIS_MAJOR);
			if(null != sound5){
				mSecondDistance = mSuspendFlag == null ? DistanceThree.DIS_MAJOR : mFistDistance;
				mSounds.add(sound5);
			}else{
				return false;
			}
			result = true;
			break;
		case Attribute.Three.ATTRI_DIMINISHED_3:
			sound3 = mSuspendFlag == null ? getNextInnerSound(mBase, DistanceThree.DIS_MINOR) : getSuspendSound();
			if(null != sound3){
				mFistDistance = mSuspendFlag == null ? DistanceThree.DIS_MINOR : mFistDistance;
				mSounds.add(sound3);
			}else{
				return false;
			}
			sound5 = getNextInnerSound(sound3, DistanceThree.DIS_MINOR);
			if(null != sound5){
				mSecondDistance = mSuspendFlag == null ? DistanceThree.DIS_MINOR : mFistDistance;
				mSounds.add(sound5);
			}else{
				return false;
			}
			result = true;
			break;
		case Attribute.Three.ATTRI_MAJOR_3:
			sound3 = mSuspendFlag == null ? getNextInnerSound(mBase, DistanceThree.DIS_MAJOR) : getSuspendSound();
			if(null != sound3){
				mFistDistance = mSuspendFlag == null ? DistanceThree.DIS_MAJOR : mFistDistance;
				mSounds.add(sound3);
			}else{
				return false;
			}
			sound5 = getNextInnerSound(sound3, DistanceThree.DIS_MINOR);
			if(null != sound5){
				mSecondDistance = mSuspendFlag == null ? DistanceThree.DIS_MINOR : mFistDistance;
				mSounds.add(sound5);
			}else{
				return false;
			}
			result = true;
			break;
		case Attribute.Three.ATTRI_MINOR_3:
			sound3 = mSuspendFlag == null ? getNextInnerSound(mBase, DistanceThree.DIS_MINOR) : getSuspendSound();
			if(null != sound3){
				mFistDistance = mSuspendFlag == null ? DistanceThree.DIS_MINOR : mFistDistance;
				mSounds.add(sound3);
			}else{
				return false;
			}
			sound5 = getNextInnerSound(sound3, DistanceThree.DIS_MAJOR);
			if(null != sound5){
				mSecondDistance = mSuspendFlag == null ? DistanceThree.DIS_MAJOR : mFistDistance;
				mSounds.add(sound5);
			}else{
				return false;
			}
			result = true;
			break;
		default:
			break;
		}
		return result;
	}
	
	public Sound getChordSevenInnerSound(int position,int attri){
		Sound temp = new Sound();
		switch (position) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			temp = null;
		}
		return temp;
	}
	
	public Sound getChordNineInnerSound(int position){
		Sound temp = new Sound();
		switch (position) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			temp = null;
		}
		return temp;
	}
		
	
	public static int getAttriSeven(String attriName) {
		// 大小七和弦
		if ("7".equals(attriName)) {
			
		}
		// 大七和弦
		if ("M7".equals(attriName) || "Maj7".equals(attriName)) {

		}
		// 小七和弦
		if ("m7".equals(attriName) || "min7".equals(attriName)) {

		}
		// 小大七和弦
		if ("mM7".equals(attriName)) {

		}
		// 半减七和弦
		if ("half-dim7".equals(attriName) || "m7-5".equals(attriName)) {

		}
		// 减七和弦
		if ("dim7".equals(attriName)) {

		}
		// 增七和弦
		if ("M7+5+7".equals(attriName) || "M7++".equals(attriName)) {

		}
		// 增大七和弦
		if ("Maj7+5".equals(attriName) || "M7+".equals(attriName)) {

		}
		return 0;
	}

	private Chord(Builder builder) {
		this.mBase = builder.base;
		this.mChordType = builder.chordType;
		this.mReverseTag = builder.reverseTag;
		this.mAttri = builder.attri;
	}

	public boolean isValide() {
		return !(mBase == null || mAttri < 0 || mAttri > 5);
	}

	public int getLength() {
		return getSounds().size();
	}

	public Sound getBaseSound() {
		return mBase;
	}

	public Sound getReverseBase() {
		return mSounds.get(0);
	}

	public void sort() {
		if (mReverseTag > 0 && mReverseTag < getLength()) {
			List<Sound> originOrderSound = mSounds.subList(mReverseTag, getLength());
			List<Sound> reverseOrderSound = mSounds.subList(0, mReverseTag);
			mSounds.clear();
			mSounds.addAll(originOrderSound);
			mSounds.addAll(reverseOrderSound);
			for (Sound sound : reverseOrderSound) {
				if (sound.getName() < getReverseBase().getName()) {
					sound.setName(sound.getName() + 12);
				}
			}
		}
	}


	private boolean initChordSeven(int attri) {
		boolean result = false;
		Sound sound7 = null;
		switch (attri) {
		case Attribute.Seven.ATTRI_AUG_MAJ_7:
			result = initChordThree(Attribute.Three.ATTRI_AUGMENTED_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_MAJOR);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_AUGMENTED_7:
			result = initChordThree(Attribute.Three.ATTRI_AUGMENTED_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_AUGMENTED);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_DIM_MIN_7:
			result = initChordThree(Attribute.Three.ATTRI_DIMINISHED_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_MINOR);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_DIMINISHED_7:
			result = initChordThree(Attribute.Three.ATTRI_DIMINISHED_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_DIMINISHED);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_MAJ_MIN_7:
			result = initChordThree(Attribute.Three.ATTRI_MAJOR_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_MINOR);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_MAJOR_7:
			result = initChordThree(Attribute.Three.ATTRI_MAJOR_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_MAJOR);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_MIN_MAJ_7:
			result = initChordThree(Attribute.Three.ATTRI_MINOR_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_MAJOR);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		case Attribute.Seven.ATTRI_MINOR_7:
			result = initChordThree(Attribute.Three.ATTRI_MINOR_3);
			if (!result){
				return false;
			}
			sound7 = getNextInnerSound(mSounds.get(2), DistanceThree.DIS_MINOR);
			if(null != sound7){
				mSounds.add(sound7);
				result = true;
			}else{
				return false;
			}
			break;
		default:
			break;
		}

		return false;
	}

	private boolean initChordNine(int attri) {
		return false;
	}

	private boolean initChordElevene(int attri) {
		return false;
	}

	private boolean initChordThirteen(int attri) {
		return false;
	}

	private boolean init() {
		if (isValide()) {
			switch(mChordType){
			case Type.TYPE_THREE:
				return initChordThree(mAttri);
			case Type.TYPE_SEVEN:
				return initChordSeven(mAttri);
			case Type.TYPE_NINE:
				return initChordNine(mAttri);
			case Type.TYPE_ELEVEN:
				return initChordElevene(mAttri);
			case Type.TYPE_THIRTEEN:
				return initChordThirteen(mAttri);
			}
		}
		return false;
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "Chord";
	}

	public List<Sound> getSounds() {
		return mSounds;
	}

	public int getReverseTag() {
		return mReverseTag;
	}

	public int getChordType() {
		return mChordType;
	}

	public static class Builder {

		private Sound base = null;
		private int attri = 0;
		private int reverseTag = ReverseLevel.LEVEL_ORIGIN;
		private int chordType = Type.TYPE_THREE;

		public Builder(Sound base, int attri) {
			this.base = base;
			this.attri = attri;
		}

		public Sound getBase() {
			return base;
		}

		public int getAttri() {
			return attri;
		}

		public int getReverseTag() {
			return reverseTag;
		}

		public int getType() {
			return chordType;
		}

		public void Type(int type) {
			chordType = type;
		}

		public void Tag(int tag) {
			reverseTag = tag;
		}

		public Chord build() {
			Chord result = new Chord(this);
			if (result.init()) {
				result.sort();
				return result;
			}
			return null;
		}
	}

}

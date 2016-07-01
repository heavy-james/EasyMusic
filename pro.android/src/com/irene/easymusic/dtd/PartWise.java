package com.irene.easymusic.dtd;

/**
 * <!-- MusicXML™ Partwise DTD
 * 
 * Version 3.0
 * 
 * Copyright © 2004-2011 MakeMusic, Inc. http://www.makemusic.com/
 * 
 * This MusicXML™ work is being provided by the copyright holder under the
 * MusicXML Public License Version 3.0, available from:
 * 
 * http://www.musicxml.org/dtds/license.html -->
 * 
 * <!-- The MusicXML format is designed to represent musical scores,
 * specifically common western musical notation from the 17th century onwards.
 * It is designed as an interchange format for notation, analysis, retrieval,
 * and performance applications. Therefore it is intended to be sufficient, not
 * optimal, for these applications.
 * 
 * The MusicXML format is based on the MuseData and Humdrum formats. Humdrum
 * explicitly represents the two-dimensional nature of musical scores by a 2-D
 * layout notation. Since the XML format is hierarchical, we cannot do this
 * explicitly. Instead, there are two top-level formats:
 * 
 * partwise.dtd Represents scores by part/instrument timewise.dtd Represents
 * scores by time/measure
 * 
 * Thus partwise.dtd contains measures within each part, while timewise.dtd
 * contains parts within each measure. XSLT stylesheets are provided to convert
 * between the two formats.
 * 
 * The partwise and timewise score DTDs represent a single movement of music.
 * Multiple movements or other musical collections are presented using opus.dtd.
 * An opus document contains XLinks to individual scores.
 * 
 * Suggested use:
 * 
 * <!DOCTYPE score-partwise PUBLIC "-//Recordare//DTD MusicXML 3.0 Partwise//EN"
 * "http://www.musicxml.org/dtds/partwise.dtd">
 * 
 * This DTD is made up of a series of component DTD modules, all of which are
 * included here. -->
 */
public class PartWise {

	/**
	 * <!-- Entities -->
	 * 
	 * <!-- The partwise and timewise entities are used with conditional
	 * sections to control the differences between the partwise and timewise
	 * DTDs. The values for these entities are what distinguish the partwise and
	 * timewise DTD files. -->
	 * 
	 * <!-- Component DTD modules -->
	 * 
	 * <!-- The common DTD module contains the entities and elements that are
	 * shared among multiple component DTDs. -->
	 */

}

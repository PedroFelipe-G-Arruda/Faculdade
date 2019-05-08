<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE eagle SYSTEM "eagle.dtd">
<eagle version="9.3.2">
<drawing>
<settings>
<setting alwaysvectorfont="no"/>
<setting verticaltext="up"/>
</settings>
<grid distance="0.1" unitdist="inch" unit="inch" style="lines" multiple="1" display="no" altdistance="0.01" altunitdist="inch" altunit="inch"/>
<layers>
<layer number="1" name="Top" color="4" fill="1" visible="no" active="no"/>
<layer number="2" name="Route2" color="1" fill="3" visible="no" active="no"/>
<layer number="3" name="Route3" color="4" fill="3" visible="no" active="no"/>
<layer number="4" name="Route4" color="1" fill="4" visible="no" active="no"/>
<layer number="5" name="Route5" color="4" fill="4" visible="no" active="no"/>
<layer number="6" name="Route6" color="1" fill="8" visible="no" active="no"/>
<layer number="7" name="Route7" color="4" fill="8" visible="no" active="no"/>
<layer number="8" name="Route8" color="1" fill="2" visible="no" active="no"/>
<layer number="9" name="Route9" color="4" fill="2" visible="no" active="no"/>
<layer number="10" name="Route10" color="1" fill="7" visible="no" active="no"/>
<layer number="11" name="Route11" color="4" fill="7" visible="no" active="no"/>
<layer number="12" name="Route12" color="1" fill="5" visible="no" active="no"/>
<layer number="13" name="Route13" color="4" fill="5" visible="no" active="no"/>
<layer number="14" name="Route14" color="1" fill="6" visible="no" active="no"/>
<layer number="15" name="Route15" color="4" fill="6" visible="no" active="no"/>
<layer number="16" name="Bottom" color="1" fill="1" visible="no" active="no"/>
<layer number="17" name="Pads" color="2" fill="1" visible="no" active="no"/>
<layer number="18" name="Vias" color="2" fill="1" visible="no" active="no"/>
<layer number="19" name="Unrouted" color="6" fill="1" visible="no" active="no"/>
<layer number="20" name="Dimension" color="15" fill="1" visible="no" active="no"/>
<layer number="21" name="tPlace" color="7" fill="1" visible="no" active="no"/>
<layer number="22" name="bPlace" color="7" fill="1" visible="no" active="no"/>
<layer number="23" name="tOrigins" color="15" fill="1" visible="no" active="no"/>
<layer number="24" name="bOrigins" color="15" fill="1" visible="no" active="no"/>
<layer number="25" name="tNames" color="7" fill="1" visible="no" active="no"/>
<layer number="26" name="bNames" color="7" fill="1" visible="no" active="no"/>
<layer number="27" name="tValues" color="7" fill="1" visible="no" active="no"/>
<layer number="28" name="bValues" color="7" fill="1" visible="no" active="no"/>
<layer number="29" name="tStop" color="7" fill="3" visible="no" active="no"/>
<layer number="30" name="bStop" color="7" fill="6" visible="no" active="no"/>
<layer number="31" name="tCream" color="7" fill="4" visible="no" active="no"/>
<layer number="32" name="bCream" color="7" fill="5" visible="no" active="no"/>
<layer number="33" name="tFinish" color="6" fill="3" visible="no" active="no"/>
<layer number="34" name="bFinish" color="6" fill="6" visible="no" active="no"/>
<layer number="35" name="tGlue" color="7" fill="4" visible="no" active="no"/>
<layer number="36" name="bGlue" color="7" fill="5" visible="no" active="no"/>
<layer number="37" name="tTest" color="7" fill="1" visible="no" active="no"/>
<layer number="38" name="bTest" color="7" fill="1" visible="no" active="no"/>
<layer number="39" name="tKeepout" color="4" fill="11" visible="no" active="no"/>
<layer number="40" name="bKeepout" color="1" fill="11" visible="no" active="no"/>
<layer number="41" name="tRestrict" color="4" fill="10" visible="no" active="no"/>
<layer number="42" name="bRestrict" color="1" fill="10" visible="no" active="no"/>
<layer number="43" name="vRestrict" color="2" fill="10" visible="no" active="no"/>
<layer number="44" name="Drills" color="7" fill="1" visible="no" active="no"/>
<layer number="45" name="Holes" color="7" fill="1" visible="no" active="no"/>
<layer number="46" name="Milling" color="3" fill="1" visible="no" active="no"/>
<layer number="47" name="Measures" color="7" fill="1" visible="no" active="no"/>
<layer number="48" name="Document" color="7" fill="1" visible="no" active="no"/>
<layer number="49" name="Reference" color="7" fill="1" visible="no" active="no"/>
<layer number="51" name="tDocu" color="7" fill="1" visible="no" active="no"/>
<layer number="52" name="bDocu" color="7" fill="1" visible="no" active="no"/>
<layer number="88" name="SimResults" color="9" fill="1" visible="yes" active="yes"/>
<layer number="89" name="SimProbes" color="9" fill="1" visible="yes" active="yes"/>
<layer number="90" name="Modules" color="5" fill="1" visible="yes" active="yes"/>
<layer number="91" name="Nets" color="2" fill="1" visible="yes" active="yes"/>
<layer number="92" name="Busses" color="1" fill="1" visible="yes" active="yes"/>
<layer number="93" name="Pins" color="2" fill="1" visible="no" active="yes"/>
<layer number="94" name="Symbols" color="4" fill="1" visible="yes" active="yes"/>
<layer number="95" name="Names" color="7" fill="1" visible="yes" active="yes"/>
<layer number="96" name="Values" color="7" fill="1" visible="yes" active="yes"/>
<layer number="97" name="Info" color="7" fill="1" visible="yes" active="yes"/>
<layer number="98" name="Guide" color="6" fill="1" visible="yes" active="yes"/>
</layers>
<schematic xreflabel="%F%N/%S.%C%R" xrefpart="/%S.%C%R">
<libraries>
<library name="microchip_pic12f">
<packages>
<package name="DIL8-P">
<description>&lt;b&gt;PDIP8 (P) 8-Lead plastic dual in line&lt;/b&gt; - 300mil body</description>
<wire x1="5.08" y1="2.921" x2="-5.08" y2="2.921" width="0.1524" layer="51"/>
<wire x1="-5.08" y1="-2.921" x2="5.08" y2="-2.921" width="0.1524" layer="51"/>
<wire x1="5.08" y1="2.921" x2="5.08" y2="-2.921" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="2.921" x2="-5.08" y2="1.016" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="-2.921" x2="-5.08" y2="-1.016" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="1.016" x2="-5.08" y2="-1.016" width="0.1524" layer="21" curve="-180"/>
<pad name="1" x="-3.81" y="-3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="2" x="-1.27" y="-3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="7" x="-1.27" y="3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="8" x="-3.81" y="3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="3" x="1.27" y="-3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="4" x="3.81" y="-3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="6" x="1.27" y="3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<pad name="5" x="3.81" y="3.81" drill="0.8" diameter="1.3" shape="long" rot="R90"/>
<text x="-5.334" y="-2.921" size="1.27" layer="25" ratio="10" rot="R90">&gt;NAME</text>
<text x="6.735" y="-4.956" size="1.27" layer="27" ratio="10" rot="R90">&gt;VALUE</text>
<wire x1="-2.9" y1="2.921" x2="-2.2" y2="2.921" width="0.1524" layer="21"/>
<wire x1="-0.36" y1="2.921" x2="0.34" y2="2.921" width="0.1524" layer="21"/>
<wire x1="2.18" y1="2.921" x2="2.88" y2="2.921" width="0.1524" layer="21"/>
<wire x1="4.72" y1="2.921" x2="5.02" y2="2.921" width="0.1524" layer="21"/>
<wire x1="-5.04" y1="2.921" x2="-4.74" y2="2.921" width="0.1524" layer="21"/>
<wire x1="-2.9" y1="-2.921" x2="-2.2" y2="-2.921" width="0.1524" layer="21"/>
<wire x1="-5.04" y1="-2.921" x2="-4.74" y2="-2.921" width="0.1524" layer="21"/>
<wire x1="-0.36" y1="-2.921" x2="0.34" y2="-2.921" width="0.1524" layer="21"/>
<wire x1="2.18" y1="-2.921" x2="2.88" y2="-2.921" width="0.1524" layer="21"/>
<wire x1="4.72" y1="-2.921" x2="5.02" y2="-2.921" width="0.1524" layer="21"/>
</package>
<package name="DFN8-MD">
<description>&lt;b&gt;DFN8 (MD) 8-Lead plastic dual, no lead package  &lt;/b&gt;- 4x4x0.9mm (Microchip)</description>
<smd name="1" x="-1.2" y="-2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="-1.2" y1="-2.0875" x2="-1.2" y2="-1.8" width="0.35" layer="1"/>
<wire x1="-1.2" y1="-2.0375" x2="-1.2" y2="-1.8" width="0.35" layer="31"/>
<wire x1="-1.2" y1="-2.0375" x2="-1.2" y2="-1.8" width="0.45" layer="29"/>
<rectangle x1="-1.425" y1="-2.425" x2="-0.975" y2="-1.8" layer="29"/>
<smd name="EP" x="0" y="0" dx="3.6" dy="2.5" layer="1" stop="no" cream="no"/>
<rectangle x1="-1.85" y1="-1.3" x2="1.85" y2="1.3" layer="29"/>
<text x="-2.5" y="-1.8" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<wire x1="-2.05" y1="-2" x2="-2.05" y2="2" width="0.15" layer="21"/>
<wire x1="2.05" y1="-2" x2="2.05" y2="2" width="0.15" layer="21"/>
<circle x="-2.092690625" y="-2.612178125" radius="0.071825" width="0.3" layer="21"/>
<smd name="2" x="-0.4" y="-2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="-0.4" y1="-2.0875" x2="-0.4" y2="-1.8" width="0.35" layer="1"/>
<wire x1="-0.4" y1="-2.0375" x2="-0.4" y2="-1.8" width="0.35" layer="31"/>
<wire x1="-0.4" y1="-2.0375" x2="-0.4" y2="-1.8" width="0.45" layer="29"/>
<rectangle x1="-0.625" y1="-2.425" x2="-0.175" y2="-1.8" layer="29"/>
<smd name="3" x="0.4" y="-2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="0.4" y1="-2.0875" x2="0.4" y2="-1.8" width="0.35" layer="1"/>
<wire x1="0.4" y1="-2.0375" x2="0.4" y2="-1.8" width="0.35" layer="31"/>
<wire x1="0.4" y1="-2.0375" x2="0.4" y2="-1.8" width="0.45" layer="29"/>
<rectangle x1="0.175" y1="-2.425" x2="0.625" y2="-1.8" layer="29"/>
<smd name="4" x="1.2" y="-2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="1.2" y1="-2.0875" x2="1.2" y2="-1.8" width="0.35" layer="1"/>
<wire x1="1.2" y1="-2.0375" x2="1.2" y2="-1.8" width="0.35" layer="31"/>
<wire x1="1.2" y1="-2.0375" x2="1.2" y2="-1.8" width="0.45" layer="29"/>
<rectangle x1="0.975" y1="-2.425" x2="1.425" y2="-1.8" layer="29"/>
<smd name="5" x="1.2" y="2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="1.2" y1="2.0875" x2="1.2" y2="1.8" width="0.35" layer="1"/>
<wire x1="1.2" y1="2.0375" x2="1.2" y2="1.8" width="0.35" layer="31"/>
<wire x1="1.2" y1="2.0375" x2="1.2" y2="1.8" width="0.45" layer="29"/>
<rectangle x1="0.975" y1="1.8" x2="1.425" y2="2.425" layer="29"/>
<smd name="6" x="0.4" y="2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="0.4" y1="2.0875" x2="0.4" y2="1.8" width="0.35" layer="1"/>
<wire x1="0.4" y1="2.0375" x2="0.4" y2="1.8" width="0.35" layer="31"/>
<wire x1="0.4" y1="2.0375" x2="0.4" y2="1.8" width="0.45" layer="29"/>
<rectangle x1="0.175" y1="1.8" x2="0.625" y2="2.425" layer="29"/>
<smd name="7" x="-0.4" y="2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="-0.4" y1="2.0875" x2="-0.4" y2="1.8" width="0.35" layer="1"/>
<wire x1="-0.4" y1="2.0375" x2="-0.4" y2="1.8" width="0.35" layer="31"/>
<wire x1="-0.4" y1="2.0375" x2="-0.4" y2="1.8" width="0.45" layer="29"/>
<rectangle x1="-0.625" y1="1.8" x2="-0.175" y2="2.425" layer="29"/>
<smd name="8" x="-1.2" y="2.0875" dx="0.35" dy="0.575" layer="1" stop="no"/>
<wire x1="-1.2" y1="2.0875" x2="-1.2" y2="1.8" width="0.35" layer="1"/>
<wire x1="-1.2" y1="2.0375" x2="-1.2" y2="1.8" width="0.35" layer="31"/>
<wire x1="-1.2" y1="2.0375" x2="-1.2" y2="1.8" width="0.45" layer="29"/>
<rectangle x1="-1.425" y1="1.8" x2="-0.975" y2="2.425" layer="29"/>
<wire x1="-2" y1="2" x2="-1.7" y2="2" width="0.15" layer="21"/>
<wire x1="-2" y1="-2" x2="-1.7" y2="-2" width="0.15" layer="21"/>
<wire x1="1.7" y1="-2" x2="2" y2="-2" width="0.15" layer="21"/>
<wire x1="1.7" y1="2" x2="2" y2="2" width="0.15" layer="21"/>
<rectangle x1="-1.4" y1="-1" x2="-0.2" y2="-0.2" layer="31"/>
<rectangle x1="-1.4" y1="0.2" x2="-0.2" y2="1" layer="31"/>
<rectangle x1="0.2" y1="-1" x2="1.4" y2="-0.2" layer="31"/>
<rectangle x1="0.2" y1="0.2" x2="1.4" y2="1" layer="31"/>
</package>
<package name="SOIC8-SN">
<description>&lt;B&gt;SOIC8 (SN) 8-Lead plastic small outline - narrow&lt;/B&gt; - 3.9 mm body</description>
<wire x1="2.5" y1="1.65" x2="2.5" y2="-1.65" width="0.2032" layer="21"/>
<smd name="2" x="-0.635" y="-2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="7" x="-0.635" y="2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="1" x="-1.905" y="-2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="3" x="0.635" y="-2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="4" x="1.905" y="-2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="8" x="-1.905" y="2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="6" x="0.635" y="2.7" dx="0.6" dy="1.5" layer="1"/>
<smd name="5" x="1.905" y="2.7" dx="0.6" dy="1.5" layer="1"/>
<text x="-2.817" y="-1.955" size="1.27" layer="25" rot="R90">&gt;NAME</text>
<text x="4.037" y="-3.355" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-2.1501" y1="-3.1001" x2="-1.6599" y2="-2" layer="51"/>
<rectangle x1="-0.8801" y1="-3.1001" x2="-0.3899" y2="-2" layer="51"/>
<rectangle x1="0.3899" y1="-3.1001" x2="0.8801" y2="-2" layer="51"/>
<rectangle x1="1.6599" y1="-3.1001" x2="2.1501" y2="-2" layer="51"/>
<rectangle x1="1.6599" y1="2" x2="2.1501" y2="3.1001" layer="51"/>
<rectangle x1="0.3899" y1="2" x2="0.8801" y2="3.1001" layer="51"/>
<rectangle x1="-0.8801" y1="2" x2="-0.3899" y2="3.1001" layer="51"/>
<rectangle x1="-2.1501" y1="2" x2="-1.6599" y2="3.1001" layer="51"/>
<wire x1="-2.51" y1="0.66" x2="-2.51" y2="-0.64" width="0.2032" layer="21" curve="-180"/>
<wire x1="-2.55" y1="-0.7" x2="-2.55" y2="-1.65" width="0.2032" layer="21"/>
<wire x1="-2.55" y1="0.7" x2="-2.55" y2="1.65" width="0.2032" layer="21"/>
<wire x1="-2.5" y1="-1.65" x2="2.45" y2="-1.65" width="0.2" layer="21"/>
<wire x1="-2.5" y1="1.65" x2="2.4" y2="1.65" width="0.2" layer="21"/>
</package>
</packages>
<symbols>
<symbol name="PIC12F508">
<wire x1="-10.16" y1="5.08" x2="-9.144" y2="5.08" width="0.4064" layer="94"/>
<wire x1="-9.144" y1="5.08" x2="10.16" y2="5.08" width="0.4064" layer="94"/>
<wire x1="10.16" y1="5.08" x2="10.16" y2="-7.62" width="0.4064" layer="94"/>
<wire x1="10.16" y1="-7.62" x2="-10.16" y2="-7.62" width="0.4064" layer="94"/>
<wire x1="-10.16" y1="-7.62" x2="-10.16" y2="4.064" width="0.4064" layer="94"/>
<text x="-10.16" y="6.096" size="1.778" layer="95">&gt;NAME</text>
<text x="-10.414" y="-10.414" size="1.778" layer="96">&gt;VALUE</text>
<pin name="GP1" x="12.7" y="-2.54" length="short" rot="R180"/>
<pin name="GP0" x="12.7" y="0" length="short" rot="R180"/>
<pin name="VSS" x="12.7" y="2.54" length="short" direction="pas" rot="R180"/>
<pin name="GP4" x="-12.7" y="-2.54" length="short"/>
<pin name="VDD" x="-12.7" y="2.54" length="short" direction="pas"/>
<pin name="GP5" x="-12.7" y="0" length="short"/>
<wire x1="-10.16" y1="4.064" x2="-10.16" y2="5.08" width="0.4064" layer="94"/>
<wire x1="-9.144" y1="5.08" x2="-10.16" y2="4.064" width="0.4064" layer="94"/>
<pin name="GP3/!MC!" x="-12.7" y="-5.08" length="short"/>
<pin name="GP2" x="12.7" y="-5.08" length="short" rot="R180"/>
<text x="8.636" y="-0.508" size="1.016" layer="94" ratio="15">D</text>
<text x="8.636" y="-3.048" size="1.016" layer="94" ratio="15">C</text>
</symbol>
</symbols>
<devicesets>
<deviceset name="PIC12F675" prefix="U">
<description>Low pincount microcontroller&lt;br&gt;
&lt;a href="http://www.microchip.com/wwwproducts/Devices.aspx?product=PIC12F675"&gt;http://www.microchip.com/wwwproducts/Devices.aspx?product=PIC12F675&lt;/a&gt;
&lt;hr&gt;
&lt;h2&gt;Properties&lt;/h2&gt;
&lt;table class="border"&gt;&lt;tbody&gt;&lt;tr class="tableheader"&gt;&lt;td&gt;&amp;nbsp;Parameter Name&lt;/td&gt;&lt;td&gt;&amp;nbsp;Value&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowitem"&gt;&lt;td&gt;Program Memory Type&lt;/td&gt;&lt;td&gt;Flash&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowaltitem"&gt;&lt;td&gt;Program Memory (KB)&lt;/td&gt;&lt;td&gt;1.75&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowitem"&gt;&lt;td&gt;CPU Speed (MIPS)&lt;/td&gt;&lt;td&gt;5&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowaltitem"&gt;&lt;td&gt;RAM Bytes&lt;/td&gt;&lt;td&gt;64&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowitem"&gt;&lt;td&gt;Data EEPROM (bytes)&lt;/td&gt;&lt;td&gt;128&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowaltitem"&gt;&lt;td&gt;Timers&lt;/td&gt;&lt;td&gt;1 x 8-bit, 1 x 16-bit&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowitem"&gt;&lt;td&gt;ADC&lt;/td&gt;&lt;td&gt;4 ch, 10-bit&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowaltitem"&gt;&lt;td&gt;Comparators&lt;/td&gt;&lt;td&gt;1&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowitem"&gt;&lt;td&gt;Temperature Range (C)&lt;/td&gt;&lt;td&gt;-40 to 125&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowaltitem"&gt;&lt;td&gt;Operating Voltage Range (V)&lt;/td&gt;&lt;td&gt;2 to 5.5&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowitem"&gt;&lt;td&gt;Pin Count&lt;/td&gt;&lt;td&gt;8&lt;/td&gt;&lt;/tr&gt;&lt;tr class="rowaltitem"&gt;&lt;td&gt;Cap Touch Channels&lt;/td&gt;&lt;td&gt;4&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;
&lt;h2&gt; Features&lt;/h2&gt;
&lt;ul&gt;        &lt;li&gt;128 bytes of EEPROM data memory,&lt;/li&gt;        &lt;li&gt;Programmable pull-up resistors, &lt;/li&gt;        &lt;li&gt;MPLAB® ICD-2 programming support or debugging support with optional header adapter,&lt;/li&gt;        &lt;li&gt;4 oscillator selections including 4 MHz RC oscillator with programmable calibration            and Power-On Reset.&lt;/li&gt;    &lt;/ul&gt;
&lt;hr&gt;
&lt;small&gt;Library from&lt;a href="www.mikroelektroniikka.fi/lbr"&gt; www.mikroelektroniikka.fi/lbr&lt;/a&gt;&lt;/small&gt;</description>
<gates>
<gate name="U" symbol="PIC12F508" x="0" y="0"/>
</gates>
<devices>
<device name="/P" package="DIL8-P">
<connects>
<connect gate="U" pin="GP0" pad="7"/>
<connect gate="U" pin="GP1" pad="6"/>
<connect gate="U" pin="GP2" pad="5"/>
<connect gate="U" pin="GP3/!MC!" pad="4"/>
<connect gate="U" pin="GP4" pad="3"/>
<connect gate="U" pin="GP5" pad="2"/>
<connect gate="U" pin="VDD" pad="1"/>
<connect gate="U" pin="VSS" pad="8"/>
</connects>
<technologies>
<technology name=""/>
</technologies>
</device>
<device name="/MD" package="DFN8-MD">
<connects>
<connect gate="U" pin="GP0" pad="7"/>
<connect gate="U" pin="GP1" pad="6"/>
<connect gate="U" pin="GP2" pad="5"/>
<connect gate="U" pin="GP3/!MC!" pad="4"/>
<connect gate="U" pin="GP4" pad="3"/>
<connect gate="U" pin="GP5" pad="2"/>
<connect gate="U" pin="VDD" pad="1"/>
<connect gate="U" pin="VSS" pad="8 EP"/>
</connects>
<technologies>
<technology name=""/>
</technologies>
</device>
<device name="/SN" package="SOIC8-SN">
<connects>
<connect gate="U" pin="GP0" pad="7"/>
<connect gate="U" pin="GP1" pad="6"/>
<connect gate="U" pin="GP2" pad="5"/>
<connect gate="U" pin="GP3/!MC!" pad="4"/>
<connect gate="U" pin="GP4" pad="3"/>
<connect gate="U" pin="GP5" pad="2"/>
<connect gate="U" pin="VDD" pad="1"/>
<connect gate="U" pin="VSS" pad="8"/>
</connects>
<technologies>
<technology name=""/>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="con-lstb" urn="urn:adsk.eagle:library:162">
<description>&lt;b&gt;Pin Headers&lt;/b&gt;&lt;p&gt;
Naming:&lt;p&gt;
MA = male&lt;p&gt;
# contacts - # rows&lt;p&gt;
W = angled&lt;p&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
<package name="MA03-1" urn="urn:adsk.eagle:footprint:8281/1" library_version="1">
<description>&lt;b&gt;PIN HEADER&lt;/b&gt;</description>
<wire x1="-3.175" y1="1.27" x2="-1.905" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="1.27" x2="-1.27" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="-0.635" x2="-1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="0.635" x2="-0.635" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="1.27" x2="0.635" y2="1.27" width="0.1524" layer="21"/>
<wire x1="0.635" y1="1.27" x2="1.27" y2="0.635" width="0.1524" layer="21"/>
<wire x1="1.27" y1="-0.635" x2="0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.27" x2="-0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.27" x2="-1.27" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-3.81" y1="0.635" x2="-3.81" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="1.27" x2="-3.81" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-3.81" y1="-0.635" x2="-3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.27" x2="-3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.27" y1="0.635" x2="1.905" y2="1.27" width="0.1524" layer="21"/>
<wire x1="1.905" y1="1.27" x2="3.175" y2="1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="1.27" x2="3.81" y2="0.635" width="0.1524" layer="21"/>
<wire x1="3.81" y1="-0.635" x2="3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.27" x2="1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.27" x2="1.27" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="3.81" y1="0.635" x2="3.81" y2="-0.635" width="0.1524" layer="21"/>
<pad name="1" x="-2.54" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="2" x="0" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="3" x="2.54" y="0" drill="1.016" shape="long" rot="R90"/>
<text x="-3.81" y="1.651" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-5.08" y="-0.635" size="1.27" layer="21" ratio="10">1</text>
<text x="-3.81" y="-2.921" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="-0.254" y1="-0.254" x2="0.254" y2="0.254" layer="51"/>
<rectangle x1="-2.794" y1="-0.254" x2="-2.286" y2="0.254" layer="51"/>
<rectangle x1="2.286" y1="-0.254" x2="2.794" y2="0.254" layer="51"/>
</package>
</packages>
<packages3d>
<package3d name="MA03-1" urn="urn:adsk.eagle:package:8339/1" type="box" library_version="1">
<description>PIN HEADER</description>
<packageinstances>
<packageinstance name="MA03-1"/>
</packageinstances>
</package3d>
</packages3d>
<symbols>
<symbol name="MA03-1" urn="urn:adsk.eagle:symbol:8280/1" library_version="1">
<wire x1="3.81" y1="-5.08" x2="-1.27" y2="-5.08" width="0.4064" layer="94"/>
<wire x1="1.27" y1="2.54" x2="2.54" y2="2.54" width="0.6096" layer="94"/>
<wire x1="1.27" y1="0" x2="2.54" y2="0" width="0.6096" layer="94"/>
<wire x1="1.27" y1="-2.54" x2="2.54" y2="-2.54" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="5.08" x2="-1.27" y2="-5.08" width="0.4064" layer="94"/>
<wire x1="3.81" y1="-5.08" x2="3.81" y2="5.08" width="0.4064" layer="94"/>
<wire x1="-1.27" y1="5.08" x2="3.81" y2="5.08" width="0.4064" layer="94"/>
<text x="-1.27" y="-7.62" size="1.778" layer="96">&gt;VALUE</text>
<text x="-1.27" y="5.842" size="1.778" layer="95">&gt;NAME</text>
<pin name="1" x="7.62" y="-2.54" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="2" x="7.62" y="0" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="3" x="7.62" y="2.54" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="MA03-1" urn="urn:adsk.eagle:component:8376/1" prefix="SV" uservalue="yes" library_version="1">
<description>&lt;b&gt;PIN HEADER&lt;/b&gt;</description>
<gates>
<gate name="G$1" symbol="MA03-1" x="0" y="0"/>
</gates>
<devices>
<device name="" package="MA03-1">
<connects>
<connect gate="G$1" pin="1" pad="1"/>
<connect gate="G$1" pin="2" pad="2"/>
<connect gate="G$1" pin="3" pad="3"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:8339/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="MF" value="" constant="no"/>
<attribute name="MPN" value="" constant="no"/>
<attribute name="OC_FARNELL" value="unknown" constant="no"/>
<attribute name="OC_NEWARK" value="unknown" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="buzzer" urn="urn:adsk.eagle:library:113">
<description>&lt;b&gt;Speakers and Buzzers&lt;/b&gt;&lt;p&gt;
&lt;ul&gt;Distributors:
&lt;li&gt;Buerklin
&lt;li&gt;Spoerle
&lt;li&gt;Schukat
&lt;/ul&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
<package name="F/CM12P" urn="urn:adsk.eagle:footprint:5223/1" library_version="1">
<description>&lt;b&gt;BUZZER&lt;/b&gt;</description>
<wire x1="3.175" y1="3.048" x2="4.445" y2="3.048" width="0.254" layer="21"/>
<wire x1="3.81" y1="3.683" x2="3.81" y2="2.413" width="0.254" layer="21"/>
<circle x="0" y="0" radius="6.985" width="0.1524" layer="21"/>
<circle x="0" y="0" radius="1.27" width="0.1524" layer="21"/>
<circle x="3.81" y="3.048" radius="1.27" width="0.1524" layer="21"/>
<pad name="-" x="-3.81" y="0" drill="1.016" diameter="2.54" shape="octagon"/>
<pad name="+" x="3.81" y="0" drill="1.016" diameter="2.54" shape="octagon"/>
<text x="2.54" y="6.985" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-4.445" y="-3.81" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
</package>
</packages>
<packages3d>
<package3d name="F/CM12P" urn="urn:adsk.eagle:package:5265/1" type="box" library_version="1">
<description>BUZZER</description>
<packageinstances>
<packageinstance name="F/CM12P"/>
</packageinstances>
</package3d>
</packages3d>
<symbols>
<symbol name="B2P" urn="urn:adsk.eagle:symbol:5221/1" library_version="1">
<wire x1="-1.27" y1="3.175" x2="0" y2="3.175" width="0.1524" layer="94"/>
<wire x1="0" y1="3.175" x2="0" y2="3.81" width="0.1524" layer="94"/>
<wire x1="0" y1="3.175" x2="0" y2="2.54" width="0.1524" layer="94"/>
<wire x1="0.635" y1="4.445" x2="0.635" y2="1.905" width="0.1524" layer="94"/>
<wire x1="0.635" y1="1.905" x2="1.905" y2="1.905" width="0.1524" layer="94"/>
<wire x1="1.905" y1="1.905" x2="1.905" y2="4.445" width="0.1524" layer="94"/>
<wire x1="1.905" y1="4.445" x2="0.635" y2="4.445" width="0.1524" layer="94"/>
<wire x1="2.54" y1="3.81" x2="2.54" y2="3.175" width="0.1524" layer="94"/>
<wire x1="2.54" y1="3.175" x2="3.81" y2="3.175" width="0.1524" layer="94"/>
<wire x1="2.54" y1="3.175" x2="2.54" y2="2.54" width="0.1524" layer="94"/>
<wire x1="2.54" y1="-2.54" x2="2.54" y2="1.27" width="0.1524" layer="94"/>
<wire x1="0" y1="-2.54" x2="0" y2="1.27" width="0.1524" layer="94"/>
<wire x1="-2.54" y1="1.27" x2="0" y2="1.27" width="0.254" layer="94"/>
<wire x1="5.08" y1="1.27" x2="5.08" y2="5.08" width="0.254" layer="94"/>
<wire x1="5.08" y1="5.08" x2="5.715" y2="5.08" width="0.254" layer="94"/>
<wire x1="5.715" y1="5.08" x2="5.715" y2="5.715" width="0.254" layer="94"/>
<wire x1="5.715" y1="5.715" x2="-3.175" y2="5.715" width="0.254" layer="94"/>
<wire x1="-3.175" y1="5.715" x2="-3.175" y2="5.08" width="0.254" layer="94"/>
<wire x1="-3.175" y1="5.08" x2="-2.54" y2="5.08" width="0.254" layer="94"/>
<wire x1="-2.54" y1="5.08" x2="-2.54" y2="1.27" width="0.254" layer="94"/>
<wire x1="-2.54" y1="5.08" x2="5.08" y2="5.08" width="0.254" layer="94"/>
<wire x1="2.54" y1="1.27" x2="5.08" y2="1.27" width="0.254" layer="94"/>
<wire x1="0" y1="1.27" x2="2.54" y2="1.27" width="0.254" layer="94"/>
<text x="-2.54" y="6.35" size="1.778" layer="95">&gt;NAME</text>
<text x="6.35" y="0" size="1.778" layer="96">&gt;VALUE</text>
<pin name="2" x="5.08" y="-2.54" visible="pad" length="short" direction="pas" rot="R180"/>
<pin name="1" x="-2.54" y="-2.54" visible="pad" length="short" direction="pas"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="F/CM12P" urn="urn:adsk.eagle:component:5310/1" prefix="SG" library_version="1">
<description>&lt;b&gt;BUZZER&lt;/b&gt;&lt;p&gt; Source: Buerklin</description>
<gates>
<gate name="G$1" symbol="B2P" x="0" y="0"/>
</gates>
<devices>
<device name="" package="F/CM12P">
<connects>
<connect gate="G$1" pin="1" pad="+"/>
<connect gate="G$1" pin="2" pad="-"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:5265/1"/>
</package3dinstances>
<technologies>
<technology name="">
<attribute name="MF" value="" constant="no"/>
<attribute name="MPN" value="" constant="no"/>
<attribute name="OC_FARNELL" value="unknown" constant="no"/>
<attribute name="OC_NEWARK" value="unknown" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="pinhead" urn="urn:adsk.eagle:library:325">
<description>&lt;b&gt;Pin Header Connectors&lt;/b&gt;&lt;p&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
<package name="1X06" urn="urn:adsk.eagle:footprint:22361/1" library_version="3">
<description>&lt;b&gt;PIN HEADER&lt;/b&gt;</description>
<wire x1="0.635" y1="1.27" x2="1.905" y2="1.27" width="0.1524" layer="21"/>
<wire x1="1.905" y1="1.27" x2="2.54" y2="0.635" width="0.1524" layer="21"/>
<wire x1="2.54" y1="0.635" x2="2.54" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="2.54" y1="-0.635" x2="1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="2.54" y1="0.635" x2="3.175" y2="1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="1.27" x2="4.445" y2="1.27" width="0.1524" layer="21"/>
<wire x1="4.445" y1="1.27" x2="5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="5.08" y1="0.635" x2="5.08" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="5.08" y1="-0.635" x2="4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.27" x2="3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.27" x2="2.54" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="0.635" x2="-1.905" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="1.27" x2="-0.635" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="1.27" x2="0" y2="0.635" width="0.1524" layer="21"/>
<wire x1="0" y1="0.635" x2="0" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="0" y1="-0.635" x2="-0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.27" x2="-1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.27" x2="-2.54" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="0.635" y1="1.27" x2="0" y2="0.635" width="0.1524" layer="21"/>
<wire x1="0" y1="-0.635" x2="0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.27" x2="0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-6.985" y1="1.27" x2="-5.715" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="1.27" x2="-5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="0.635" x2="-5.08" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="-0.635" x2="-5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="0.635" x2="-4.445" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="1.27" x2="-3.175" y2="1.27" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="1.27" x2="-2.54" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="0.635" x2="-2.54" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-0.635" x2="-3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.27" x2="-4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.27" x2="-5.08" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-7.62" y1="0.635" x2="-7.62" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="-6.985" y1="1.27" x2="-7.62" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-7.62" y1="-0.635" x2="-6.985" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.27" x2="-6.985" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="5.715" y1="1.27" x2="6.985" y2="1.27" width="0.1524" layer="21"/>
<wire x1="6.985" y1="1.27" x2="7.62" y2="0.635" width="0.1524" layer="21"/>
<wire x1="7.62" y1="0.635" x2="7.62" y2="-0.635" width="0.1524" layer="21"/>
<wire x1="7.62" y1="-0.635" x2="6.985" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="5.715" y1="1.27" x2="5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="5.08" y1="-0.635" x2="5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="6.985" y1="-1.27" x2="5.715" y2="-1.27" width="0.1524" layer="21"/>
<pad name="1" x="-6.35" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="2" x="-3.81" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="3" x="-1.27" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="4" x="1.27" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="5" x="3.81" y="0" drill="1.016" shape="long" rot="R90"/>
<pad name="6" x="6.35" y="0" drill="1.016" shape="long" rot="R90"/>
<text x="-7.6962" y="1.8288" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-7.62" y="-3.175" size="1.27" layer="27">&gt;VALUE</text>
<rectangle x1="3.556" y1="-0.254" x2="4.064" y2="0.254" layer="51"/>
<rectangle x1="1.016" y1="-0.254" x2="1.524" y2="0.254" layer="51"/>
<rectangle x1="-1.524" y1="-0.254" x2="-1.016" y2="0.254" layer="51"/>
<rectangle x1="-4.064" y1="-0.254" x2="-3.556" y2="0.254" layer="51"/>
<rectangle x1="-6.604" y1="-0.254" x2="-6.096" y2="0.254" layer="51"/>
<rectangle x1="6.096" y1="-0.254" x2="6.604" y2="0.254" layer="51"/>
</package>
<package name="1X06/90" urn="urn:adsk.eagle:footprint:22362/1" library_version="3">
<description>&lt;b&gt;PIN HEADER&lt;/b&gt;</description>
<wire x1="-7.62" y1="-1.905" x2="-5.08" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="-1.905" x2="-5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-5.08" y1="0.635" x2="-7.62" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-7.62" y1="0.635" x2="-7.62" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="-6.35" y1="6.985" x2="-6.35" y2="1.27" width="0.762" layer="21"/>
<wire x1="-5.08" y1="-1.905" x2="-2.54" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-1.905" x2="-2.54" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="0.635" x2="-5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-3.81" y1="6.985" x2="-3.81" y2="1.27" width="0.762" layer="21"/>
<wire x1="-2.54" y1="-1.905" x2="0" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="0" y1="-1.905" x2="0" y2="0.635" width="0.1524" layer="21"/>
<wire x1="0" y1="0.635" x2="-2.54" y2="0.635" width="0.1524" layer="21"/>
<wire x1="-1.27" y1="6.985" x2="-1.27" y2="1.27" width="0.762" layer="21"/>
<wire x1="0" y1="-1.905" x2="2.54" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="2.54" y1="-1.905" x2="2.54" y2="0.635" width="0.1524" layer="21"/>
<wire x1="2.54" y1="0.635" x2="0" y2="0.635" width="0.1524" layer="21"/>
<wire x1="1.27" y1="6.985" x2="1.27" y2="1.27" width="0.762" layer="21"/>
<wire x1="2.54" y1="-1.905" x2="5.08" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="5.08" y1="-1.905" x2="5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="5.08" y1="0.635" x2="2.54" y2="0.635" width="0.1524" layer="21"/>
<wire x1="3.81" y1="6.985" x2="3.81" y2="1.27" width="0.762" layer="21"/>
<wire x1="5.08" y1="-1.905" x2="7.62" y2="-1.905" width="0.1524" layer="21"/>
<wire x1="7.62" y1="-1.905" x2="7.62" y2="0.635" width="0.1524" layer="21"/>
<wire x1="7.62" y1="0.635" x2="5.08" y2="0.635" width="0.1524" layer="21"/>
<wire x1="6.35" y1="6.985" x2="6.35" y2="1.27" width="0.762" layer="21"/>
<pad name="1" x="-6.35" y="-3.81" drill="1.016" shape="long" rot="R90"/>
<pad name="2" x="-3.81" y="-3.81" drill="1.016" shape="long" rot="R90"/>
<pad name="3" x="-1.27" y="-3.81" drill="1.016" shape="long" rot="R90"/>
<pad name="4" x="1.27" y="-3.81" drill="1.016" shape="long" rot="R90"/>
<pad name="5" x="3.81" y="-3.81" drill="1.016" shape="long" rot="R90"/>
<pad name="6" x="6.35" y="-3.81" drill="1.016" shape="long" rot="R90"/>
<text x="-8.255" y="-3.81" size="1.27" layer="25" ratio="10" rot="R90">&gt;NAME</text>
<text x="9.525" y="-3.81" size="1.27" layer="27" rot="R90">&gt;VALUE</text>
<rectangle x1="-6.731" y1="0.635" x2="-5.969" y2="1.143" layer="21"/>
<rectangle x1="-4.191" y1="0.635" x2="-3.429" y2="1.143" layer="21"/>
<rectangle x1="-1.651" y1="0.635" x2="-0.889" y2="1.143" layer="21"/>
<rectangle x1="0.889" y1="0.635" x2="1.651" y2="1.143" layer="21"/>
<rectangle x1="3.429" y1="0.635" x2="4.191" y2="1.143" layer="21"/>
<rectangle x1="5.969" y1="0.635" x2="6.731" y2="1.143" layer="21"/>
<rectangle x1="-6.731" y1="-2.921" x2="-5.969" y2="-1.905" layer="21"/>
<rectangle x1="-4.191" y1="-2.921" x2="-3.429" y2="-1.905" layer="21"/>
<rectangle x1="-1.651" y1="-2.921" x2="-0.889" y2="-1.905" layer="21"/>
<rectangle x1="0.889" y1="-2.921" x2="1.651" y2="-1.905" layer="21"/>
<rectangle x1="3.429" y1="-2.921" x2="4.191" y2="-1.905" layer="21"/>
<rectangle x1="5.969" y1="-2.921" x2="6.731" y2="-1.905" layer="21"/>
</package>
</packages>
<packages3d>
<package3d name="1X06" urn="urn:adsk.eagle:package:22472/2" type="model" library_version="3">
<description>PIN HEADER</description>
<packageinstances>
<packageinstance name="1X06"/>
</packageinstances>
</package3d>
<package3d name="1X06/90" urn="urn:adsk.eagle:package:22475/2" type="model" library_version="3">
<description>PIN HEADER</description>
<packageinstances>
<packageinstance name="1X06/90"/>
</packageinstances>
</package3d>
</packages3d>
<symbols>
<symbol name="PINHD6" urn="urn:adsk.eagle:symbol:22360/1" library_version="3">
<wire x1="-6.35" y1="-7.62" x2="1.27" y2="-7.62" width="0.4064" layer="94"/>
<wire x1="1.27" y1="-7.62" x2="1.27" y2="10.16" width="0.4064" layer="94"/>
<wire x1="1.27" y1="10.16" x2="-6.35" y2="10.16" width="0.4064" layer="94"/>
<wire x1="-6.35" y1="10.16" x2="-6.35" y2="-7.62" width="0.4064" layer="94"/>
<text x="-6.35" y="10.795" size="1.778" layer="95">&gt;NAME</text>
<text x="-6.35" y="-10.16" size="1.778" layer="96">&gt;VALUE</text>
<pin name="1" x="-2.54" y="7.62" visible="pad" length="short" direction="pas" function="dot"/>
<pin name="2" x="-2.54" y="5.08" visible="pad" length="short" direction="pas" function="dot"/>
<pin name="3" x="-2.54" y="2.54" visible="pad" length="short" direction="pas" function="dot"/>
<pin name="4" x="-2.54" y="0" visible="pad" length="short" direction="pas" function="dot"/>
<pin name="5" x="-2.54" y="-2.54" visible="pad" length="short" direction="pas" function="dot"/>
<pin name="6" x="-2.54" y="-5.08" visible="pad" length="short" direction="pas" function="dot"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="PINHD-1X6" urn="urn:adsk.eagle:component:22533/3" prefix="JP" uservalue="yes" library_version="3">
<description>&lt;b&gt;PIN HEADER&lt;/b&gt;</description>
<gates>
<gate name="A" symbol="PINHD6" x="0" y="-2.54"/>
</gates>
<devices>
<device name="" package="1X06">
<connects>
<connect gate="A" pin="1" pad="1"/>
<connect gate="A" pin="2" pad="2"/>
<connect gate="A" pin="3" pad="3"/>
<connect gate="A" pin="4" pad="4"/>
<connect gate="A" pin="5" pad="5"/>
<connect gate="A" pin="6" pad="6"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:22472/2"/>
</package3dinstances>
<technologies>
<technology name=""/>
</technologies>
</device>
<device name="/90" package="1X06/90">
<connects>
<connect gate="A" pin="1" pad="1"/>
<connect gate="A" pin="2" pad="2"/>
<connect gate="A" pin="3" pad="3"/>
<connect gate="A" pin="4" pad="4"/>
<connect gate="A" pin="5" pad="5"/>
<connect gate="A" pin="6" pad="6"/>
</connects>
<package3dinstances>
<package3dinstance package3d_urn="urn:adsk.eagle:package:22475/2"/>
</package3dinstances>
<technologies>
<technology name=""/>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
</libraries>
<attributes>
</attributes>
<variantdefs>
</variantdefs>
<classes>
<class number="0" name="default" width="0" drill="0">
</class>
</classes>
<parts>
<part name="U1" library="microchip_pic12f" deviceset="PIC12F675" device="/P"/>
<part name="SV1" library="con-lstb" library_urn="urn:adsk.eagle:library:162" deviceset="MA03-1" device="" package3d_urn="urn:adsk.eagle:package:8339/1"/>
<part name="SG1" library="buzzer" library_urn="urn:adsk.eagle:library:113" deviceset="F/CM12P" device="" package3d_urn="urn:adsk.eagle:package:5265/1"/>
<part name="JP1" library="pinhead" library_urn="urn:adsk.eagle:library:325" deviceset="PINHD-1X6" device="" package3d_urn="urn:adsk.eagle:package:22472/2"/>
</parts>
<sheets>
<sheet>
<plain>
</plain>
<instances>
<instance part="U1" gate="U" x="0" y="68.58" smashed="yes">
<attribute name="NAME" x="-10.16" y="74.676" size="1.778" layer="95"/>
<attribute name="VALUE" x="-10.414" y="58.166" size="1.778" layer="96"/>
</instance>
<instance part="SV1" gate="G$1" x="35.56" y="45.72" smashed="yes" rot="R180">
<attribute name="VALUE" x="36.83" y="53.34" size="1.778" layer="96" rot="R180"/>
<attribute name="NAME" x="36.83" y="39.878" size="1.778" layer="95" rot="R180"/>
</instance>
<instance part="SG1" gate="G$1" x="-7.62" y="35.56" smashed="yes">
<attribute name="NAME" x="-10.16" y="41.91" size="1.778" layer="95"/>
<attribute name="VALUE" x="-1.27" y="35.56" size="1.778" layer="96"/>
</instance>
<instance part="JP1" gate="A" x="43.18" y="66.04" smashed="yes">
<attribute name="NAME" x="36.83" y="76.835" size="1.778" layer="95"/>
<attribute name="VALUE" x="36.83" y="55.88" size="1.778" layer="96"/>
</instance>
</instances>
<busses>
</busses>
<nets>
<net name="VSS" class="0">
<segment>
<pinref part="U1" gate="U" pin="VSS"/>
<wire x1="12.7" y1="71.12" x2="20.32" y2="71.12" width="0.1524" layer="91"/>
<pinref part="SV1" gate="G$1" pin="1"/>
<wire x1="27.94" y1="48.26" x2="22.86" y2="48.26" width="0.1524" layer="91"/>
<wire x1="22.86" y1="48.26" x2="22.86" y2="66.04" width="0.1524" layer="91"/>
<label x="12.7" y="78.74" size="1.778" layer="95" rot="R90"/>
<pinref part="SG1" gate="G$1" pin="2"/>
<wire x1="22.86" y1="66.04" x2="20.32" y2="71.12" width="0.1524" layer="91"/>
<wire x1="22.86" y1="48.26" x2="20.32" y2="33.02" width="0.1524" layer="91"/>
<wire x1="20.32" y1="33.02" x2="-2.54" y2="33.02" width="0.1524" layer="91"/>
<junction x="22.86" y="48.26"/>
<pinref part="JP1" gate="A" pin="4"/>
<wire x1="40.64" y1="66.04" x2="22.86" y2="66.04" width="0.1524" layer="91"/>
<junction x="22.86" y="66.04"/>
</segment>
</net>
<net name="VDD" class="0">
<segment>
<pinref part="U1" gate="U" pin="VDD"/>
<wire x1="-12.7" y1="71.12" x2="-15.24" y2="71.12" width="0.1524" layer="91"/>
<pinref part="SV1" gate="G$1" pin="2"/>
<wire x1="27.94" y1="45.72" x2="-15.24" y2="45.72" width="0.1524" layer="91"/>
<wire x1="-15.24" y1="45.72" x2="-15.24" y2="71.12" width="0.1524" layer="91"/>
<pinref part="JP1" gate="A" pin="6"/>
<wire x1="40.64" y1="60.96" x2="27.94" y2="60.96" width="0.1524" layer="91"/>
<wire x1="27.94" y1="60.96" x2="27.94" y2="81.28" width="0.1524" layer="91"/>
<wire x1="27.94" y1="81.28" x2="-17.78" y2="81.28" width="0.1524" layer="91"/>
<wire x1="-17.78" y1="81.28" x2="-17.78" y2="71.12" width="0.1524" layer="91"/>
<wire x1="-17.78" y1="71.12" x2="-15.24" y2="71.12" width="0.1524" layer="91"/>
<junction x="-15.24" y="71.12"/>
</segment>
</net>
<net name="SINAL" class="0">
<segment>
<pinref part="U1" gate="U" pin="GP0"/>
<wire x1="12.7" y1="68.58" x2="17.78" y2="68.58" width="0.1524" layer="91"/>
<wire x1="17.78" y1="68.58" x2="17.78" y2="43.18" width="0.1524" layer="91"/>
<pinref part="SV1" gate="G$1" pin="3"/>
<wire x1="17.78" y1="43.18" x2="27.94" y2="43.18" width="0.1524" layer="91"/>
<label x="25.4" y="40.64" size="1.778" layer="95"/>
</segment>
</net>
<net name="N$3" class="0">
<segment>
<pinref part="U1" gate="U" pin="GP4"/>
<wire x1="-12.7" y1="66.04" x2="-17.78" y2="66.04" width="0.1524" layer="91"/>
<pinref part="SG1" gate="G$1" pin="1"/>
<wire x1="-17.78" y1="66.04" x2="-17.78" y2="33.02" width="0.1524" layer="91"/>
<wire x1="-17.78" y1="33.02" x2="-10.16" y2="33.02" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$2" class="0">
<segment>
<pinref part="JP1" gate="A" pin="2"/>
<wire x1="40.64" y1="71.12" x2="22.86" y2="71.12" width="0.1524" layer="91"/>
<pinref part="U1" gate="U" pin="GP1"/>
<wire x1="22.86" y1="71.12" x2="17.78" y2="66.04" width="0.1524" layer="91"/>
<wire x1="17.78" y1="66.04" x2="12.7" y2="66.04" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$4" class="0">
<segment>
<pinref part="JP1" gate="A" pin="3"/>
<wire x1="40.64" y1="68.58" x2="22.86" y2="68.58" width="0.1524" layer="91"/>
<wire x1="22.86" y1="68.58" x2="20.32" y2="66.04" width="0.1524" layer="91"/>
<wire x1="20.32" y1="66.04" x2="20.32" y2="63.5" width="0.1524" layer="91"/>
<pinref part="U1" gate="U" pin="GP2"/>
<wire x1="20.32" y1="63.5" x2="12.7" y2="63.5" width="0.1524" layer="91"/>
</segment>
</net>
</nets>
</sheet>
</sheets>
</schematic>
</drawing>
<compatibility>
<note version="8.2" severity="warning">
Since Version 8.2, EAGLE supports online libraries. The ids
of those online libraries will not be understood (or retained)
with this version.
</note>
<note version="8.3" severity="warning">
Since Version 8.3, EAGLE supports URNs for individual library
assets (packages, symbols, and devices). The URNs of those assets
will not be understood (or retained) with this version.
</note>
<note version="8.3" severity="warning">
Since Version 8.3, EAGLE supports the association of 3D packages
with devices in libraries, schematics, and board files. Those 3D
packages will not be understood (or retained) with this version.
</note>
</compatibility>
</eagle>

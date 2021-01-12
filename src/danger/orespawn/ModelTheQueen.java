/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ModelTheQueen
/*      */   extends ModelBase
/*      */ {
/*   13 */   private float wingspeed = 1.0F;
/*      */   
/*      */   ModelRenderer LCClaw1;
/*      */   
/*      */   ModelRenderer LThigh;
/*      */   
/*      */   ModelRenderer LUpperLeg;
/*      */   ModelRenderer TailTip;
/*      */   ModelRenderer Tail1;
/*      */   ModelRenderer Tail2;
/*      */   ModelRenderer Tail3;
/*      */   ModelRenderer Tail4;
/*      */   ModelRenderer Tail5;
/*      */   ModelRenderer Tail6;
/*      */   ModelRenderer Tail7;
/*      */   ModelRenderer Body1;
/*      */   ModelRenderer NeckC1;
/*      */   ModelRenderer LLowerLeg;
/*      */   ModelRenderer LFoot;
/*      */   ModelRenderer LLClaw1;
/*      */   ModelRenderer LRClaw1;
/*      */   ModelRenderer LCClaw2;
/*      */   ModelRenderer LLClaw2;
/*      */   ModelRenderer TailSpike;
/*      */   ModelRenderer LRClaw2;
/*      */   ModelRenderer LClawRear;
/*      */   ModelRenderer NeckL1;
/*      */   ModelRenderer NeckR1;
/*      */   ModelRenderer RThigh;
/*      */   ModelRenderer RUpperLeg;
/*      */   ModelRenderer RLowerLeg;
/*      */   ModelRenderer RFoot;
/*      */   ModelRenderer RClawRear;
/*      */   ModelRenderer RLClaw1;
/*      */   ModelRenderer RCClaw1;
/*      */   ModelRenderer RRClaw1;
/*      */   ModelRenderer RLClaw2;
/*      */   ModelRenderer RCClaw2;
/*      */   ModelRenderer RRClaw2;
/*      */   ModelRenderer NeckL2;
/*      */   ModelRenderer NeckC2;
/*      */   ModelRenderer NeckR2;
/*      */   ModelRenderer NeckL3;
/*      */   ModelRenderer NeckC3;
/*      */   ModelRenderer NeckR3;
/*      */   ModelRenderer NeckL4;
/*      */   ModelRenderer LHead1;
/*      */   ModelRenderer LHead2;
/*      */   ModelRenderer LHead3;
/*      */   ModelRenderer LJaw1;
/*      */   ModelRenderer LJaw2;
/*      */   ModelRenderer LJaw3;
/*      */   ModelRenderer LTooth1;
/*      */   ModelRenderer LTooth2;
/*      */   ModelRenderer LTooth3;
/*      */   ModelRenderer LTooth4;
/*      */   ModelRenderer NeckC4;
/*      */   ModelRenderer NeckR4;
/*      */   ModelRenderer CHead1;
/*      */   ModelRenderer RHead1;
/*      */   ModelRenderer CHead2;
/*      */   ModelRenderer RHead2;
/*      */   ModelRenderer CHead3;
/*      */   ModelRenderer RHead3;
/*      */   ModelRenderer CJaw1;
/*      */   ModelRenderer CJaw2;
/*      */   ModelRenderer CJaw3;
/*      */   ModelRenderer RJaw1;
/*      */   ModelRenderer RJaw2;
/*      */   ModelRenderer RJaw3;
/*      */   ModelRenderer CTooth3;
/*      */   ModelRenderer CTooth4;
/*      */   ModelRenderer CTooth1;
/*      */   ModelRenderer CTooth2;
/*      */   ModelRenderer RTooth3;
/*      */   ModelRenderer RTooth4;
/*      */   ModelRenderer RTooth1;
/*      */   ModelRenderer RTooth2;
/*      */   ModelRenderer LLEye;
/*      */   ModelRenderer LREye;
/*      */   ModelRenderer CLEye;
/*      */   ModelRenderer CREye;
/*      */   ModelRenderer RLEye;
/*      */   ModelRenderer RREye;
/*      */   ModelRenderer LHeadMane;
/*      */   ModelRenderer CHeadMane;
/*      */   ModelRenderer RHeadMane;
/*      */   ModelRenderer LLNoseSpike;
/*      */   ModelRenderer LRNoseSpike;
/*      */   ModelRenderer CLNoseSpike;
/*      */   ModelRenderer CRNoseSpike;
/*      */   ModelRenderer RLNoseSpike;
/*      */   ModelRenderer RRNoseSpike;
/*      */   ModelRenderer Back1;
/*      */   ModelRenderer Back2;
/*      */   ModelRenderer Lwing1;
/*      */   ModelRenderer Lwing2;
/*      */   ModelRenderer Lwing3;
/*      */   ModelRenderer Lwing4;
/*      */   ModelRenderer Lwing5;
/*      */   ModelRenderer Lwing6;
/*      */   ModelRenderer Lwing7;
/*      */   ModelRenderer Lwing9;
/*      */   ModelRenderer Lwing8;
/*      */   ModelRenderer Lwing10;
/*      */   ModelRenderer Rwing1;
/*      */   ModelRenderer Rwing2;
/*      */   ModelRenderer Rwing3;
/*      */   ModelRenderer Rwing4;
/*      */   ModelRenderer Rwing5;
/*      */   ModelRenderer Rwing6;
/*      */   ModelRenderer Rwing7;
/*      */   ModelRenderer Rwing8;
/*      */   ModelRenderer Rwing9;
/*      */   ModelRenderer Rwing10;
/*      */   ModelRenderer TailTip2;
/*      */   ModelRenderer Ridge1;
/*      */   ModelRenderer Ridge2;
/*      */   ModelRenderer Ridge3;
/*      */   ModelRenderer Ridge4;
/*      */   ModelRenderer Ridge5;
/*      */   ModelRenderer Ridge6;
/*      */   ModelRenderer NeckBone1;
/*      */   ModelRenderer NeckBone2;
/*      */   ModelRenderer NeckBone3;
/*      */   ModelRenderer PowerCube1;
/*      */   ModelRenderer Rib1;
/*      */   ModelRenderer Rib2;
/*      */   ModelRenderer Rib3;
/*      */   ModelRenderer Rib4;
/*      */   ModelRenderer Rib5;
/*      */   ModelRenderer Rib6;
/*      */   ModelRenderer PowerCube2;
/*      */   ModelRenderer PowerCube3;
/*      */   
/*      */   public ModelTheQueen(float f1) {
/*  149 */     this.wingspeed = f1;
/*      */     
/*  151 */     this.textureWidth = 2048;
/*  152 */     this.textureHeight = 2048;
/*      */     
/*  154 */     this.LCClaw1 = new ModelRenderer(this, 0, 1450);
/*  155 */     this.LCClaw1.addBox(-5.0F, -5.0F, -18.0F, 10, 10, 18);
/*  156 */     this.LCClaw1.setRotationPoint(52.0F, -2.0F, -7.0F);
/*  157 */     this.LCClaw1.setTextureSize(2048, 2048);
/*  158 */     this.LCClaw1.mirror = true;
/*  159 */     setRotation(this.LCClaw1, 0.3839724F, 0.0F, 0.0F);
/*  160 */     this.LThigh = new ModelRenderer(this, 0, 1050);
/*  161 */     this.LThigh.addBox(0.0F, -14.0F, -21.0F, 26, 34, 42);
/*  162 */     this.LThigh.setRotationPoint(40.0F, -91.0F, 2.0F);
/*  163 */     this.LThigh.setTextureSize(2048, 2048);
/*  164 */     this.LThigh.mirror = true;
/*  165 */     setRotation(this.LThigh, 0.7853982F, 0.0F, 0.0F);
/*  166 */     this.LUpperLeg = new ModelRenderer(this, 0, 1137);
/*  167 */     this.LUpperLeg.addBox(0.0F, 12.0F, -16.0F, 24, 52, 24);
/*  168 */     this.LUpperLeg.setRotationPoint(40.0F, -91.0F, 2.0F);
/*  169 */     this.LUpperLeg.setTextureSize(2048, 2048);
/*  170 */     this.LUpperLeg.mirror = true;
/*  171 */     setRotation(this.LUpperLeg, 0.7853982F, 0.0F, 0.0F);
/*  172 */     this.TailTip = new ModelRenderer(this, 500, 102);
/*  173 */     this.TailTip.addBox(-54.0F, -3.0F, 0.0F, 106, 6, 36);
/*  174 */     this.TailTip.setRotationPoint(0.0F, -86.0F, 308.0F);
/*  175 */     this.TailTip.setTextureSize(2048, 2048);
/*  176 */     this.TailTip.mirror = true;
/*  177 */     setRotation(this.TailTip, 0.0F, 0.0F, 0.0F);
/*  178 */     this.Tail1 = new ModelRenderer(this, 500, 614);
/*  179 */     this.Tail1.addBox(-32.0F, 0.0F, 0.0F, 64, 50, 58);
/*  180 */     this.Tail1.setRotationPoint(0.0F, -114.0F, 29.0F);
/*  181 */     this.Tail1.setTextureSize(2048, 2048);
/*  182 */     this.Tail1.mirror = true;
/*  183 */     setRotation(this.Tail1, 0.0F, 0.0F, 0.0F);
/*  184 */     this.Tail2 = new ModelRenderer(this, 500, 520);
/*  185 */     this.Tail2.addBox(-25.0F, -19.0F, -3.0F, 50, 42, 46);
/*  186 */     this.Tail2.setRotationPoint(0.0F, -90.0F, 79.0F);
/*  187 */     this.Tail2.setTextureSize(2048, 2048);
/*  188 */     this.Tail2.mirror = true;
/*  189 */     setRotation(this.Tail2, 0.0F, 0.0F, 0.0F);
/*  190 */     this.Tail3 = new ModelRenderer(this, 500, 432);
/*  191 */     this.Tail3.addBox(-20.0F, -18.0F, 0.0F, 40, 36, 45);
/*  192 */     this.Tail3.setRotationPoint(0.0F, -88.0F, 117.0F);
/*  193 */     this.Tail3.setTextureSize(2048, 2048);
/*  194 */     this.Tail3.mirror = true;
/*  195 */     setRotation(this.Tail3, 0.0F, 0.0F, 0.0F);
/*  196 */     this.Tail4 = new ModelRenderer(this, 500, 355);
/*  197 */     this.Tail4.addBox(-16.0F, -15.0F, 0.0F, 32, 30, 38);
/*  198 */     this.Tail4.setRotationPoint(0.0F, -87.0F, 156.0F);
/*  199 */     this.Tail4.setTextureSize(2048, 2048);
/*  200 */     this.Tail4.mirror = true;
/*  201 */     setRotation(this.Tail4, 0.0F, 0.0F, 0.0F);
/*  202 */     this.Tail5 = new ModelRenderer(this, 500, 286);
/*  203 */     this.Tail5.addBox(-13.0F, -12.0F, 0.0F, 26, 24, 38);
/*  204 */     this.Tail5.setRotationPoint(0.0F, -87.0F, 189.0F);
/*  205 */     this.Tail5.setTextureSize(2048, 2048);
/*  206 */     this.Tail5.mirror = true;
/*  207 */     setRotation(this.Tail5, 0.0F, 0.0F, 0.0F);
/*  208 */     this.Tail6 = new ModelRenderer(this, 500, 218);
/*  209 */     this.Tail6.addBox(-10.0F, -9.0F, 0.0F, 20, 18, 44);
/*  210 */     this.Tail6.setRotationPoint(0.0F, -87.0F, 222.0F);
/*  211 */     this.Tail6.setTextureSize(2048, 2048);
/*  212 */     this.Tail6.mirror = true;
/*  213 */     setRotation(this.Tail6, 0.0F, 0.0F, 0.0F);
/*  214 */     this.Tail7 = new ModelRenderer(this, 500, 150);
/*  215 */     this.Tail7.addBox(-8.0F, -6.0F, -7.0F, 16, 12, 49);
/*  216 */     this.Tail7.setRotationPoint(0.0F, -87.0F, 268.0F);
/*  217 */     this.Tail7.setTextureSize(2048, 2048);
/*  218 */     this.Tail7.mirror = true;
/*  219 */     setRotation(this.Tail7, 0.0F, 0.0F, 0.0F);
/*  220 */     this.Body1 = new ModelRenderer(this, 500, 732);
/*  221 */     this.Body1.addBox(-40.0F, -32.0F, -24.0F, 80, 62, 60);
/*  222 */     this.Body1.setRotationPoint(0.0F, -89.0F, 1.0F);
/*  223 */     this.Body1.setTextureSize(2048, 2048);
/*  224 */     this.Body1.mirror = true;
/*  225 */     setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
/*  226 */     this.NeckC1 = new ModelRenderer(this, 700, 1100);
/*  227 */     this.NeckC1.addBox(-12.0F, -12.0F, -24.0F, 24, 24, 24);
/*  228 */     this.NeckC1.setRotationPoint(0.0F, -113.0F, -76.0F);
/*  229 */     this.NeckC1.setTextureSize(2048, 2048);
/*  230 */     this.NeckC1.mirror = true;
/*  231 */     setRotation(this.NeckC1, -0.1047198F, 0.0F, 0.0F);
/*  232 */     this.LLowerLeg = new ModelRenderer(this, 0, 1220);
/*  233 */     this.LLowerLeg.addBox(-10.0F, 0.0F, -10.0F, 20, 59, 20);
/*  234 */     this.LLowerLeg.setRotationPoint(52.0F, -52.0F, 36.0F);
/*  235 */     this.LLowerLeg.setTextureSize(2048, 2048);
/*  236 */     this.LLowerLeg.mirror = true;
/*  237 */     setRotation(this.LLowerLeg, -0.6283185F, 0.0F, 0.0F);
/*  238 */     this.LFoot = new ModelRenderer(this, 0, 1307);
/*  239 */     this.LFoot.addBox(-18.0F, 59.0F, -10.0F, 34, 12, 20);
/*  240 */     this.LFoot.setRotationPoint(53.0F, -52.0F, 36.0F);
/*  241 */     this.LFoot.setTextureSize(2048, 2048);
/*  242 */     this.LFoot.mirror = true;
/*  243 */     setRotation(this.LFoot, -0.6283185F, 0.0F, 0.0F);
/*  244 */     this.LLClaw1 = new ModelRenderer(this, 0, 1400);
/*  245 */     this.LLClaw1.addBox(-5.0F, -5.0F, -18.0F, 10, 10, 18);
/*  246 */     this.LLClaw1.setRotationPoint(66.0F, -2.0F, -7.0F);
/*  247 */     this.LLClaw1.setTextureSize(2048, 2048);
/*  248 */     this.LLClaw1.mirror = true;
/*  249 */     setRotation(this.LLClaw1, 0.3839724F, 0.0F, 0.0F);
/*  250 */     this.LRClaw1 = new ModelRenderer(this, 0, 1500);
/*  251 */     this.LRClaw1.addBox(-5.0F, -5.0F, -18.0F, 10, 10, 18);
/*  252 */     this.LRClaw1.setRotationPoint(38.0F, -2.0F, -7.0F);
/*  253 */     this.LRClaw1.setTextureSize(2048, 2048);
/*  254 */     this.LRClaw1.mirror = true;
/*  255 */     setRotation(this.LRClaw1, 0.3839724F, 0.0F, 0.0F);
/*  256 */     this.LCClaw2 = new ModelRenderer(this, 0, 1600);
/*  257 */     this.LCClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 30);
/*  258 */     this.LCClaw2.setRotationPoint(52.0F, -2.0F, -7.0F);
/*  259 */     this.LCClaw2.setTextureSize(2048, 2048);
/*  260 */     this.LCClaw2.mirror = true;
/*  261 */     setRotation(this.LCClaw2, 0.6457718F, 0.0F, 0.0F);
/*  262 */     this.LLClaw2 = new ModelRenderer(this, 0, 1550);
/*  263 */     this.LLClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 30);
/*  264 */     this.LLClaw2.setRotationPoint(66.0F, -2.0F, -7.0F);
/*  265 */     this.LLClaw2.setTextureSize(2048, 2048);
/*  266 */     this.LLClaw2.mirror = true;
/*  267 */     setRotation(this.LLClaw2, 0.6457718F, 0.0F, 0.0F);
/*  268 */     this.TailSpike = new ModelRenderer(this, 800, 0);
/*  269 */     this.TailSpike.addBox(-2.0F, -1.0F, -7.0F, 4, 4, 82);
/*  270 */     this.TailSpike.setRotationPoint(0.0F, -87.0F, 375.0F);
/*  271 */     this.TailSpike.setTextureSize(2048, 2048);
/*  272 */     this.TailSpike.mirror = true;
/*  273 */     setRotation(this.TailSpike, 0.0F, 0.0F, 0.0F);
/*  274 */     this.LRClaw2 = new ModelRenderer(this, 0, 1650);
/*  275 */     this.LRClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 30);
/*  276 */     this.LRClaw2.setRotationPoint(38.0F, -2.0F, -7.0F);
/*  277 */     this.LRClaw2.setTextureSize(2048, 2048);
/*  278 */     this.LRClaw2.mirror = true;
/*  279 */     setRotation(this.LRClaw2, 0.6457718F, 0.0F, 0.0F);
/*  280 */     this.LClawRear = new ModelRenderer(this, 0, 1350);
/*  281 */     this.LClawRear.addBox(-2.0F, -3.0F, 0.0F, 4, 9, 30);
/*  282 */     this.LClawRear.setRotationPoint(52.0F, 4.0F, 4.0F);
/*  283 */     this.LClawRear.setTextureSize(2048, 2048);
/*  284 */     this.LClawRear.mirror = true;
/*  285 */     setRotation(this.LClawRear, -0.9250245F, 0.0F, 0.0F);
/*  286 */     this.NeckL1 = new ModelRenderer(this, 500, 1100);
/*  287 */     this.NeckL1.addBox(-12.0F, -12.0F, -24.0F, 24, 24, 24);
/*  288 */     this.NeckL1.setRotationPoint(30.0F, -113.0F, -76.0F);
/*  289 */     this.NeckL1.setTextureSize(2048, 2048);
/*  290 */     this.NeckL1.mirror = true;
/*  291 */     setRotation(this.NeckL1, -0.0523599F, -0.1047198F, 0.0F);
/*  292 */     this.NeckR1 = new ModelRenderer(this, 900, 1100);
/*  293 */     this.NeckR1.addBox(-12.0F, -12.0F, -24.0F, 24, 24, 24);
/*  294 */     this.NeckR1.setRotationPoint(-30.0F, -113.0F, -76.0F);
/*  295 */     this.NeckR1.setTextureSize(2048, 2048);
/*  296 */     this.NeckR1.mirror = true;
/*  297 */     setRotation(this.NeckR1, -0.0523599F, 0.1047198F, 0.0F);
/*  298 */     this.RThigh = new ModelRenderer(this, 200, 1050);
/*  299 */     this.RThigh.addBox(0.0F, -14.0F, -21.0F, 26, 34, 42);
/*  300 */     this.RThigh.setRotationPoint(-66.0F, -91.0F, 2.0F);
/*  301 */     this.RThigh.setTextureSize(2048, 2048);
/*  302 */     this.RThigh.mirror = true;
/*  303 */     setRotation(this.RThigh, 0.7853982F, 0.0F, 0.0F);
/*  304 */     this.RUpperLeg = new ModelRenderer(this, 200, 1137);
/*  305 */     this.RUpperLeg.addBox(0.0F, 12.0F, -16.0F, 24, 52, 24);
/*  306 */     this.RUpperLeg.setRotationPoint(-64.0F, -91.0F, 2.0F);
/*  307 */     this.RUpperLeg.setTextureSize(2048, 2048);
/*  308 */     this.RUpperLeg.mirror = true;
/*  309 */     setRotation(this.RUpperLeg, 0.7853982F, 0.0F, 0.0F);
/*  310 */     this.RLowerLeg = new ModelRenderer(this, 200, 1220);
/*  311 */     this.RLowerLeg.addBox(-3.0F, 0.0F, -10.0F, 20, 59, 20);
/*  312 */     this.RLowerLeg.setRotationPoint(-59.0F, -52.0F, 36.0F);
/*  313 */     this.RLowerLeg.setTextureSize(2048, 2048);
/*  314 */     this.RLowerLeg.mirror = true;
/*  315 */     setRotation(this.RLowerLeg, -0.6283185F, 0.0F, 0.0F);
/*  316 */     this.RFoot = new ModelRenderer(this, 200, 1307);
/*  317 */     this.RFoot.addBox(-10.0F, 59.0F, -10.0F, 34, 12, 20);
/*  318 */     this.RFoot.setRotationPoint(-59.0F, -52.0F, 36.0F);
/*  319 */     this.RFoot.setTextureSize(2048, 2048);
/*  320 */     this.RFoot.mirror = true;
/*  321 */     setRotation(this.RFoot, -0.6283185F, 0.0F, 0.0F);
/*  322 */     this.RClawRear = new ModelRenderer(this, 200, 1350);
/*  323 */     this.RClawRear.addBox(-2.0F, -3.0F, 0.0F, 4, 9, 30);
/*  324 */     this.RClawRear.setRotationPoint(-52.0F, 4.0F, 4.0F);
/*  325 */     this.RClawRear.setTextureSize(2048, 2048);
/*  326 */     this.RClawRear.mirror = true;
/*  327 */     setRotation(this.RClawRear, -0.9250245F, 0.0F, 0.0F);
/*  328 */     this.RLClaw1 = new ModelRenderer(this, 200, 1400);
/*  329 */     this.RLClaw1.addBox(-5.0F, -5.0F, -18.0F, 10, 10, 18);
/*  330 */     this.RLClaw1.setRotationPoint(-38.0F, -2.0F, -7.0F);
/*  331 */     this.RLClaw1.setTextureSize(2048, 2048);
/*  332 */     this.RLClaw1.mirror = true;
/*  333 */     setRotation(this.RLClaw1, 0.3839724F, 0.0F, 0.0F);
/*  334 */     this.RCClaw1 = new ModelRenderer(this, 200, 1450);
/*  335 */     this.RCClaw1.addBox(-5.0F, -5.0F, -18.0F, 10, 10, 18);
/*  336 */     this.RCClaw1.setRotationPoint(-52.0F, -2.0F, -7.0F);
/*  337 */     this.RCClaw1.setTextureSize(2048, 2048);
/*  338 */     this.RCClaw1.mirror = true;
/*  339 */     setRotation(this.RCClaw1, 0.3839724F, 0.0F, 0.0F);
/*  340 */     this.RRClaw1 = new ModelRenderer(this, 200, 1500);
/*  341 */     this.RRClaw1.addBox(-5.0F, -5.0F, -18.0F, 10, 10, 18);
/*  342 */     this.RRClaw1.setRotationPoint(-66.0F, -2.0F, -7.0F);
/*  343 */     this.RRClaw1.setTextureSize(2048, 2048);
/*  344 */     this.RRClaw1.mirror = true;
/*  345 */     setRotation(this.RRClaw1, 0.3839724F, 0.0F, 0.0F);
/*  346 */     this.RLClaw2 = new ModelRenderer(this, 200, 1550);
/*  347 */     this.RLClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 30);
/*  348 */     this.RLClaw2.setRotationPoint(-38.0F, -2.0F, -7.0F);
/*  349 */     this.RLClaw2.setTextureSize(2048, 2048);
/*  350 */     this.RLClaw2.mirror = true;
/*  351 */     setRotation(this.RLClaw2, 0.6457718F, 0.0F, 0.0F);
/*  352 */     this.RCClaw2 = new ModelRenderer(this, 200, 1600);
/*  353 */     this.RCClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 30);
/*  354 */     this.RCClaw2.setRotationPoint(-52.0F, -2.0F, -7.0F);
/*  355 */     this.RCClaw2.setTextureSize(2048, 2048);
/*  356 */     this.RCClaw2.mirror = true;
/*  357 */     setRotation(this.RCClaw2, 0.6457718F, 0.0F, 0.0F);
/*  358 */     this.RRClaw2 = new ModelRenderer(this, 200, 1650);
/*  359 */     this.RRClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 30);
/*  360 */     this.RRClaw2.setRotationPoint(-66.0F, -2.0F, -7.0F);
/*  361 */     this.RRClaw2.setTextureSize(2048, 2048);
/*  362 */     this.RRClaw2.mirror = true;
/*  363 */     setRotation(this.RRClaw2, 0.6457718F, 0.0F, 0.0F);
/*  364 */     this.NeckL2 = new ModelRenderer(this, 500, 1154);
/*  365 */     this.NeckL2.addBox(-11.0F, -11.0F, -40.0F, 22, 22, 40);
/*  366 */     this.NeckL2.setRotationPoint(32.0F, -114.0F, -95.0F);
/*  367 */     this.NeckL2.setTextureSize(2048, 2048);
/*  368 */     this.NeckL2.mirror = true;
/*  369 */     setRotation(this.NeckL2, 0.0F, -0.1745329F, 0.0F);
/*  370 */     this.NeckC2 = new ModelRenderer(this, 700, 1154);
/*  371 */     this.NeckC2.addBox(-11.0F, -11.0F, -40.0F, 22, 22, 40);
/*  372 */     this.NeckC2.setRotationPoint(0.0F, -115.0F, -95.0F);
/*  373 */     this.NeckC2.setTextureSize(2048, 2048);
/*  374 */     this.NeckC2.mirror = true;
/*  375 */     setRotation(this.NeckC2, -0.1570796F, 0.0F, 0.0F);
/*  376 */     this.NeckR2 = new ModelRenderer(this, 900, 1154);
/*  377 */     this.NeckR2.addBox(-11.0F, -11.0F, -40.0F, 22, 22, 40);
/*  378 */     this.NeckR2.setRotationPoint(-32.0F, -114.0F, -95.0F);
/*  379 */     this.NeckR2.setTextureSize(2048, 2048);
/*  380 */     this.NeckR2.mirror = true;
/*  381 */     setRotation(this.NeckR2, -0.0523599F, 0.1745329F, 0.0F);
/*  382 */     this.NeckL3 = new ModelRenderer(this, 500, 1222);
/*  383 */     this.NeckL3.addBox(-10.0F, -10.0F, -40.0F, 20, 20, 40);
/*  384 */     this.NeckL3.setRotationPoint(38.0F, -114.0F, -131.0F);
/*  385 */     this.NeckL3.setTextureSize(2048, 2048);
/*  386 */     this.NeckL3.mirror = true;
/*  387 */     setRotation(this.NeckL3, 0.0698132F, -0.2617994F, 0.0F);
/*  388 */     this.NeckC3 = new ModelRenderer(this, 700, 1222);
/*  389 */     this.NeckC3.addBox(-10.0F, -10.0F, -40.0F, 20, 20, 40);
/*  390 */     this.NeckC3.setRotationPoint(0.0F, -120.0F, -131.0F);
/*  391 */     this.NeckC3.setTextureSize(2048, 2048);
/*  392 */     this.NeckC3.mirror = true;
/*  393 */     setRotation(this.NeckC3, -0.2094395F, 0.0F, 0.0F);
/*  394 */     this.NeckR3 = new ModelRenderer(this, 900, 1222);
/*  395 */     this.NeckR3.addBox(-10.0F, -10.0F, -40.0F, 20, 20, 40);
/*  396 */     this.NeckR3.setRotationPoint(-37.0F, -116.0F, -128.0F);
/*  397 */     this.NeckR3.setTextureSize(2048, 2048);
/*  398 */     this.NeckR3.mirror = true;
/*  399 */     setRotation(this.NeckR3, -0.0523599F, 0.3141593F, 0.0F);
/*  400 */     this.NeckL4 = new ModelRenderer(this, 500, 1300);
/*  401 */     this.NeckL4.addBox(-9.0F, -9.0F, -40.0F, 18, 18, 40);
/*  402 */     this.NeckL4.setRotationPoint(46.0F, -112.0F, -163.0F);
/*  403 */     this.NeckL4.setTextureSize(2048, 2048);
/*  404 */     this.NeckL4.mirror = true;
/*  405 */     setRotation(this.NeckL4, 0.1396263F, -0.3839724F, 0.0F);
/*  406 */     this.LHead1 = new ModelRenderer(this, 500, 1425);
/*  407 */     this.LHead1.addBox(-13.0F, -13.0F, -30.0F, 26, 26, 30);
/*  408 */     this.LHead1.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  409 */     this.LHead1.setTextureSize(2048, 2048);
/*  410 */     this.LHead1.mirror = true;
/*  411 */     setRotation(this.LHead1, 0.1396263F, -0.3839724F, 0.0F);
/*  412 */     this.LHead2 = new ModelRenderer(this, 500, 1550);
/*  413 */     this.LHead2.addBox(-10.0F, -7.0F, -58.0F, 20, 20, 28);
/*  414 */     this.LHead2.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  415 */     this.LHead2.setTextureSize(2048, 2048);
/*  416 */     this.LHead2.mirror = true;
/*  417 */     setRotation(this.LHead2, 0.1396263F, -0.3839724F, 0.0F);
/*  418 */     this.LHead3 = new ModelRenderer(this, 500, 1605);
/*  419 */     this.LHead3.addBox(-8.0F, -3.0F, -83.0F, 16, 16, 26);
/*  420 */     this.LHead3.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  421 */     this.LHead3.setTextureSize(2048, 2048);
/*  422 */     this.LHead3.mirror = true;
/*  423 */     setRotation(this.LHead3, 0.1396263F, -0.3839724F, 0.0F);
/*  424 */     this.LJaw1 = new ModelRenderer(this, 500, 1660);
/*  425 */     this.LJaw1.addBox(-14.0F, -2.0F, -14.0F, 28, 7, 16);
/*  426 */     this.LJaw1.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  427 */     this.LJaw1.setTextureSize(2048, 2048);
/*  428 */     this.LJaw1.mirror = true;
/*  429 */     setRotation(this.LJaw1, 0.2443461F, -0.3839724F, 0.0F);
/*  430 */     this.LJaw2 = new ModelRenderer(this, 500, 1700);
/*  431 */     this.LJaw2.addBox(-12.0F, -2.0F, -55.0F, 24, 6, 46);
/*  432 */     this.LJaw2.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  433 */     this.LJaw2.setTextureSize(2048, 2048);
/*  434 */     this.LJaw2.mirror = true;
/*  435 */     setRotation(this.LJaw2, 0.2443461F, -0.3839724F, 0.0F);
/*  436 */     this.LJaw3 = new ModelRenderer(this, 500, 1765);
/*  437 */     this.LJaw3.addBox(-10.0F, -2.0F, -77.0F, 20, 6, 22);
/*  438 */     this.LJaw3.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  439 */     this.LJaw3.setTextureSize(2048, 2048);
/*  440 */     this.LJaw3.mirror = true;
/*  441 */     setRotation(this.LJaw3, 0.2443461F, -0.3839724F, 0.0F);
/*  442 */     this.LTooth1 = new ModelRenderer(this, 10, 0);
/*  443 */     this.LTooth1.addBox(-10.0F, -10.0F, -77.0F, 2, 8, 2);
/*  444 */     this.LTooth1.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  445 */     this.LTooth1.setTextureSize(2048, 2048);
/*  446 */     this.LTooth1.mirror = true;
/*  447 */     setRotation(this.LTooth1, 0.2443461F, -0.3839724F, 0.0F);
/*  448 */     this.LTooth2 = new ModelRenderer(this, 20, 0);
/*  449 */     this.LTooth2.addBox(8.0F, -10.0F, -77.0F, 2, 8, 2);
/*  450 */     this.LTooth2.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  451 */     this.LTooth2.setTextureSize(2048, 2048);
/*  452 */     this.LTooth2.mirror = true;
/*  453 */     setRotation(this.LTooth2, 0.2443461F, -0.3839724F, 0.0F);
/*  454 */     this.LTooth3 = new ModelRenderer(this, 30, 0);
/*  455 */     this.LTooth3.addBox(-12.0F, -8.0F, -55.0F, 2, 6, 2);
/*  456 */     this.LTooth3.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  457 */     this.LTooth3.setTextureSize(2048, 2048);
/*  458 */     this.LTooth3.mirror = true;
/*  459 */     setRotation(this.LTooth3, 0.2443461F, -0.3839724F, 0.0F);
/*  460 */     this.LTooth4 = new ModelRenderer(this, 40, 0);
/*  461 */     this.LTooth4.addBox(10.0F, -8.0F, -55.0F, 2, 6, 2);
/*  462 */     this.LTooth4.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  463 */     this.LTooth4.setTextureSize(2048, 2048);
/*  464 */     this.LTooth4.mirror = true;
/*  465 */     setRotation(this.LTooth4, 0.2443461F, -0.3839724F, 0.0F);
/*  466 */     this.NeckC4 = new ModelRenderer(this, 700, 1300);
/*  467 */     this.NeckC4.addBox(-9.0F, -9.0F, -40.0F, 18, 18, 40);
/*  468 */     this.NeckC4.setRotationPoint(0.0F, -126.0F, -162.0F);
/*  469 */     this.NeckC4.setTextureSize(2048, 2048);
/*  470 */     this.NeckC4.mirror = true;
/*  471 */     setRotation(this.NeckC4, -0.2617994F, 0.0F, 0.0F);
/*  472 */     this.NeckR4 = new ModelRenderer(this, 900, 1300);
/*  473 */     this.NeckR4.addBox(-9.0F, -9.0F, -40.0F, 18, 18, 40);
/*  474 */     this.NeckR4.setRotationPoint(-47.0F, -118.0F, -161.0F);
/*  475 */     this.NeckR4.setTextureSize(2048, 2048);
/*  476 */     this.NeckR4.mirror = true;
/*  477 */     setRotation(this.NeckR4, -0.1047198F, 0.3665191F, 0.0F);
/*  478 */     this.CHead1 = new ModelRenderer(this, 700, 1425);
/*  479 */     this.CHead1.addBox(-13.0F, -13.0F, -30.0F, 26, 26, 30);
/*  480 */     this.CHead1.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  481 */     this.CHead1.setTextureSize(2048, 2048);
/*  482 */     this.CHead1.mirror = true;
/*  483 */     setRotation(this.CHead1, -0.296706F, 0.0F, 0.0F);
/*  484 */     this.RHead1 = new ModelRenderer(this, 900, 1425);
/*  485 */     this.RHead1.addBox(-13.0F, -13.0F, -30.0F, 26, 26, 30);
/*  486 */     this.RHead1.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  487 */     this.RHead1.setTextureSize(2048, 2048);
/*  488 */     this.RHead1.mirror = true;
/*  489 */     setRotation(this.RHead1, -0.122173F, 0.418879F, 0.0F);
/*  490 */     this.CHead2 = new ModelRenderer(this, 700, 1550);
/*  491 */     this.CHead2.addBox(-10.0F, -7.0F, -58.0F, 20, 20, 28);
/*  492 */     this.CHead2.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  493 */     this.CHead2.setTextureSize(2048, 2048);
/*  494 */     this.CHead2.mirror = true;
/*  495 */     setRotation(this.CHead2, -0.296706F, 0.0F, 0.0F);
/*  496 */     this.RHead2 = new ModelRenderer(this, 900, 1550);
/*  497 */     this.RHead2.addBox(-10.0F, -7.0F, -58.0F, 20, 20, 28);
/*  498 */     this.RHead2.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  499 */     this.RHead2.setTextureSize(2048, 2048);
/*  500 */     this.RHead2.mirror = true;
/*  501 */     setRotation(this.RHead2, -0.122173F, 0.418879F, 0.0F);
/*  502 */     this.CHead3 = new ModelRenderer(this, 700, 1605);
/*  503 */     this.CHead3.addBox(-8.0F, -3.0F, -83.0F, 16, 16, 26);
/*  504 */     this.CHead3.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  505 */     this.CHead3.setTextureSize(2048, 2048);
/*  506 */     this.CHead3.mirror = true;
/*  507 */     setRotation(this.CHead3, -0.296706F, 0.0F, 0.0F);
/*  508 */     this.RHead3 = new ModelRenderer(this, 900, 1605);
/*  509 */     this.RHead3.addBox(-8.0F, -3.0F, -83.0F, 16, 16, 26);
/*  510 */     this.RHead3.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  511 */     this.RHead3.setTextureSize(2048, 2048);
/*  512 */     this.RHead3.mirror = true;
/*  513 */     setRotation(this.RHead3, -0.122173F, 0.418879F, 0.0F);
/*  514 */     this.CJaw1 = new ModelRenderer(this, 700, 1660);
/*  515 */     this.CJaw1.addBox(-14.0F, -2.0F, -14.0F, 28, 7, 16);
/*  516 */     this.CJaw1.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  517 */     this.CJaw1.setTextureSize(2048, 2048);
/*  518 */     this.CJaw1.mirror = true;
/*  519 */     setRotation(this.CJaw1, -0.1047198F, 0.0F, 0.0F);
/*  520 */     this.CJaw2 = new ModelRenderer(this, 700, 1700);
/*  521 */     this.CJaw2.addBox(-12.0F, -2.0F, -55.0F, 24, 6, 46);
/*  522 */     this.CJaw2.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  523 */     this.CJaw2.setTextureSize(2048, 2048);
/*  524 */     this.CJaw2.mirror = true;
/*  525 */     setRotation(this.CJaw2, -0.1047198F, 0.0F, 0.0F);
/*  526 */     this.CJaw3 = new ModelRenderer(this, 700, 1765);
/*  527 */     this.CJaw3.addBox(-10.0F, -2.0F, -77.0F, 20, 6, 22);
/*  528 */     this.CJaw3.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  529 */     this.CJaw3.setTextureSize(2048, 2048);
/*  530 */     this.CJaw3.mirror = true;
/*  531 */     setRotation(this.CJaw3, -0.1047198F, 0.0F, 0.0F);
/*  532 */     this.RJaw1 = new ModelRenderer(this, 900, 1660);
/*  533 */     this.RJaw1.addBox(-14.0F, -2.0F, -14.0F, 28, 7, 16);
/*  534 */     this.RJaw1.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  535 */     this.RJaw1.setTextureSize(2048, 2048);
/*  536 */     this.RJaw1.mirror = true;
/*  537 */     setRotation(this.RJaw1, 0.1570796F, 0.418879F, 0.0F);
/*  538 */     this.RJaw2 = new ModelRenderer(this, 900, 1700);
/*  539 */     this.RJaw2.addBox(-12.0F, -2.0F, -55.0F, 24, 6, 46);
/*  540 */     this.RJaw2.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  541 */     this.RJaw2.setTextureSize(2048, 2048);
/*  542 */     this.RJaw2.mirror = true;
/*  543 */     setRotation(this.RJaw2, 0.1570796F, 0.418879F, 0.0F);
/*  544 */     this.RJaw3 = new ModelRenderer(this, 900, 1765);
/*  545 */     this.RJaw3.addBox(-10.0F, -2.0F, -77.0F, 20, 6, 22);
/*  546 */     this.RJaw3.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  547 */     this.RJaw3.setTextureSize(2048, 2048);
/*  548 */     this.RJaw3.mirror = true;
/*  549 */     setRotation(this.RJaw3, 0.1570796F, 0.418879F, 0.0F);
/*  550 */     this.CTooth3 = new ModelRenderer(this, 70, 0);
/*  551 */     this.CTooth3.addBox(-12.0F, -8.0F, -55.0F, 2, 6, 2);
/*  552 */     this.CTooth3.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  553 */     this.CTooth3.setTextureSize(2048, 2048);
/*  554 */     this.CTooth3.mirror = true;
/*  555 */     setRotation(this.CTooth3, -0.1047198F, 0.0F, 0.0F);
/*  556 */     this.CTooth4 = new ModelRenderer(this, 80, 0);
/*  557 */     this.CTooth4.addBox(10.0F, -8.0F, -55.0F, 2, 6, 2);
/*  558 */     this.CTooth4.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  559 */     this.CTooth4.setTextureSize(2048, 2048);
/*  560 */     this.CTooth4.mirror = true;
/*  561 */     setRotation(this.CTooth4, -0.1047198F, 0.0F, 0.0F);
/*  562 */     this.CTooth1 = new ModelRenderer(this, 50, 0);
/*  563 */     this.CTooth1.addBox(-10.0F, -10.0F, -77.0F, 2, 8, 2);
/*  564 */     this.CTooth1.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  565 */     this.CTooth1.setTextureSize(2048, 2048);
/*  566 */     this.CTooth1.mirror = true;
/*  567 */     setRotation(this.CTooth1, -0.1047198F, 0.0F, 0.0F);
/*  568 */     this.CTooth2 = new ModelRenderer(this, 60, 0);
/*  569 */     this.CTooth2.addBox(8.0F, -10.0F, -77.0F, 2, 8, 2);
/*  570 */     this.CTooth2.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  571 */     this.CTooth2.setTextureSize(2048, 2048);
/*  572 */     this.CTooth2.mirror = true;
/*  573 */     setRotation(this.CTooth2, -0.1047198F, 0.0F, 0.0F);
/*  574 */     this.RTooth3 = new ModelRenderer(this, 110, 0);
/*  575 */     this.RTooth3.addBox(-12.0F, -8.0F, -55.0F, 2, 6, 2);
/*  576 */     this.RTooth3.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  577 */     this.RTooth3.setTextureSize(2048, 2048);
/*  578 */     this.RTooth3.mirror = true;
/*  579 */     setRotation(this.RTooth3, 0.1570796F, 0.418879F, 0.0F);
/*  580 */     this.RTooth4 = new ModelRenderer(this, 120, 0);
/*  581 */     this.RTooth4.addBox(10.0F, -8.0F, -55.0F, 2, 6, 2);
/*  582 */     this.RTooth4.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  583 */     this.RTooth4.setTextureSize(2048, 2048);
/*  584 */     this.RTooth4.mirror = true;
/*  585 */     setRotation(this.RTooth4, 0.1570796F, 0.418879F, 0.0F);
/*  586 */     this.RTooth1 = new ModelRenderer(this, 90, 0);
/*  587 */     this.RTooth1.addBox(-10.0F, -10.0F, -77.0F, 2, 8, 2);
/*  588 */     this.RTooth1.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  589 */     this.RTooth1.setTextureSize(2048, 2048);
/*  590 */     this.RTooth1.mirror = true;
/*  591 */     setRotation(this.RTooth1, 0.1570796F, 0.418879F, 0.0F);
/*  592 */     this.RTooth2 = new ModelRenderer(this, 100, 0);
/*  593 */     this.RTooth2.addBox(8.0F, -10.0F, -77.0F, 2, 8, 2);
/*  594 */     this.RTooth2.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  595 */     this.RTooth2.setTextureSize(2048, 2048);
/*  596 */     this.RTooth2.mirror = true;
/*  597 */     setRotation(this.RTooth2, 0.1570796F, 0.418879F, 0.0F);
/*  598 */     this.LLEye = new ModelRenderer(this, 500, 1500);
/*  599 */     this.LLEye.addBox(13.0F, -12.0F, -29.0F, 2, 6, 11);
/*  600 */     this.LLEye.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  601 */     this.LLEye.setTextureSize(2048, 2048);
/*  602 */     this.LLEye.mirror = true;
/*  603 */     setRotation(this.LLEye, 0.1396263F, -0.3839724F, 0.0F);
/*  604 */     this.LREye = new ModelRenderer(this, 533, 1500);
/*  605 */     this.LREye.addBox(-15.0F, -12.0F, -29.0F, 2, 6, 11);
/*  606 */     this.LREye.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  607 */     this.LREye.setTextureSize(2048, 2048);
/*  608 */     this.LREye.mirror = true;
/*  609 */     setRotation(this.LREye, 0.1396263F, -0.3839724F, 0.0F);
/*  610 */     this.CLEye = new ModelRenderer(this, 700, 1500);
/*  611 */     this.CLEye.addBox(13.0F, -12.0F, -29.0F, 2, 6, 11);
/*  612 */     this.CLEye.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  613 */     this.CLEye.setTextureSize(2048, 2048);
/*  614 */     this.CLEye.mirror = true;
/*  615 */     setRotation(this.CLEye, -0.296706F, 0.0F, 0.0F);
/*  616 */     this.CREye = new ModelRenderer(this, 733, 1500);
/*  617 */     this.CREye.addBox(-15.0F, -12.0F, -29.0F, 2, 6, 11);
/*  618 */     this.CREye.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  619 */     this.CREye.setTextureSize(2048, 2048);
/*  620 */     this.CREye.mirror = true;
/*  621 */     setRotation(this.CREye, -0.296706F, 0.0F, 0.0F);
/*  622 */     this.RLEye = new ModelRenderer(this, 900, 1500);
/*  623 */     this.RLEye.addBox(13.0F, -12.0F, -29.0F, 2, 6, 11);
/*  624 */     this.RLEye.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  625 */     this.RLEye.setTextureSize(2048, 2048);
/*  626 */     this.RLEye.mirror = true;
/*  627 */     setRotation(this.RLEye, -0.122173F, 0.418879F, 0.0F);
/*  628 */     this.RREye = new ModelRenderer(this, 933, 1500);
/*  629 */     this.RREye.addBox(-15.0F, -12.0F, -29.0F, 2, 5, 11);
/*  630 */     this.RREye.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  631 */     this.RREye.setTextureSize(2048, 2048);
/*  632 */     this.RREye.mirror = true;
/*  633 */     setRotation(this.RREye, -0.122173F, 0.418879F, 0.0F);
/*  634 */     this.LHeadMane = new ModelRenderer(this, 500, 1375);
/*  635 */     this.LHeadMane.addBox(0.0F, -14.0F, 0.0F, 1, 23, 19);
/*  636 */     this.LHeadMane.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  637 */     this.LHeadMane.setTextureSize(2048, 2048);
/*  638 */     this.LHeadMane.mirror = true;
/*  639 */     setRotation(this.LHeadMane, 0.5235988F, -0.3839724F, 0.0F);
/*  640 */     this.CHeadMane = new ModelRenderer(this, 700, 1375);
/*  641 */     this.CHeadMane.addBox(0.0F, -14.0F, 0.0F, 1, 23, 19);
/*  642 */     this.CHeadMane.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  643 */     this.CHeadMane.setTextureSize(2048, 2048);
/*  644 */     this.CHeadMane.mirror = true;
/*  645 */     setRotation(this.CHeadMane, 0.1047198F, 0.0F, 0.0F);
/*  646 */     this.RHeadMane = new ModelRenderer(this, 900, 1375);
/*  647 */     this.RHeadMane.addBox(0.0F, -14.0F, 0.0F, 1, 23, 19);
/*  648 */     this.RHeadMane.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  649 */     this.RHeadMane.setTextureSize(2048, 2048);
/*  650 */     this.RHeadMane.mirror = true;
/*  651 */     setRotation(this.RHeadMane, 0.3665191F, 0.418879F, 0.0F);
/*  652 */     this.LLNoseSpike = new ModelRenderer(this, 0, 300);
/*  653 */     this.LLNoseSpike.addBox(24.0F, -23.0F, -76.0F, 1, 1, 17);
/*  654 */     this.LLNoseSpike.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  655 */     this.LLNoseSpike.setTextureSize(2048, 2048);
/*  656 */     this.LLNoseSpike.mirror = true;
/*  657 */     setRotation(this.LLNoseSpike, 0.4014257F, -0.1570796F, 0.0F);
/*  658 */     this.LRNoseSpike = new ModelRenderer(this, 0, 325);
/*  659 */     this.LRNoseSpike.addBox(-26.0F, -24.0F, -75.0F, 1, 1, 17);
/*  660 */     this.LRNoseSpike.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  661 */     this.LRNoseSpike.setTextureSize(2048, 2048);
/*  662 */     this.LRNoseSpike.mirror = true;
/*  663 */     setRotation(this.LRNoseSpike, 0.418879F, -0.6283185F, 0.0F);
/*  664 */     this.CLNoseSpike = new ModelRenderer(this, 0, 350);
/*  665 */     this.CLNoseSpike.addBox(24.0F, -23.0F, -76.0F, 1, 1, 17);
/*  666 */     this.CLNoseSpike.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  667 */     this.CLNoseSpike.setTextureSize(2048, 2048);
/*  668 */     this.CLNoseSpike.mirror = true;
/*  669 */     setRotation(this.CLNoseSpike, -0.0523599F, 0.2443461F, 0.0F);
/*  670 */     this.CRNoseSpike = new ModelRenderer(this, 0, 375);
/*  671 */     this.CRNoseSpike.addBox(-26.0F, -24.0F, -75.0F, 1, 1, 17);
/*  672 */     this.CRNoseSpike.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  673 */     this.CRNoseSpike.setTextureSize(2048, 2048);
/*  674 */     this.CRNoseSpike.mirror = true;
/*  675 */     setRotation(this.CRNoseSpike, -0.0349066F, -0.2617994F, 0.0F);
/*  676 */     this.RLNoseSpike = new ModelRenderer(this, 0, 400);
/*  677 */     this.RLNoseSpike.addBox(24.0F, -23.0F, -76.0F, 1, 1, 17);
/*  678 */     this.RLNoseSpike.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  679 */     this.RLNoseSpike.setTextureSize(2048, 2048);
/*  680 */     this.RLNoseSpike.mirror = true;
/*  681 */     setRotation(this.RLNoseSpike, 0.1396263F, 0.6457718F, 0.0F);
/*  682 */     this.RRNoseSpike = new ModelRenderer(this, 0, 425);
/*  683 */     this.RRNoseSpike.addBox(-26.0F, -24.0F, -75.0F, 1, 1, 17);
/*  684 */     this.RRNoseSpike.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  685 */     this.RRNoseSpike.setTextureSize(2048, 2048);
/*  686 */     this.RRNoseSpike.mirror = true;
/*  687 */     setRotation(this.RRNoseSpike, 0.1570796F, 0.1745329F, 0.0F);
/*  688 */     this.Back1 = new ModelRenderer(this, 167, 186);
/*  689 */     this.Back1.addBox(0.0F, 0.0F, 0.0F, 30, 15, 49);
/*  690 */     this.Back1.setRotationPoint(-45.0F, -127.0F, -58.0F);
/*  691 */     this.Back1.setTextureSize(2048, 2048);
/*  692 */     this.Back1.mirror = true;
/*  693 */     setRotation(this.Back1, -0.0698132F, 0.0F, 0.0F);
/*  694 */     this.Back2 = new ModelRenderer(this, 0, 186);
/*  695 */     this.Back2.addBox(0.0F, 0.0F, 0.0F, 30, 15, 49);
/*  696 */     this.Back2.setRotationPoint(15.0F, -127.0F, -58.0F);
/*  697 */     this.Back2.setTextureSize(2048, 2048);
/*  698 */     this.Back2.mirror = true;
/*  699 */     setRotation(this.Back2, -0.0698132F, 0.0F, 0.0F);
/*  700 */     this.Lwing1 = new ModelRenderer(this, 250, 1000);
/*  701 */     this.Lwing1.addBox(0.0F, 0.0F, 0.0F, 87, 5, 5);
/*  702 */     this.Lwing1.setRotationPoint(40.0F, -121.0F, -50.0F);
/*  703 */     this.Lwing1.setTextureSize(2048, 2048);
/*  704 */     this.Lwing1.mirror = true;
/*  705 */     setRotation(this.Lwing1, 0.0F, 0.0349066F, 0.0F);
/*  706 */     this.Lwing2 = new ModelRenderer(this, 1220, 782);
/*  707 */     this.Lwing2.addBox(0.0F, 2.0F, 0.0F, 87, 1, 110);
/*  708 */     this.Lwing2.setRotationPoint(40.0F, -121.0F, -49.0F);
/*  709 */     this.Lwing2.setTextureSize(2048, 2048);
/*  710 */     this.Lwing2.mirror = true;
/*  711 */     setRotation(this.Lwing2, 0.0F, 0.0349066F, 0.0F);
/*  712 */     this.Lwing3 = new ModelRenderer(this, 250, 975);
/*  713 */     this.Lwing3.addBox(0.0F, 0.0F, 0.0F, 188, 5, 5);
/*  714 */     this.Lwing3.setRotationPoint(124.0F, -121.0F, -53.0F);
/*  715 */     this.Lwing3.setTextureSize(2048, 2048);
/*  716 */     this.Lwing3.mirror = true;
/*  717 */     setRotation(this.Lwing3, 0.0F, 0.0F, 0.0F);
/*  718 */     this.Lwing4 = new ModelRenderer(this, 1341, 625);
/*  719 */     this.Lwing4.addBox(0.0F, 2.0F, 0.0F, 188, 1, 147);
/*  720 */     this.Lwing4.setRotationPoint(124.0F, -121.0F, -50.0F);
/*  721 */     this.Lwing4.setTextureSize(2048, 2048);
/*  722 */     this.Lwing4.mirror = true;
/*  723 */     setRotation(this.Lwing4, 0.0F, 0.0F, 0.0F);
/*  724 */     this.Lwing5 = new ModelRenderer(this, 245, 950);
/*  725 */     this.Lwing5.addBox(0.0F, 0.0F, 0.0F, 87, 5, 5);
/*  726 */     this.Lwing5.setRotationPoint(309.0F, -121.0F, -53.0F);
/*  727 */     this.Lwing5.setTextureSize(2048, 2048);
/*  728 */     this.Lwing5.mirror = true;
/*  729 */     setRotation(this.Lwing5, 0.0F, -0.0349066F, 0.0F);
/*  730 */     this.Lwing6 = new ModelRenderer(this, 1300, 1300);
/*  731 */     this.Lwing6.addBox(0.0F, 2.0F, 1.0F, 87, 1, 125);
/*  732 */     this.Lwing6.setRotationPoint(309.0F, -121.0F, -50.0F);
/*  733 */     this.Lwing6.setTextureSize(2048, 2048);
/*  734 */     this.Lwing6.mirror = true;
/*  735 */     setRotation(this.Lwing6, 0.0F, 0.0F, 0.0F);
/*  736 */     this.Lwing7 = new ModelRenderer(this, 250, 900);
/*  737 */     this.Lwing7.addBox(0.0F, 0.0F, 0.0F, 140, 5, 5);
/*  738 */     this.Lwing7.setRotationPoint(124.0F, -121.0F, -53.0F);
/*  739 */     this.Lwing7.setTextureSize(2048, 2048);
/*  740 */     this.Lwing7.mirror = true;
/*  741 */     setRotation(this.Lwing7, 0.0F, 0.0F, 0.2617994F);
/*  742 */     this.Lwing9 = new ModelRenderer(this, 250, 925);
/*  743 */     this.Lwing9.addBox(0.0F, 0.0F, 0.0F, 170, 5, 5);
/*  744 */     this.Lwing9.setRotationPoint(124.0F, -121.0F, -53.0F);
/*  745 */     this.Lwing9.setTextureSize(2048, 2048);
/*  746 */     this.Lwing9.mirror = true;
/*  747 */     setRotation(this.Lwing9, 0.0F, 0.0F, -0.2617994F);
/*  748 */     this.Lwing8 = new ModelRenderer(this, 1300, 1156);
/*  749 */     this.Lwing8.addBox(0.0F, 2.0F, 0.0F, 140, 1, 120);
/*  750 */     this.Lwing8.setRotationPoint(124.0F, -121.0F, -50.0F);
/*  751 */     this.Lwing8.setTextureSize(2048, 2048);
/*  752 */     this.Lwing8.mirror = true;
/*  753 */     setRotation(this.Lwing8, 0.0F, 0.0F, 0.2617994F);
/*  754 */     this.Lwing10 = new ModelRenderer(this, 1392, 326);
/*  755 */     this.Lwing10.addBox(0.0F, 2.0F, 0.0F, 170, 1, 136);
/*  756 */     this.Lwing10.setRotationPoint(124.0F, -121.0F, -50.0F);
/*  757 */     this.Lwing10.setTextureSize(2048, 2048);
/*  758 */     this.Lwing10.mirror = true;
/*  759 */     setRotation(this.Lwing10, 0.0F, 0.0F, -0.2617994F);
/*  760 */     this.Rwing1 = new ModelRenderer(this, 650, 1000);
/*  761 */     this.Rwing1.addBox(-87.0F, 0.0F, 0.0F, 87, 5, 5);
/*  762 */     this.Rwing1.setRotationPoint(-40.0F, -121.0F, -50.0F);
/*  763 */     this.Rwing1.setTextureSize(2048, 2048);
/*  764 */     this.Rwing1.mirror = true;
/*  765 */     setRotation(this.Rwing1, 0.0F, -0.0349066F, 0.0F);
/*  766 */     this.Rwing2 = new ModelRenderer(this, 1619, 782);
/*  767 */     this.Rwing2.addBox(-87.0F, 2.0F, 0.0F, 87, 1, 110);
/*  768 */     this.Rwing2.setRotationPoint(-40.0F, -121.0F, -49.0F);
/*  769 */     this.Rwing2.setTextureSize(2048, 2048);
/*  770 */     this.Rwing2.mirror = true;
/*  771 */     setRotation(this.Rwing2, 0.0F, -0.0349066F, 0.0F);
/*  772 */     this.Rwing3 = new ModelRenderer(this, 550, 950);
/*  773 */     this.Rwing3.addBox(-188.0F, 0.0F, 0.0F, 188, 5, 5);
/*  774 */     this.Rwing3.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  775 */     this.Rwing3.setTextureSize(2048, 2048);
/*  776 */     this.Rwing3.mirror = true;
/*  777 */     setRotation(this.Rwing3, 0.0F, 0.0F, 0.0F);
/*  778 */     this.Rwing4 = new ModelRenderer(this, 1341, 470);
/*  779 */     this.Rwing4.addBox(-188.0F, 2.0F, 0.0F, 188, 1, 147);
/*  780 */     this.Rwing4.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  781 */     this.Rwing4.setTextureSize(2048, 2048);
/*  782 */     this.Rwing4.mirror = true;
/*  783 */     setRotation(this.Rwing4, 0.0F, 0.0F, 0.0F);
/*  784 */     this.Rwing5 = new ModelRenderer(this, 750, 975);
/*  785 */     this.Rwing5.addBox(-87.0F, 0.0F, 0.0F, 87, 5, 5);
/*  786 */     this.Rwing5.setRotationPoint(-309.0F, -121.0F, -53.0F);
/*  787 */     this.Rwing5.setTextureSize(2048, 2048);
/*  788 */     this.Rwing5.mirror = true;
/*  789 */     setRotation(this.Rwing5, 0.0F, 0.0349066F, 0.0F);
/*  790 */     this.Rwing6 = new ModelRenderer(this, 1300, 1436);
/*  791 */     this.Rwing6.addBox(-87.0F, 2.0F, 1.0F, 87, 1, 125);
/*  792 */     this.Rwing6.setRotationPoint(-309.0F, -121.0F, -50.0F);
/*  793 */     this.Rwing6.setTextureSize(2048, 2048);
/*  794 */     this.Rwing6.mirror = true;
/*  795 */     setRotation(this.Rwing6, 0.0F, 0.0F, 0.0F);
/*  796 */     this.Rwing7 = new ModelRenderer(this, 650, 900);
/*  797 */     this.Rwing7.addBox(-140.0F, 0.0F, 0.0F, 140, 5, 5);
/*  798 */     this.Rwing7.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  799 */     this.Rwing7.setTextureSize(2048, 2048);
/*  800 */     this.Rwing7.mirror = true;
/*  801 */     setRotation(this.Rwing7, 0.0F, 0.0F, -0.2617994F);
/*  802 */     this.Rwing8 = new ModelRenderer(this, 1300, 1024);
/*  803 */     this.Rwing8.addBox(-140.0F, 2.0F, 0.0F, 140, 1, 120);
/*  804 */     this.Rwing8.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  805 */     this.Rwing8.setTextureSize(2048, 2048);
/*  806 */     this.Rwing8.mirror = true;
/*  807 */     setRotation(this.Rwing8, 0.0F, 0.0F, -0.2617994F);
/*  808 */     this.Rwing9 = new ModelRenderer(this, 621, 925);
/*  809 */     this.Rwing9.addBox(-170.0F, 0.0F, 0.0F, 170, 5, 5);
/*  810 */     this.Rwing9.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  811 */     this.Rwing9.setTextureSize(2048, 2048);
/*  812 */     this.Rwing9.mirror = true;
/*  813 */     setRotation(this.Rwing9, 0.0F, 0.0F, 0.2617994F);
/*  814 */     this.Rwing10 = new ModelRenderer(this, 1391, 184);
/*  815 */     this.Rwing10.addBox(-170.0F, 2.0F, 0.0F, 170, 1, 136);
/*  816 */     this.Rwing10.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  817 */     this.Rwing10.setTextureSize(2048, 2048);
/*  818 */     this.Rwing10.mirror = true;
/*  819 */     setRotation(this.Rwing10, 0.0F, 0.0F, 0.2617994F);
/*  820 */     this.TailTip2 = new ModelRenderer(this, 500, 63);
/*  821 */     this.TailTip2.addBox(-35.0F, -2.0F, 36.0F, 70, 4, 26);
/*  822 */     this.TailTip2.setRotationPoint(0.0F, -86.0F, 308.0F);
/*  823 */     this.TailTip2.setTextureSize(2048, 2048);
/*  824 */     this.TailTip2.mirror = true;
/*  825 */     setRotation(this.TailTip2, 0.0F, 0.0F, 0.0F);
/*  826 */     this.Ridge1 = new ModelRenderer(this, 850, 717);
/*  827 */     this.Ridge1.addBox(-1.0F, 0.0F, 0.0F, 3, 10, 24);
/*  828 */     this.Ridge1.setRotationPoint(0.0F, -122.0F, -75.0F);
/*  829 */     this.Ridge1.setTextureSize(2048, 2048);
/*  830 */     this.Ridge1.mirror = true;
/*  831 */     setRotation(this.Ridge1, 0.3665191F, 0.0F, 0.0F);
/*  832 */     this.Ridge2 = new ModelRenderer(this, 850, 676);
/*  833 */     this.Ridge2.addBox(-1.0F, 0.0F, 0.0F, 3, 10, 24);
/*  834 */     this.Ridge2.setRotationPoint(0.0F, -122.0F, -50.0F);
/*  835 */     this.Ridge2.setTextureSize(2048, 2048);
/*  836 */     this.Ridge2.mirror = true;
/*  837 */     setRotation(this.Ridge2, 0.3665191F, 0.0F, 0.0F);
/*  838 */     this.Ridge3 = new ModelRenderer(this, 800, 600);
/*  839 */     this.Ridge3.addBox(-1.0F, 0.0F, 0.0F, 3, 20, 49);
/*  840 */     this.Ridge3.setRotationPoint(0.0F, -120.0F, -20.0F);
/*  841 */     this.Ridge3.setTextureSize(2048, 2048);
/*  842 */     this.Ridge3.mirror = true;
/*  843 */     setRotation(this.Ridge3, 0.3665191F, 0.0F, 0.0F);
/*  844 */     this.Ridge4 = new ModelRenderer(this, 800, 550);
/*  845 */     this.Ridge4.addBox(-1.0F, 3.0F, 9.0F, 3, 10, 22);
/*  846 */     this.Ridge4.setRotationPoint(0.0F, -114.0F, 29.0F);
/*  847 */     this.Ridge4.setTextureSize(2048, 2048);
/*  848 */     this.Ridge4.mirror = true;
/*  849 */     setRotation(this.Ridge4, 0.3665191F, 0.0F, 0.0F);
/*  850 */     this.Ridge5 = new ModelRenderer(this, 800, 500);
/*  851 */     this.Ridge5.addBox(-1.0F, 13.0F, 33.0F, 3, 10, 20);
/*  852 */     this.Ridge5.setRotationPoint(0.0F, -114.0F, 29.0F);
/*  853 */     this.Ridge5.setTextureSize(2048, 2048);
/*  854 */     this.Ridge5.mirror = true;
/*  855 */     setRotation(this.Ridge5, 0.3665191F, 0.0F, 0.0F);
/*  856 */     this.Ridge6 = new ModelRenderer(this, 638, 165);
/*  857 */     this.Ridge6.addBox(-1.0F, 2.0F, 20.0F, 3, 10, 20);
/*  858 */     this.Ridge6.setRotationPoint(0.0F, -87.0F, 268.0F);
/*  859 */     this.Ridge6.setTextureSize(2048, 2048);
/*  860 */     this.Ridge6.mirror = true;
/*  861 */     setRotation(this.Ridge6, 0.3665191F, 0.0F, 0.0F);
/*  862 */     this.NeckBone1 = new ModelRenderer(this, 300, 2);
/*  863 */     this.NeckBone1.addBox(0.0F, 0.0F, 0.0F, 5, 11, 57);
/*  864 */     this.NeckBone1.setRotationPoint(-2.0F, -123.0F, -79.0F);
/*  865 */     this.NeckBone1.setTextureSize(2048, 2048);
/*  866 */     this.NeckBone1.mirror = true;
/*  867 */     setRotation(this.NeckBone1, 0.0F, 0.0F, 0.0F);
/*  868 */     this.NeckBone2 = new ModelRenderer(this, 300, 78);
/*  869 */     this.NeckBone2.addBox(0.0F, 0.0F, 0.0F, 5, 11, 21);
/*  870 */     this.NeckBone2.setRotationPoint(27.0F, -123.0F, -79.0F);
/*  871 */     this.NeckBone2.setTextureSize(2048, 2048);
/*  872 */     this.NeckBone2.mirror = true;
/*  873 */     setRotation(this.NeckBone2, 0.0F, 0.0F, 0.0F);
/*  874 */     this.NeckBone3 = new ModelRenderer(this, 365, 78);
/*  875 */     this.NeckBone3.addBox(0.0F, 0.0F, 0.0F, 5, 11, 21);
/*  876 */     this.NeckBone3.setRotationPoint(-33.0F, -123.0F, -79.0F);
/*  877 */     this.NeckBone3.setTextureSize(2048, 2048);
/*  878 */     this.NeckBone3.mirror = true;
/*  879 */     setRotation(this.NeckBone3, 0.0F, 0.0F, 0.0F);
/*  880 */     this.PowerCube1 = new ModelRenderer(this, 0, 484);
/*  881 */     this.PowerCube1.addBox(-15.0F, -15.0F, -15.0F, 30, 30, 30);
/*  882 */     this.PowerCube1.setRotationPoint(0.0F, -86.0F, -50.0F);
/*  883 */     this.PowerCube1.setTextureSize(2048, 2048);
/*  884 */     this.PowerCube1.mirror = true;
/*  885 */     setRotation(this.PowerCube1, 0.0F, 0.0F, 0.0F);
/*  886 */     this.Rib1 = new ModelRenderer(this, 0, 39);
/*  887 */     this.Rib1.addBox(-2.0F, -2.0F, -12.0F, 4, 4, 24);
/*  888 */     this.Rib1.setRotationPoint(29.0F, -71.0F, -67.0F);
/*  889 */     this.Rib1.setTextureSize(2048, 2048);
/*  890 */     this.Rib1.mirror = true;
/*  891 */     setRotation(this.Rib1, 0.5235988F, 0.6632251F, 0.0F);
/*  892 */     this.Rib2 = new ModelRenderer(this, 0, 78);
/*  893 */     this.Rib2.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 19);
/*  894 */     this.Rib2.setRotationPoint(28.0F, -66.0F, -53.0F);
/*  895 */     this.Rib2.setTextureSize(2048, 2048);
/*  896 */     this.Rib2.mirror = true;
/*  897 */     setRotation(this.Rib2, 0.5235988F, 0.6632251F, 0.0F);
/*  898 */     this.Rib3 = new ModelRenderer(this, 0, 113);
/*  899 */     this.Rib3.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 20);
/*  900 */     this.Rib3.setRotationPoint(30.0F, -83.0F, -70.0F);
/*  901 */     this.Rib3.setTextureSize(2048, 2048);
/*  902 */     this.Rib3.mirror = true;
/*  903 */     setRotation(this.Rib3, 0.5235988F, 0.6632251F, 0.0F);
/*  904 */     this.Rib4 = new ModelRenderer(this, 64, 38);
/*  905 */     this.Rib4.addBox(-2.0F, -2.0F, -12.0F, 4, 4, 24);
/*  906 */     this.Rib4.setRotationPoint(-29.0F, -71.0F, -67.0F);
/*  907 */     this.Rib4.setTextureSize(2048, 2048);
/*  908 */     this.Rib4.mirror = true;
/*  909 */     setRotation(this.Rib4, 0.5235988F, -0.6632251F, 0.0F);
/*  910 */     this.Rib5 = new ModelRenderer(this, 65, 76);
/*  911 */     this.Rib5.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 20);
/*  912 */     this.Rib5.setRotationPoint(-30.0F, -83.0F, -70.0F);
/*  913 */     this.Rib5.setTextureSize(2048, 2048);
/*  914 */     this.Rib5.mirror = true;
/*  915 */     setRotation(this.Rib5, 0.5235988F, -0.6632251F, 0.0F);
/*  916 */     this.Rib6 = new ModelRenderer(this, 63, 112);
/*  917 */     this.Rib6.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 19);
/*  918 */     this.Rib6.setRotationPoint(-28.0F, -66.0F, -53.0F);
/*  919 */     this.Rib6.setTextureSize(2048, 2048);
/*  920 */     this.Rib6.mirror = true;
/*  921 */     setRotation(this.Rib6, 0.5235988F, -0.6632251F, 0.0F);
/*  922 */     this.PowerCube2 = new ModelRenderer(this, 0, 556);
/*  923 */     this.PowerCube2.addBox(-20.0F, -20.0F, -20.0F, 40, 40, 40);
/*  924 */     this.PowerCube2.setRotationPoint(0.0F, -86.0F, -50.0F);
/*  925 */     this.PowerCube2.setTextureSize(2048, 2048);
/*  926 */     this.PowerCube2.mirror = true;
/*  927 */     setRotation(this.PowerCube2, 0.0F, 0.0F, 0.0F);
/*  928 */     this.PowerCube3 = new ModelRenderer(this, 0, 646);
/*  929 */     this.PowerCube3.addBox(-25.0F, -25.0F, -25.0F, 50, 50, 50);
/*  930 */     this.PowerCube3.setRotationPoint(0.0F, -86.0F, -50.0F);
/*  931 */     this.PowerCube3.setTextureSize(2048, 2048);
/*  932 */     this.PowerCube3.mirror = true;
/*  933 */     setRotation(this.PowerCube3, 0.0F, 0.0F, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*      */     // Byte code:
/*      */     //   0: fconst_0
/*      */     //   1: fstore #8
/*      */     //   3: aload_1
/*      */     //   4: checkcast danger/orespawn/TheQueen
/*      */     //   7: astore #9
/*      */     //   9: ldc_w 0.26
/*      */     //   12: fstore #10
/*      */     //   14: ldc_w 0.08
/*      */     //   17: fstore #11
/*      */     //   19: ldc 0.7853982
/*      */     //   21: fstore #12
/*      */     //   23: fconst_0
/*      */     //   24: fstore #13
/*      */     //   26: fconst_0
/*      */     //   27: fstore #14
/*      */     //   29: fconst_0
/*      */     //   30: fstore #15
/*      */     //   32: fconst_0
/*      */     //   33: fstore #16
/*      */     //   35: fconst_0
/*      */     //   36: fstore #17
/*      */     //   38: fconst_0
/*      */     //   39: fstore #18
/*      */     //   41: fconst_0
/*      */     //   42: fstore #19
/*      */     //   44: fconst_0
/*      */     //   45: fstore #20
/*      */     //   47: fconst_0
/*      */     //   48: fstore #21
/*      */     //   50: aload_0
/*      */     //   51: aload_1
/*      */     //   52: fload_2
/*      */     //   53: fload_3
/*      */     //   54: fload #4
/*      */     //   56: fload #5
/*      */     //   58: fload #6
/*      */     //   60: fload #7
/*      */     //   62: invokespecial render : (Lnet/minecraft/entity/Entity;FFFFFF)V
/*      */     //   65: aload_0
/*      */     //   66: fload_2
/*      */     //   67: fload_3
/*      */     //   68: fload #4
/*      */     //   70: fload #5
/*      */     //   72: fload #6
/*      */     //   74: fload #7
/*      */     //   76: aload_1
/*      */     //   77: invokevirtual setRotationAngles : (FFFFFFLnet/minecraft/entity/Entity;)V
/*      */     //   80: aload #9
/*      */     //   82: invokevirtual getAttacking : ()I
/*      */     //   85: ifeq -> 115
/*      */     //   88: fload #4
/*      */     //   90: ldc_w 0.85
/*      */     //   93: fmul
/*      */     //   94: aload_0
/*      */     //   95: getfield wingspeed : F
/*      */     //   98: fmul
/*      */     //   99: invokestatic cos : (F)F
/*      */     //   102: ldc_w 3.1415927
/*      */     //   105: fmul
/*      */     //   106: ldc_w 0.26
/*      */     //   109: fmul
/*      */     //   110: fstore #8
/*      */     //   112: goto -> 139
/*      */     //   115: fload #4
/*      */     //   117: ldc_w 0.35
/*      */     //   120: fmul
/*      */     //   121: aload_0
/*      */     //   122: getfield wingspeed : F
/*      */     //   125: fmul
/*      */     //   126: invokestatic cos : (F)F
/*      */     //   129: ldc_w 3.1415927
/*      */     //   132: fmul
/*      */     //   133: ldc_w 0.15
/*      */     //   136: fmul
/*      */     //   137: fstore #8
/*      */     //   139: aload_0
/*      */     //   140: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   143: fload #8
/*      */     //   145: putfield rotateAngleZ : F
/*      */     //   148: aload_0
/*      */     //   149: getfield Lwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   152: fload #8
/*      */     //   154: putfield rotateAngleZ : F
/*      */     //   157: aload_0
/*      */     //   158: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   161: fload #8
/*      */     //   163: ldc_w 5.0
/*      */     //   166: fmul
/*      */     //   167: ldc_w 3.0
/*      */     //   170: fdiv
/*      */     //   171: putfield rotateAngleZ : F
/*      */     //   174: aload_0
/*      */     //   175: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   178: aload_0
/*      */     //   179: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   182: getfield rotationPointY : F
/*      */     //   185: aload_0
/*      */     //   186: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   189: getfield rotateAngleZ : F
/*      */     //   192: f2d
/*      */     //   193: invokestatic sin : (D)D
/*      */     //   196: d2f
/*      */     //   197: ldc_w 84.0
/*      */     //   200: fmul
/*      */     //   201: fadd
/*      */     //   202: putfield rotationPointY : F
/*      */     //   205: aload_0
/*      */     //   206: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   209: aload_0
/*      */     //   210: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   213: getfield rotationPointX : F
/*      */     //   216: aload_0
/*      */     //   217: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   220: getfield rotateAngleZ : F
/*      */     //   223: f2d
/*      */     //   224: invokestatic cos : (D)D
/*      */     //   227: d2f
/*      */     //   228: ldc_w 84.0
/*      */     //   231: fmul
/*      */     //   232: fadd
/*      */     //   233: putfield rotationPointX : F
/*      */     //   236: aload_0
/*      */     //   237: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   240: aload_0
/*      */     //   241: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   244: getfield rotateAngleZ : F
/*      */     //   247: putfield rotateAngleZ : F
/*      */     //   250: aload_0
/*      */     //   251: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   254: aload_0
/*      */     //   255: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   258: getfield rotationPointY : F
/*      */     //   261: putfield rotationPointY : F
/*      */     //   264: aload_0
/*      */     //   265: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   268: aload_0
/*      */     //   269: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   272: getfield rotationPointX : F
/*      */     //   275: putfield rotationPointX : F
/*      */     //   278: aload_0
/*      */     //   279: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   282: fload #8
/*      */     //   284: ldc_w 7.0
/*      */     //   287: fmul
/*      */     //   288: ldc_w 3.0
/*      */     //   291: fdiv
/*      */     //   292: putfield rotateAngleZ : F
/*      */     //   295: aload_0
/*      */     //   296: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   299: aload_0
/*      */     //   300: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   303: getfield rotationPointY : F
/*      */     //   306: aload_0
/*      */     //   307: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   310: getfield rotateAngleZ : F
/*      */     //   313: f2d
/*      */     //   314: invokestatic sin : (D)D
/*      */     //   317: d2f
/*      */     //   318: ldc_w 184.0
/*      */     //   321: fmul
/*      */     //   322: fadd
/*      */     //   323: putfield rotationPointY : F
/*      */     //   326: aload_0
/*      */     //   327: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   330: aload_0
/*      */     //   331: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   334: getfield rotationPointX : F
/*      */     //   337: aload_0
/*      */     //   338: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   341: getfield rotateAngleZ : F
/*      */     //   344: f2d
/*      */     //   345: invokestatic cos : (D)D
/*      */     //   348: d2f
/*      */     //   349: ldc_w 184.0
/*      */     //   352: fmul
/*      */     //   353: fadd
/*      */     //   354: putfield rotationPointX : F
/*      */     //   357: aload_0
/*      */     //   358: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   361: aload_0
/*      */     //   362: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   365: getfield rotateAngleZ : F
/*      */     //   368: putfield rotateAngleZ : F
/*      */     //   371: aload_0
/*      */     //   372: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   375: aload_0
/*      */     //   376: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   379: getfield rotationPointY : F
/*      */     //   382: putfield rotationPointY : F
/*      */     //   385: aload_0
/*      */     //   386: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   389: aload_0
/*      */     //   390: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   393: getfield rotationPointX : F
/*      */     //   396: putfield rotationPointX : F
/*      */     //   399: aload_0
/*      */     //   400: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   403: aload_0
/*      */     //   404: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   407: aload_0
/*      */     //   408: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   411: getfield rotationPointY : F
/*      */     //   414: dup_x1
/*      */     //   415: putfield rotationPointY : F
/*      */     //   418: putfield rotationPointY : F
/*      */     //   421: aload_0
/*      */     //   422: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   425: aload_0
/*      */     //   426: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   429: aload_0
/*      */     //   430: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   433: getfield rotationPointX : F
/*      */     //   436: dup_x1
/*      */     //   437: putfield rotationPointX : F
/*      */     //   440: putfield rotationPointX : F
/*      */     //   443: aload_0
/*      */     //   444: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   447: aload_0
/*      */     //   448: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   451: aload_0
/*      */     //   452: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   455: getfield rotationPointY : F
/*      */     //   458: dup_x1
/*      */     //   459: putfield rotationPointY : F
/*      */     //   462: putfield rotationPointY : F
/*      */     //   465: aload_0
/*      */     //   466: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   469: aload_0
/*      */     //   470: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   473: aload_0
/*      */     //   474: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   477: getfield rotationPointX : F
/*      */     //   480: dup_x1
/*      */     //   481: putfield rotationPointX : F
/*      */     //   484: putfield rotationPointX : F
/*      */     //   487: aload_0
/*      */     //   488: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   491: aload_0
/*      */     //   492: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   495: ldc_w 0.261
/*      */     //   498: aload_0
/*      */     //   499: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   502: getfield rotateAngleZ : F
/*      */     //   505: fadd
/*      */     //   506: dup_x1
/*      */     //   507: putfield rotateAngleZ : F
/*      */     //   510: putfield rotateAngleZ : F
/*      */     //   513: aload_0
/*      */     //   514: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   517: aload_0
/*      */     //   518: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   521: ldc_w -0.261
/*      */     //   524: aload_0
/*      */     //   525: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   528: getfield rotateAngleZ : F
/*      */     //   531: fadd
/*      */     //   532: dup_x1
/*      */     //   533: putfield rotateAngleZ : F
/*      */     //   536: putfield rotateAngleZ : F
/*      */     //   539: aload_0
/*      */     //   540: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   543: fload #8
/*      */     //   545: fneg
/*      */     //   546: putfield rotateAngleZ : F
/*      */     //   549: aload_0
/*      */     //   550: getfield Rwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   553: fload #8
/*      */     //   555: fneg
/*      */     //   556: putfield rotateAngleZ : F
/*      */     //   559: aload_0
/*      */     //   560: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   563: fload #8
/*      */     //   565: fneg
/*      */     //   566: ldc_w 5.0
/*      */     //   569: fmul
/*      */     //   570: ldc_w 3.0
/*      */     //   573: fdiv
/*      */     //   574: putfield rotateAngleZ : F
/*      */     //   577: aload_0
/*      */     //   578: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   581: aload_0
/*      */     //   582: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   585: getfield rotationPointY : F
/*      */     //   588: aload_0
/*      */     //   589: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   592: getfield rotateAngleZ : F
/*      */     //   595: f2d
/*      */     //   596: invokestatic sin : (D)D
/*      */     //   599: d2f
/*      */     //   600: ldc_w 84.0
/*      */     //   603: fmul
/*      */     //   604: fsub
/*      */     //   605: putfield rotationPointY : F
/*      */     //   608: aload_0
/*      */     //   609: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   612: aload_0
/*      */     //   613: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   616: getfield rotationPointX : F
/*      */     //   619: aload_0
/*      */     //   620: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   623: getfield rotateAngleZ : F
/*      */     //   626: f2d
/*      */     //   627: invokestatic cos : (D)D
/*      */     //   630: d2f
/*      */     //   631: ldc_w 84.0
/*      */     //   634: fmul
/*      */     //   635: fsub
/*      */     //   636: putfield rotationPointX : F
/*      */     //   639: aload_0
/*      */     //   640: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   643: aload_0
/*      */     //   644: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   647: getfield rotateAngleZ : F
/*      */     //   650: putfield rotateAngleZ : F
/*      */     //   653: aload_0
/*      */     //   654: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   657: aload_0
/*      */     //   658: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   661: getfield rotationPointY : F
/*      */     //   664: putfield rotationPointY : F
/*      */     //   667: aload_0
/*      */     //   668: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   671: aload_0
/*      */     //   672: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   675: getfield rotationPointX : F
/*      */     //   678: putfield rotationPointX : F
/*      */     //   681: aload_0
/*      */     //   682: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   685: fload #8
/*      */     //   687: fneg
/*      */     //   688: ldc_w 7.0
/*      */     //   691: fmul
/*      */     //   692: ldc_w 3.0
/*      */     //   695: fdiv
/*      */     //   696: putfield rotateAngleZ : F
/*      */     //   699: aload_0
/*      */     //   700: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   703: aload_0
/*      */     //   704: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   707: getfield rotationPointY : F
/*      */     //   710: aload_0
/*      */     //   711: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   714: getfield rotateAngleZ : F
/*      */     //   717: f2d
/*      */     //   718: invokestatic sin : (D)D
/*      */     //   721: d2f
/*      */     //   722: ldc_w 184.0
/*      */     //   725: fmul
/*      */     //   726: fsub
/*      */     //   727: putfield rotationPointY : F
/*      */     //   730: aload_0
/*      */     //   731: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   734: aload_0
/*      */     //   735: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   738: getfield rotationPointX : F
/*      */     //   741: aload_0
/*      */     //   742: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   745: getfield rotateAngleZ : F
/*      */     //   748: f2d
/*      */     //   749: invokestatic cos : (D)D
/*      */     //   752: d2f
/*      */     //   753: ldc_w 184.0
/*      */     //   756: fmul
/*      */     //   757: fsub
/*      */     //   758: putfield rotationPointX : F
/*      */     //   761: aload_0
/*      */     //   762: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   765: aload_0
/*      */     //   766: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   769: getfield rotateAngleZ : F
/*      */     //   772: putfield rotateAngleZ : F
/*      */     //   775: aload_0
/*      */     //   776: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   779: aload_0
/*      */     //   780: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   783: getfield rotationPointY : F
/*      */     //   786: putfield rotationPointY : F
/*      */     //   789: aload_0
/*      */     //   790: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   793: aload_0
/*      */     //   794: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   797: getfield rotationPointX : F
/*      */     //   800: putfield rotationPointX : F
/*      */     //   803: aload_0
/*      */     //   804: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   807: aload_0
/*      */     //   808: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   811: aload_0
/*      */     //   812: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   815: getfield rotationPointY : F
/*      */     //   818: dup_x1
/*      */     //   819: putfield rotationPointY : F
/*      */     //   822: putfield rotationPointY : F
/*      */     //   825: aload_0
/*      */     //   826: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   829: aload_0
/*      */     //   830: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   833: aload_0
/*      */     //   834: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   837: getfield rotationPointX : F
/*      */     //   840: dup_x1
/*      */     //   841: putfield rotationPointX : F
/*      */     //   844: putfield rotationPointX : F
/*      */     //   847: aload_0
/*      */     //   848: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   851: aload_0
/*      */     //   852: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   855: aload_0
/*      */     //   856: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   859: getfield rotationPointY : F
/*      */     //   862: dup_x1
/*      */     //   863: putfield rotationPointY : F
/*      */     //   866: putfield rotationPointY : F
/*      */     //   869: aload_0
/*      */     //   870: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   873: aload_0
/*      */     //   874: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   877: aload_0
/*      */     //   878: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   881: getfield rotationPointX : F
/*      */     //   884: dup_x1
/*      */     //   885: putfield rotationPointX : F
/*      */     //   888: putfield rotationPointX : F
/*      */     //   891: aload_0
/*      */     //   892: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   895: aload_0
/*      */     //   896: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   899: ldc_w -0.261
/*      */     //   902: aload_0
/*      */     //   903: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   906: getfield rotateAngleZ : F
/*      */     //   909: fadd
/*      */     //   910: dup_x1
/*      */     //   911: putfield rotateAngleZ : F
/*      */     //   914: putfield rotateAngleZ : F
/*      */     //   917: aload_0
/*      */     //   918: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   921: aload_0
/*      */     //   922: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   925: ldc_w 0.261
/*      */     //   928: aload_0
/*      */     //   929: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   932: getfield rotateAngleZ : F
/*      */     //   935: fadd
/*      */     //   936: dup_x1
/*      */     //   937: putfield rotateAngleZ : F
/*      */     //   940: putfield rotateAngleZ : F
/*      */     //   943: aload #9
/*      */     //   945: invokevirtual getAttacking : ()I
/*      */     //   948: ifeq -> 978
/*      */     //   951: fload #4
/*      */     //   953: ldc_w 0.85
/*      */     //   956: fmul
/*      */     //   957: aload_0
/*      */     //   958: getfield wingspeed : F
/*      */     //   961: fmul
/*      */     //   962: invokestatic cos : (F)F
/*      */     //   965: ldc_w 3.1415927
/*      */     //   968: fmul
/*      */     //   969: ldc_w 0.26
/*      */     //   972: fmul
/*      */     //   973: fstore #8
/*      */     //   975: goto -> 981
/*      */     //   978: fconst_0
/*      */     //   979: fstore #8
/*      */     //   981: aload_0
/*      */     //   982: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   985: aload_0
/*      */     //   986: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   989: ldc_w -0.925
/*      */     //   992: fload #8
/*      */     //   994: fadd
/*      */     //   995: dup_x1
/*      */     //   996: putfield rotateAngleX : F
/*      */     //   999: putfield rotateAngleX : F
/*      */     //   1002: aload_0
/*      */     //   1003: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1006: ldc_w 0.384
/*      */     //   1009: fload #8
/*      */     //   1011: fsub
/*      */     //   1012: putfield rotateAngleX : F
/*      */     //   1015: aload_0
/*      */     //   1016: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1019: ldc_w 0.645
/*      */     //   1022: fload #8
/*      */     //   1024: fsub
/*      */     //   1025: putfield rotateAngleX : F
/*      */     //   1028: aload_0
/*      */     //   1029: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1032: ldc_w 0.384
/*      */     //   1035: fload #8
/*      */     //   1037: fsub
/*      */     //   1038: putfield rotateAngleX : F
/*      */     //   1041: aload_0
/*      */     //   1042: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1045: ldc_w 0.645
/*      */     //   1048: fload #8
/*      */     //   1050: fsub
/*      */     //   1051: putfield rotateAngleX : F
/*      */     //   1054: aload_0
/*      */     //   1055: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1058: ldc_w 0.384
/*      */     //   1061: fload #8
/*      */     //   1063: fsub
/*      */     //   1064: putfield rotateAngleX : F
/*      */     //   1067: aload_0
/*      */     //   1068: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1071: ldc_w 0.645
/*      */     //   1074: fload #8
/*      */     //   1076: fsub
/*      */     //   1077: putfield rotateAngleX : F
/*      */     //   1080: aload_0
/*      */     //   1081: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1084: ldc_w 0.384
/*      */     //   1087: fload #8
/*      */     //   1089: fsub
/*      */     //   1090: putfield rotateAngleX : F
/*      */     //   1093: aload_0
/*      */     //   1094: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1097: ldc_w 0.645
/*      */     //   1100: fload #8
/*      */     //   1102: fsub
/*      */     //   1103: putfield rotateAngleX : F
/*      */     //   1106: aload_0
/*      */     //   1107: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1110: ldc_w 0.384
/*      */     //   1113: fload #8
/*      */     //   1115: fsub
/*      */     //   1116: putfield rotateAngleX : F
/*      */     //   1119: aload_0
/*      */     //   1120: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1123: ldc_w 0.645
/*      */     //   1126: fload #8
/*      */     //   1128: fsub
/*      */     //   1129: putfield rotateAngleX : F
/*      */     //   1132: aload_0
/*      */     //   1133: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1136: ldc_w 0.384
/*      */     //   1139: fload #8
/*      */     //   1141: fsub
/*      */     //   1142: putfield rotateAngleX : F
/*      */     //   1145: aload_0
/*      */     //   1146: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1149: ldc_w 0.645
/*      */     //   1152: fload #8
/*      */     //   1154: fsub
/*      */     //   1155: putfield rotateAngleX : F
/*      */     //   1158: aload #9
/*      */     //   1160: invokevirtual getAttacking : ()I
/*      */     //   1163: ifeq -> 1193
/*      */     //   1166: fload #4
/*      */     //   1168: ldc_w 0.7
/*      */     //   1171: fmul
/*      */     //   1172: aload_0
/*      */     //   1173: getfield wingspeed : F
/*      */     //   1176: fmul
/*      */     //   1177: invokestatic cos : (F)F
/*      */     //   1180: ldc_w 3.1415927
/*      */     //   1183: fmul
/*      */     //   1184: ldc_w 0.45
/*      */     //   1187: fmul
/*      */     //   1188: fstore #8
/*      */     //   1190: goto -> 1196
/*      */     //   1193: fconst_0
/*      */     //   1194: fstore #8
/*      */     //   1196: aload_0
/*      */     //   1197: getfield LThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1200: aload_0
/*      */     //   1201: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1204: ldc_w 0.785
/*      */     //   1207: fload #8
/*      */     //   1209: ldc_w 4.0
/*      */     //   1212: fdiv
/*      */     //   1213: fadd
/*      */     //   1214: dup_x1
/*      */     //   1215: putfield rotateAngleX : F
/*      */     //   1218: putfield rotateAngleX : F
/*      */     //   1221: aload_0
/*      */     //   1222: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1225: aload_0
/*      */     //   1226: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1229: ldc_w -0.628
/*      */     //   1232: fload #8
/*      */     //   1234: fconst_2
/*      */     //   1235: fdiv
/*      */     //   1236: fadd
/*      */     //   1237: dup_x1
/*      */     //   1238: putfield rotateAngleX : F
/*      */     //   1241: putfield rotateAngleX : F
/*      */     //   1244: aload_0
/*      */     //   1245: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1248: aload_0
/*      */     //   1249: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1252: aload_0
/*      */     //   1253: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1256: getfield rotationPointY : F
/*      */     //   1259: aload_0
/*      */     //   1260: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1263: getfield rotateAngleX : F
/*      */     //   1266: f2d
/*      */     //   1267: invokestatic cos : (D)D
/*      */     //   1270: d2f
/*      */     //   1271: ldc_w 50.0
/*      */     //   1274: fmul
/*      */     //   1275: fadd
/*      */     //   1276: dup_x1
/*      */     //   1277: putfield rotationPointY : F
/*      */     //   1280: putfield rotationPointY : F
/*      */     //   1283: aload_0
/*      */     //   1284: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1287: aload_0
/*      */     //   1288: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1291: aload_0
/*      */     //   1292: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1295: getfield rotationPointZ : F
/*      */     //   1298: aload_0
/*      */     //   1299: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1302: getfield rotateAngleX : F
/*      */     //   1305: f2d
/*      */     //   1306: invokestatic sin : (D)D
/*      */     //   1309: d2f
/*      */     //   1310: ldc_w 50.0
/*      */     //   1313: fmul
/*      */     //   1314: fadd
/*      */     //   1315: dup_x1
/*      */     //   1316: putfield rotationPointZ : F
/*      */     //   1319: putfield rotationPointZ : F
/*      */     //   1322: aload_0
/*      */     //   1323: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1326: aload_0
/*      */     //   1327: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1330: aload_0
/*      */     //   1331: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1334: getfield rotationPointY : F
/*      */     //   1337: aload_0
/*      */     //   1338: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1341: getfield rotateAngleX : F
/*      */     //   1344: ldc_w 0.1
/*      */     //   1347: fsub
/*      */     //   1348: f2d
/*      */     //   1349: invokestatic cos : (D)D
/*      */     //   1352: d2f
/*      */     //   1353: ldc_w 66.0
/*      */     //   1356: fmul
/*      */     //   1357: fadd
/*      */     //   1358: dup_x1
/*      */     //   1359: putfield rotationPointY : F
/*      */     //   1362: putfield rotationPointY : F
/*      */     //   1365: aload_0
/*      */     //   1366: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1369: aload_0
/*      */     //   1370: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1373: aload_0
/*      */     //   1374: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1377: getfield rotationPointZ : F
/*      */     //   1380: aload_0
/*      */     //   1381: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1384: getfield rotateAngleX : F
/*      */     //   1387: ldc_w 0.1
/*      */     //   1390: fsub
/*      */     //   1391: f2d
/*      */     //   1392: invokestatic sin : (D)D
/*      */     //   1395: d2f
/*      */     //   1396: ldc_w 66.0
/*      */     //   1399: fmul
/*      */     //   1400: fadd
/*      */     //   1401: dup_x1
/*      */     //   1402: putfield rotationPointZ : F
/*      */     //   1405: putfield rotationPointZ : F
/*      */     //   1408: aload_0
/*      */     //   1409: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1412: aload_0
/*      */     //   1413: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1416: aload_0
/*      */     //   1417: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1420: getfield rotationPointY : F
/*      */     //   1423: dup_x1
/*      */     //   1424: putfield rotationPointY : F
/*      */     //   1427: putfield rotationPointY : F
/*      */     //   1430: aload_0
/*      */     //   1431: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1434: aload_0
/*      */     //   1435: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1438: aload_0
/*      */     //   1439: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1442: getfield rotationPointY : F
/*      */     //   1445: dup_x1
/*      */     //   1446: putfield rotationPointY : F
/*      */     //   1449: putfield rotationPointY : F
/*      */     //   1452: aload_0
/*      */     //   1453: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1456: aload_0
/*      */     //   1457: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1460: aload_0
/*      */     //   1461: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1464: getfield rotationPointZ : F
/*      */     //   1467: dup_x1
/*      */     //   1468: putfield rotationPointZ : F
/*      */     //   1471: putfield rotationPointZ : F
/*      */     //   1474: aload_0
/*      */     //   1475: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1478: aload_0
/*      */     //   1479: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1482: aload_0
/*      */     //   1483: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1486: getfield rotationPointZ : F
/*      */     //   1489: dup_x1
/*      */     //   1490: putfield rotationPointZ : F
/*      */     //   1493: putfield rotationPointZ : F
/*      */     //   1496: aload_0
/*      */     //   1497: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1500: aload_0
/*      */     //   1501: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1504: getfield rotationPointY : F
/*      */     //   1507: aload_0
/*      */     //   1508: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1511: getfield rotateAngleX : F
/*      */     //   1514: ldc_w 0.15
/*      */     //   1517: fadd
/*      */     //   1518: f2d
/*      */     //   1519: invokestatic cos : (D)D
/*      */     //   1522: d2f
/*      */     //   1523: ldc_w 66.0
/*      */     //   1526: fmul
/*      */     //   1527: fadd
/*      */     //   1528: putfield rotationPointY : F
/*      */     //   1531: aload_0
/*      */     //   1532: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1535: aload_0
/*      */     //   1536: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1539: getfield rotationPointZ : F
/*      */     //   1542: aload_0
/*      */     //   1543: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1546: getfield rotateAngleX : F
/*      */     //   1549: ldc_w 0.15
/*      */     //   1552: fadd
/*      */     //   1553: f2d
/*      */     //   1554: invokestatic sin : (D)D
/*      */     //   1557: d2f
/*      */     //   1558: ldc_w 66.0
/*      */     //   1561: fmul
/*      */     //   1562: fadd
/*      */     //   1563: putfield rotationPointZ : F
/*      */     //   1566: aload_0
/*      */     //   1567: getfield RThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1570: aload_0
/*      */     //   1571: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1574: ldc_w 0.785
/*      */     //   1577: fload #8
/*      */     //   1579: ldc_w 4.0
/*      */     //   1582: fdiv
/*      */     //   1583: fsub
/*      */     //   1584: dup_x1
/*      */     //   1585: putfield rotateAngleX : F
/*      */     //   1588: putfield rotateAngleX : F
/*      */     //   1591: aload_0
/*      */     //   1592: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1595: aload_0
/*      */     //   1596: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1599: ldc_w -0.628
/*      */     //   1602: fload #8
/*      */     //   1604: fconst_2
/*      */     //   1605: fdiv
/*      */     //   1606: fsub
/*      */     //   1607: dup_x1
/*      */     //   1608: putfield rotateAngleX : F
/*      */     //   1611: putfield rotateAngleX : F
/*      */     //   1614: aload_0
/*      */     //   1615: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1618: aload_0
/*      */     //   1619: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1622: aload_0
/*      */     //   1623: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1626: getfield rotationPointY : F
/*      */     //   1629: aload_0
/*      */     //   1630: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1633: getfield rotateAngleX : F
/*      */     //   1636: f2d
/*      */     //   1637: invokestatic cos : (D)D
/*      */     //   1640: d2f
/*      */     //   1641: ldc_w 50.0
/*      */     //   1644: fmul
/*      */     //   1645: fadd
/*      */     //   1646: dup_x1
/*      */     //   1647: putfield rotationPointY : F
/*      */     //   1650: putfield rotationPointY : F
/*      */     //   1653: aload_0
/*      */     //   1654: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1657: aload_0
/*      */     //   1658: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1661: aload_0
/*      */     //   1662: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1665: getfield rotationPointZ : F
/*      */     //   1668: aload_0
/*      */     //   1669: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1672: getfield rotateAngleX : F
/*      */     //   1675: f2d
/*      */     //   1676: invokestatic sin : (D)D
/*      */     //   1679: d2f
/*      */     //   1680: ldc_w 50.0
/*      */     //   1683: fmul
/*      */     //   1684: fadd
/*      */     //   1685: dup_x1
/*      */     //   1686: putfield rotationPointZ : F
/*      */     //   1689: putfield rotationPointZ : F
/*      */     //   1692: aload_0
/*      */     //   1693: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1696: aload_0
/*      */     //   1697: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1700: aload_0
/*      */     //   1701: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1704: getfield rotationPointY : F
/*      */     //   1707: aload_0
/*      */     //   1708: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1711: getfield rotateAngleX : F
/*      */     //   1714: ldc_w 0.1
/*      */     //   1717: fsub
/*      */     //   1718: f2d
/*      */     //   1719: invokestatic cos : (D)D
/*      */     //   1722: d2f
/*      */     //   1723: ldc_w 66.0
/*      */     //   1726: fmul
/*      */     //   1727: fadd
/*      */     //   1728: dup_x1
/*      */     //   1729: putfield rotationPointY : F
/*      */     //   1732: putfield rotationPointY : F
/*      */     //   1735: aload_0
/*      */     //   1736: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1739: aload_0
/*      */     //   1740: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1743: aload_0
/*      */     //   1744: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1747: getfield rotationPointZ : F
/*      */     //   1750: aload_0
/*      */     //   1751: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1754: getfield rotateAngleX : F
/*      */     //   1757: ldc_w 0.1
/*      */     //   1760: fsub
/*      */     //   1761: f2d
/*      */     //   1762: invokestatic sin : (D)D
/*      */     //   1765: d2f
/*      */     //   1766: ldc_w 66.0
/*      */     //   1769: fmul
/*      */     //   1770: fadd
/*      */     //   1771: dup_x1
/*      */     //   1772: putfield rotationPointZ : F
/*      */     //   1775: putfield rotationPointZ : F
/*      */     //   1778: aload_0
/*      */     //   1779: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1782: aload_0
/*      */     //   1783: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1786: aload_0
/*      */     //   1787: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1790: getfield rotationPointY : F
/*      */     //   1793: dup_x1
/*      */     //   1794: putfield rotationPointY : F
/*      */     //   1797: putfield rotationPointY : F
/*      */     //   1800: aload_0
/*      */     //   1801: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1804: aload_0
/*      */     //   1805: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1808: aload_0
/*      */     //   1809: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1812: getfield rotationPointY : F
/*      */     //   1815: dup_x1
/*      */     //   1816: putfield rotationPointY : F
/*      */     //   1819: putfield rotationPointY : F
/*      */     //   1822: aload_0
/*      */     //   1823: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1826: aload_0
/*      */     //   1827: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1830: aload_0
/*      */     //   1831: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1834: getfield rotationPointZ : F
/*      */     //   1837: dup_x1
/*      */     //   1838: putfield rotationPointZ : F
/*      */     //   1841: putfield rotationPointZ : F
/*      */     //   1844: aload_0
/*      */     //   1845: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1848: aload_0
/*      */     //   1849: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1852: aload_0
/*      */     //   1853: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1856: getfield rotationPointZ : F
/*      */     //   1859: dup_x1
/*      */     //   1860: putfield rotationPointZ : F
/*      */     //   1863: putfield rotationPointZ : F
/*      */     //   1866: aload_0
/*      */     //   1867: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1870: aload_0
/*      */     //   1871: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1874: getfield rotationPointY : F
/*      */     //   1877: aload_0
/*      */     //   1878: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1881: getfield rotateAngleX : F
/*      */     //   1884: ldc_w 0.15
/*      */     //   1887: fadd
/*      */     //   1888: f2d
/*      */     //   1889: invokestatic cos : (D)D
/*      */     //   1892: d2f
/*      */     //   1893: ldc_w 66.0
/*      */     //   1896: fmul
/*      */     //   1897: fadd
/*      */     //   1898: putfield rotationPointY : F
/*      */     //   1901: aload_0
/*      */     //   1902: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1905: aload_0
/*      */     //   1906: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1909: getfield rotationPointZ : F
/*      */     //   1912: aload_0
/*      */     //   1913: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1916: getfield rotateAngleX : F
/*      */     //   1919: ldc_w 0.15
/*      */     //   1922: fadd
/*      */     //   1923: f2d
/*      */     //   1924: invokestatic sin : (D)D
/*      */     //   1927: d2f
/*      */     //   1928: ldc_w 66.0
/*      */     //   1931: fmul
/*      */     //   1932: fadd
/*      */     //   1933: putfield rotationPointZ : F
/*      */     //   1936: aload #9
/*      */     //   1938: invokevirtual getAttacking : ()I
/*      */     //   1941: ifeq -> 1954
/*      */     //   1944: ldc_w 0.6
/*      */     //   1947: fstore #10
/*      */     //   1949: ldc_w 0.2
/*      */     //   1952: fstore #11
/*      */     //   1954: aload_0
/*      */     //   1955: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1958: fload #4
/*      */     //   1960: fload #10
/*      */     //   1962: fmul
/*      */     //   1963: aload_0
/*      */     //   1964: getfield wingspeed : F
/*      */     //   1967: fmul
/*      */     //   1968: invokestatic cos : (F)F
/*      */     //   1971: ldc_w 3.1415927
/*      */     //   1974: fmul
/*      */     //   1975: fload #11
/*      */     //   1977: fmul
/*      */     //   1978: fconst_2
/*      */     //   1979: fdiv
/*      */     //   1980: putfield rotateAngleY : F
/*      */     //   1983: aload_0
/*      */     //   1984: getfield Ridge4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1987: aload_0
/*      */     //   1988: getfield Ridge5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1991: aload_0
/*      */     //   1992: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1995: getfield rotateAngleY : F
/*      */     //   1998: dup_x1
/*      */     //   1999: putfield rotateAngleY : F
/*      */     //   2002: putfield rotateAngleY : F
/*      */     //   2005: aload_0
/*      */     //   2006: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2009: aload_0
/*      */     //   2010: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2013: getfield rotationPointZ : F
/*      */     //   2016: aload_0
/*      */     //   2017: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2020: getfield rotateAngleY : F
/*      */     //   2023: f2d
/*      */     //   2024: invokestatic cos : (D)D
/*      */     //   2027: d2f
/*      */     //   2028: ldc_w 54.0
/*      */     //   2031: fmul
/*      */     //   2032: fadd
/*      */     //   2033: putfield rotationPointZ : F
/*      */     //   2036: aload_0
/*      */     //   2037: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2040: aload_0
/*      */     //   2041: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2044: getfield rotationPointX : F
/*      */     //   2047: fconst_1
/*      */     //   2048: fsub
/*      */     //   2049: aload_0
/*      */     //   2050: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2053: getfield rotateAngleY : F
/*      */     //   2056: f2d
/*      */     //   2057: invokestatic sin : (D)D
/*      */     //   2060: d2f
/*      */     //   2061: ldc_w 54.0
/*      */     //   2064: fmul
/*      */     //   2065: fadd
/*      */     //   2066: putfield rotationPointX : F
/*      */     //   2069: aload_0
/*      */     //   2070: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2073: fload #4
/*      */     //   2075: fload #10
/*      */     //   2077: fmul
/*      */     //   2078: aload_0
/*      */     //   2079: getfield wingspeed : F
/*      */     //   2082: fmul
/*      */     //   2083: fload #12
/*      */     //   2085: fsub
/*      */     //   2086: invokestatic cos : (F)F
/*      */     //   2089: ldc_w 3.1415927
/*      */     //   2092: fmul
/*      */     //   2093: fload #11
/*      */     //   2095: fmul
/*      */     //   2096: putfield rotateAngleY : F
/*      */     //   2099: aload_0
/*      */     //   2100: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2103: aload_0
/*      */     //   2104: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2107: getfield rotationPointZ : F
/*      */     //   2110: aload_0
/*      */     //   2111: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2114: getfield rotateAngleY : F
/*      */     //   2117: f2d
/*      */     //   2118: invokestatic cos : (D)D
/*      */     //   2121: d2f
/*      */     //   2122: ldc_w 42.0
/*      */     //   2125: fmul
/*      */     //   2126: fadd
/*      */     //   2127: putfield rotationPointZ : F
/*      */     //   2130: aload_0
/*      */     //   2131: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2134: aload_0
/*      */     //   2135: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2138: getfield rotationPointX : F
/*      */     //   2141: aload_0
/*      */     //   2142: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2145: getfield rotateAngleY : F
/*      */     //   2148: f2d
/*      */     //   2149: invokestatic sin : (D)D
/*      */     //   2152: d2f
/*      */     //   2153: ldc_w 42.0
/*      */     //   2156: fmul
/*      */     //   2157: fadd
/*      */     //   2158: putfield rotationPointX : F
/*      */     //   2161: aload_0
/*      */     //   2162: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2165: fload #4
/*      */     //   2167: fload #10
/*      */     //   2169: fmul
/*      */     //   2170: aload_0
/*      */     //   2171: getfield wingspeed : F
/*      */     //   2174: fmul
/*      */     //   2175: fconst_2
/*      */     //   2176: fload #12
/*      */     //   2178: fmul
/*      */     //   2179: fsub
/*      */     //   2180: invokestatic cos : (F)F
/*      */     //   2183: ldc_w 3.1415927
/*      */     //   2186: fmul
/*      */     //   2187: fload #11
/*      */     //   2189: fmul
/*      */     //   2190: putfield rotateAngleY : F
/*      */     //   2193: aload_0
/*      */     //   2194: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2197: aload_0
/*      */     //   2198: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2201: getfield rotationPointZ : F
/*      */     //   2204: aload_0
/*      */     //   2205: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2208: getfield rotateAngleY : F
/*      */     //   2211: f2d
/*      */     //   2212: invokestatic cos : (D)D
/*      */     //   2215: d2f
/*      */     //   2216: ldc_w 41.0
/*      */     //   2219: fmul
/*      */     //   2220: fadd
/*      */     //   2221: putfield rotationPointZ : F
/*      */     //   2224: aload_0
/*      */     //   2225: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2228: aload_0
/*      */     //   2229: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2232: getfield rotationPointX : F
/*      */     //   2235: aload_0
/*      */     //   2236: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2239: getfield rotateAngleY : F
/*      */     //   2242: f2d
/*      */     //   2243: invokestatic sin : (D)D
/*      */     //   2246: d2f
/*      */     //   2247: ldc_w 41.0
/*      */     //   2250: fmul
/*      */     //   2251: fadd
/*      */     //   2252: putfield rotationPointX : F
/*      */     //   2255: aload_0
/*      */     //   2256: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2259: fload #4
/*      */     //   2261: fload #10
/*      */     //   2263: fmul
/*      */     //   2264: aload_0
/*      */     //   2265: getfield wingspeed : F
/*      */     //   2268: fmul
/*      */     //   2269: ldc_w 3.0
/*      */     //   2272: fload #12
/*      */     //   2274: fmul
/*      */     //   2275: fsub
/*      */     //   2276: invokestatic cos : (F)F
/*      */     //   2279: ldc_w 3.1415927
/*      */     //   2282: fmul
/*      */     //   2283: fload #11
/*      */     //   2285: fmul
/*      */     //   2286: putfield rotateAngleY : F
/*      */     //   2289: fload #4
/*      */     //   2291: fload #10
/*      */     //   2293: fmul
/*      */     //   2294: aload_0
/*      */     //   2295: getfield wingspeed : F
/*      */     //   2298: fmul
/*      */     //   2299: ldc_w 3.0
/*      */     //   2302: fload #12
/*      */     //   2304: fmul
/*      */     //   2305: fsub
/*      */     //   2306: invokestatic cos : (F)F
/*      */     //   2309: ldc_w 3.1415927
/*      */     //   2312: fmul
/*      */     //   2313: fload #11
/*      */     //   2315: fmul
/*      */     //   2316: fstore #8
/*      */     //   2318: fload #8
/*      */     //   2320: fconst_2
/*      */     //   2321: fdiv
/*      */     //   2322: fstore #8
/*      */     //   2324: aload_0
/*      */     //   2325: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2328: aload_0
/*      */     //   2329: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2332: getfield rotationPointZ : F
/*      */     //   2335: aload_0
/*      */     //   2336: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2339: getfield rotateAngleY : F
/*      */     //   2342: f2d
/*      */     //   2343: invokestatic cos : (D)D
/*      */     //   2346: d2f
/*      */     //   2347: ldc_w 34.0
/*      */     //   2350: fmul
/*      */     //   2351: fadd
/*      */     //   2352: putfield rotationPointZ : F
/*      */     //   2355: aload_0
/*      */     //   2356: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2359: aload_0
/*      */     //   2360: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2363: getfield rotationPointX : F
/*      */     //   2366: aload_0
/*      */     //   2367: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2370: getfield rotateAngleY : F
/*      */     //   2373: f2d
/*      */     //   2374: invokestatic sin : (D)D
/*      */     //   2377: d2f
/*      */     //   2378: ldc_w 34.0
/*      */     //   2381: fmul
/*      */     //   2382: fadd
/*      */     //   2383: putfield rotationPointX : F
/*      */     //   2386: aload_0
/*      */     //   2387: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2390: aload_0
/*      */     //   2391: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2394: getfield rotateAngleY : F
/*      */     //   2397: fload #8
/*      */     //   2399: fadd
/*      */     //   2400: putfield rotateAngleY : F
/*      */     //   2403: aload_0
/*      */     //   2404: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2407: aload_0
/*      */     //   2408: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2411: getfield rotationPointZ : F
/*      */     //   2414: aload_0
/*      */     //   2415: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2418: getfield rotateAngleY : F
/*      */     //   2421: f2d
/*      */     //   2422: invokestatic cos : (D)D
/*      */     //   2425: d2f
/*      */     //   2426: ldc_w 34.0
/*      */     //   2429: fmul
/*      */     //   2430: fadd
/*      */     //   2431: putfield rotationPointZ : F
/*      */     //   2434: aload_0
/*      */     //   2435: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2438: aload_0
/*      */     //   2439: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2442: getfield rotationPointX : F
/*      */     //   2445: aload_0
/*      */     //   2446: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2449: getfield rotateAngleY : F
/*      */     //   2452: f2d
/*      */     //   2453: invokestatic sin : (D)D
/*      */     //   2456: d2f
/*      */     //   2457: ldc_w 34.0
/*      */     //   2460: fmul
/*      */     //   2461: fadd
/*      */     //   2462: putfield rotationPointX : F
/*      */     //   2465: aload_0
/*      */     //   2466: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2469: aload_0
/*      */     //   2470: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2473: getfield rotateAngleY : F
/*      */     //   2476: fload #8
/*      */     //   2478: fadd
/*      */     //   2479: putfield rotateAngleY : F
/*      */     //   2482: aload_0
/*      */     //   2483: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2486: aload_0
/*      */     //   2487: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2490: aload_0
/*      */     //   2491: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2494: getfield rotationPointZ : F
/*      */     //   2497: aload_0
/*      */     //   2498: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2501: getfield rotateAngleY : F
/*      */     //   2504: f2d
/*      */     //   2505: invokestatic cos : (D)D
/*      */     //   2508: d2f
/*      */     //   2509: ldc 40.0
/*      */     //   2511: fmul
/*      */     //   2512: fadd
/*      */     //   2513: dup_x1
/*      */     //   2514: putfield rotationPointZ : F
/*      */     //   2517: putfield rotationPointZ : F
/*      */     //   2520: aload_0
/*      */     //   2521: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2524: aload_0
/*      */     //   2525: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2528: aload_0
/*      */     //   2529: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2532: getfield rotationPointX : F
/*      */     //   2535: aload_0
/*      */     //   2536: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2539: getfield rotateAngleY : F
/*      */     //   2542: f2d
/*      */     //   2543: invokestatic sin : (D)D
/*      */     //   2546: d2f
/*      */     //   2547: ldc 40.0
/*      */     //   2549: fmul
/*      */     //   2550: fadd
/*      */     //   2551: dup_x1
/*      */     //   2552: putfield rotationPointX : F
/*      */     //   2555: putfield rotationPointX : F
/*      */     //   2558: aload_0
/*      */     //   2559: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2562: aload_0
/*      */     //   2563: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2566: aload_0
/*      */     //   2567: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2570: getfield rotateAngleY : F
/*      */     //   2573: fload #8
/*      */     //   2575: fadd
/*      */     //   2576: dup_x1
/*      */     //   2577: putfield rotateAngleY : F
/*      */     //   2580: putfield rotateAngleY : F
/*      */     //   2583: aload_0
/*      */     //   2584: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2587: aload_0
/*      */     //   2588: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2591: aload_0
/*      */     //   2592: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2595: getfield rotationPointZ : F
/*      */     //   2598: aload_0
/*      */     //   2599: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2602: getfield rotateAngleY : F
/*      */     //   2605: f2d
/*      */     //   2606: invokestatic cos : (D)D
/*      */     //   2609: d2f
/*      */     //   2610: ldc_w 43.0
/*      */     //   2613: fmul
/*      */     //   2614: fadd
/*      */     //   2615: dup_x1
/*      */     //   2616: putfield rotationPointZ : F
/*      */     //   2619: putfield rotationPointZ : F
/*      */     //   2622: aload_0
/*      */     //   2623: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2626: aload_0
/*      */     //   2627: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2630: aload_0
/*      */     //   2631: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2634: getfield rotationPointX : F
/*      */     //   2637: aload_0
/*      */     //   2638: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2641: getfield rotateAngleY : F
/*      */     //   2644: f2d
/*      */     //   2645: invokestatic sin : (D)D
/*      */     //   2648: d2f
/*      */     //   2649: ldc_w 43.0
/*      */     //   2652: fmul
/*      */     //   2653: fadd
/*      */     //   2654: dup_x1
/*      */     //   2655: putfield rotationPointX : F
/*      */     //   2658: putfield rotationPointX : F
/*      */     //   2661: aload_0
/*      */     //   2662: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2665: aload_0
/*      */     //   2666: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2669: aload_0
/*      */     //   2670: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2673: getfield rotateAngleY : F
/*      */     //   2676: fload #8
/*      */     //   2678: fadd
/*      */     //   2679: dup_x1
/*      */     //   2680: putfield rotateAngleY : F
/*      */     //   2683: putfield rotateAngleY : F
/*      */     //   2686: aload_0
/*      */     //   2687: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2690: aload_0
/*      */     //   2691: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2694: getfield rotationPointZ : F
/*      */     //   2697: aload_0
/*      */     //   2698: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2701: getfield rotateAngleY : F
/*      */     //   2704: f2d
/*      */     //   2705: invokestatic cos : (D)D
/*      */     //   2708: d2f
/*      */     //   2709: ldc_w 58.0
/*      */     //   2712: fmul
/*      */     //   2713: fadd
/*      */     //   2714: putfield rotationPointZ : F
/*      */     //   2717: aload_0
/*      */     //   2718: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2721: aload_0
/*      */     //   2722: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2725: getfield rotationPointX : F
/*      */     //   2728: aload_0
/*      */     //   2729: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2732: getfield rotateAngleY : F
/*      */     //   2735: f2d
/*      */     //   2736: invokestatic sin : (D)D
/*      */     //   2739: d2f
/*      */     //   2740: ldc_w 58.0
/*      */     //   2743: fmul
/*      */     //   2744: fadd
/*      */     //   2745: putfield rotationPointX : F
/*      */     //   2748: aload_0
/*      */     //   2749: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2752: aload_0
/*      */     //   2753: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2756: getfield rotateAngleY : F
/*      */     //   2759: fload #8
/*      */     //   2761: fadd
/*      */     //   2762: putfield rotateAngleY : F
/*      */     //   2765: aload #9
/*      */     //   2767: invokevirtual getAttacking : ()I
/*      */     //   2770: ifeq -> 3037
/*      */     //   2773: fload #4
/*      */     //   2775: ldc_w 0.3
/*      */     //   2778: fmul
/*      */     //   2779: aload_0
/*      */     //   2780: getfield wingspeed : F
/*      */     //   2783: fmul
/*      */     //   2784: invokestatic sin : (F)F
/*      */     //   2787: ldc_w 3.1415927
/*      */     //   2790: fmul
/*      */     //   2791: ldc_w 0.25
/*      */     //   2794: fmul
/*      */     //   2795: fstore #13
/*      */     //   2797: fload #4
/*      */     //   2799: ldc_w 0.2
/*      */     //   2802: fmul
/*      */     //   2803: aload_0
/*      */     //   2804: getfield wingspeed : F
/*      */     //   2807: fmul
/*      */     //   2808: invokestatic sin : (F)F
/*      */     //   2811: ldc_w 3.1415927
/*      */     //   2814: fmul
/*      */     //   2815: ldc_w 0.25
/*      */     //   2818: fmul
/*      */     //   2819: fstore #14
/*      */     //   2821: fload #4
/*      */     //   2823: ldc_w 0.85
/*      */     //   2826: fmul
/*      */     //   2827: aload_0
/*      */     //   2828: getfield wingspeed : F
/*      */     //   2831: fmul
/*      */     //   2832: invokestatic sin : (F)F
/*      */     //   2835: ldc_w 3.1415927
/*      */     //   2838: fmul
/*      */     //   2839: ldc_w 0.12
/*      */     //   2842: fmul
/*      */     //   2843: fstore #15
/*      */     //   2845: fload #4
/*      */     //   2847: ldc_w 0.33
/*      */     //   2850: fmul
/*      */     //   2851: aload_0
/*      */     //   2852: getfield wingspeed : F
/*      */     //   2855: fmul
/*      */     //   2856: invokestatic sin : (F)F
/*      */     //   2859: ldc_w 3.1415927
/*      */     //   2862: fmul
/*      */     //   2863: ldc_w 0.25
/*      */     //   2866: fmul
/*      */     //   2867: fstore #19
/*      */     //   2869: fload #4
/*      */     //   2871: ldc_w 0.22
/*      */     //   2874: fmul
/*      */     //   2875: aload_0
/*      */     //   2876: getfield wingspeed : F
/*      */     //   2879: fmul
/*      */     //   2880: invokestatic sin : (F)F
/*      */     //   2883: ldc_w 3.1415927
/*      */     //   2886: fmul
/*      */     //   2887: ldc_w 0.25
/*      */     //   2890: fmul
/*      */     //   2891: fstore #20
/*      */     //   2893: fload #4
/*      */     //   2895: ldc_w 0.95
/*      */     //   2898: fmul
/*      */     //   2899: aload_0
/*      */     //   2900: getfield wingspeed : F
/*      */     //   2903: fmul
/*      */     //   2904: invokestatic sin : (F)F
/*      */     //   2907: ldc_w 3.1415927
/*      */     //   2910: fmul
/*      */     //   2911: ldc_w 0.12
/*      */     //   2914: fmul
/*      */     //   2915: fstore #21
/*      */     //   2917: fload #4
/*      */     //   2919: ldc_w 0.27
/*      */     //   2922: fmul
/*      */     //   2923: aload_0
/*      */     //   2924: getfield wingspeed : F
/*      */     //   2927: fmul
/*      */     //   2928: invokestatic sin : (F)F
/*      */     //   2931: ldc_w 3.1415927
/*      */     //   2934: fmul
/*      */     //   2935: ldc_w 0.25
/*      */     //   2938: fmul
/*      */     //   2939: fstore #16
/*      */     //   2941: fload #4
/*      */     //   2943: ldc_w 0.18
/*      */     //   2946: fmul
/*      */     //   2947: aload_0
/*      */     //   2948: getfield wingspeed : F
/*      */     //   2951: fmul
/*      */     //   2952: invokestatic sin : (F)F
/*      */     //   2955: ldc_w 3.1415927
/*      */     //   2958: fmul
/*      */     //   2959: ldc_w 0.25
/*      */     //   2962: fmul
/*      */     //   2963: fstore #17
/*      */     //   2965: fload #4
/*      */     //   2967: ldc_w 0.75
/*      */     //   2970: fmul
/*      */     //   2971: aload_0
/*      */     //   2972: getfield wingspeed : F
/*      */     //   2975: fmul
/*      */     //   2976: invokestatic sin : (F)F
/*      */     //   2979: ldc_w 3.1415927
/*      */     //   2982: fmul
/*      */     //   2983: ldc_w 0.12
/*      */     //   2986: fmul
/*      */     //   2987: fstore #18
/*      */     //   2989: fload #15
/*      */     //   2991: ldc_w 0.5
/*      */     //   2994: fadd
/*      */     //   2995: fstore #15
/*      */     //   2997: fload #15
/*      */     //   2999: fload #14
/*      */     //   3001: fadd
/*      */     //   3002: fstore #15
/*      */     //   3004: fload #18
/*      */     //   3006: ldc_w 0.5
/*      */     //   3009: fadd
/*      */     //   3010: fstore #18
/*      */     //   3012: fload #18
/*      */     //   3014: fload #17
/*      */     //   3016: fadd
/*      */     //   3017: fstore #18
/*      */     //   3019: fload #21
/*      */     //   3021: ldc_w 0.5
/*      */     //   3024: fadd
/*      */     //   3025: fstore #21
/*      */     //   3027: fload #21
/*      */     //   3029: fload #20
/*      */     //   3031: fadd
/*      */     //   3032: fstore #21
/*      */     //   3034: goto -> 3298
/*      */     //   3037: fload #4
/*      */     //   3039: ldc_w 0.17
/*      */     //   3042: fmul
/*      */     //   3043: aload_0
/*      */     //   3044: getfield wingspeed : F
/*      */     //   3047: fmul
/*      */     //   3048: invokestatic sin : (F)F
/*      */     //   3051: ldc_w 3.1415927
/*      */     //   3054: fmul
/*      */     //   3055: ldc_w 0.08
/*      */     //   3058: fmul
/*      */     //   3059: fstore #13
/*      */     //   3061: fload #4
/*      */     //   3063: ldc_w 0.13
/*      */     //   3066: fmul
/*      */     //   3067: aload_0
/*      */     //   3068: getfield wingspeed : F
/*      */     //   3071: fmul
/*      */     //   3072: invokestatic sin : (F)F
/*      */     //   3075: ldc_w 3.1415927
/*      */     //   3078: fmul
/*      */     //   3079: ldc_w 0.1
/*      */     //   3082: fmul
/*      */     //   3083: fstore #14
/*      */     //   3085: fload #4
/*      */     //   3087: ldc_w 0.45
/*      */     //   3090: fmul
/*      */     //   3091: aload_0
/*      */     //   3092: getfield wingspeed : F
/*      */     //   3095: fmul
/*      */     //   3096: invokestatic sin : (F)F
/*      */     //   3099: ldc_w 3.1415927
/*      */     //   3102: fmul
/*      */     //   3103: ldc_w 0.04
/*      */     //   3106: fmul
/*      */     //   3107: fstore #15
/*      */     //   3109: fload #4
/*      */     //   3111: ldc_w 0.19
/*      */     //   3114: fmul
/*      */     //   3115: aload_0
/*      */     //   3116: getfield wingspeed : F
/*      */     //   3119: fmul
/*      */     //   3120: invokestatic sin : (F)F
/*      */     //   3123: ldc_w 3.1415927
/*      */     //   3126: fmul
/*      */     //   3127: ldc_w 0.08
/*      */     //   3130: fmul
/*      */     //   3131: fstore #19
/*      */     //   3133: fload #4
/*      */     //   3135: ldc_w 0.12
/*      */     //   3138: fmul
/*      */     //   3139: aload_0
/*      */     //   3140: getfield wingspeed : F
/*      */     //   3143: fmul
/*      */     //   3144: invokestatic sin : (F)F
/*      */     //   3147: ldc_w 3.1415927
/*      */     //   3150: fmul
/*      */     //   3151: ldc_w 0.1
/*      */     //   3154: fmul
/*      */     //   3155: fstore #20
/*      */     //   3157: fload #4
/*      */     //   3159: ldc_w 0.55
/*      */     //   3162: fmul
/*      */     //   3163: aload_0
/*      */     //   3164: getfield wingspeed : F
/*      */     //   3167: fmul
/*      */     //   3168: invokestatic sin : (F)F
/*      */     //   3171: ldc_w 3.1415927
/*      */     //   3174: fmul
/*      */     //   3175: ldc_w 0.04
/*      */     //   3178: fmul
/*      */     //   3179: fstore #21
/*      */     //   3181: fload #4
/*      */     //   3183: ldc_w 0.13
/*      */     //   3186: fmul
/*      */     //   3187: aload_0
/*      */     //   3188: getfield wingspeed : F
/*      */     //   3191: fmul
/*      */     //   3192: invokestatic sin : (F)F
/*      */     //   3195: ldc_w 3.1415927
/*      */     //   3198: fmul
/*      */     //   3199: ldc_w 0.08
/*      */     //   3202: fmul
/*      */     //   3203: fstore #16
/*      */     //   3205: fload #4
/*      */     //   3207: ldc_w 0.08
/*      */     //   3210: fmul
/*      */     //   3211: aload_0
/*      */     //   3212: getfield wingspeed : F
/*      */     //   3215: fmul
/*      */     //   3216: invokestatic sin : (F)F
/*      */     //   3219: ldc_w 3.1415927
/*      */     //   3222: fmul
/*      */     //   3223: ldc_w 0.1
/*      */     //   3226: fmul
/*      */     //   3227: fstore #17
/*      */     //   3229: fload #4
/*      */     //   3231: ldc_w 0.65
/*      */     //   3234: fmul
/*      */     //   3235: aload_0
/*      */     //   3236: getfield wingspeed : F
/*      */     //   3239: fmul
/*      */     //   3240: invokestatic sin : (F)F
/*      */     //   3243: ldc_w 3.1415927
/*      */     //   3246: fmul
/*      */     //   3247: ldc_w 0.04
/*      */     //   3250: fmul
/*      */     //   3251: fstore #18
/*      */     //   3253: fload #15
/*      */     //   3255: ldc_w 0.25
/*      */     //   3258: fadd
/*      */     //   3259: fstore #15
/*      */     //   3261: fload #15
/*      */     //   3263: fload #14
/*      */     //   3265: fadd
/*      */     //   3266: fstore #15
/*      */     //   3268: fload #18
/*      */     //   3270: ldc_w 0.25
/*      */     //   3273: fadd
/*      */     //   3274: fstore #18
/*      */     //   3276: fload #18
/*      */     //   3278: fload #17
/*      */     //   3280: fadd
/*      */     //   3281: fstore #18
/*      */     //   3283: fload #21
/*      */     //   3285: ldc_w 0.25
/*      */     //   3288: fadd
/*      */     //   3289: fstore #21
/*      */     //   3291: fload #21
/*      */     //   3293: fload #20
/*      */     //   3295: fadd
/*      */     //   3296: fstore #21
/*      */     //   3298: fload #13
/*      */     //   3300: fload #16
/*      */     //   3302: fcmpl
/*      */     //   3303: ifle -> 3310
/*      */     //   3306: fload #16
/*      */     //   3308: fstore #13
/*      */     //   3310: fload #19
/*      */     //   3312: fload #16
/*      */     //   3314: fcmpg
/*      */     //   3315: ifge -> 3322
/*      */     //   3318: fload #16
/*      */     //   3320: fstore #19
/*      */     //   3322: aload_0
/*      */     //   3323: fload #13
/*      */     //   3325: fload #14
/*      */     //   3327: fload #15
/*      */     //   3329: invokespecial moveLeftHead : (FFF)V
/*      */     //   3332: aload_0
/*      */     //   3333: fload #16
/*      */     //   3335: fload #17
/*      */     //   3337: fload #18
/*      */     //   3339: invokespecial moveCenterHead : (FFF)V
/*      */     //   3342: aload_0
/*      */     //   3343: fload #19
/*      */     //   3345: fload #20
/*      */     //   3347: fload #21
/*      */     //   3349: invokespecial moveRightHead : (FFF)V
/*      */     //   3352: aload_0
/*      */     //   3353: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3356: dup
/*      */     //   3357: getfield rotateAngleX : F
/*      */     //   3360: ldc_w 0.03
/*      */     //   3363: fadd
/*      */     //   3364: putfield rotateAngleX : F
/*      */     //   3367: aload_0
/*      */     //   3368: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3371: getfield rotateAngleX : F
/*      */     //   3374: f2d
/*      */     //   3375: ldc2_w 3.141592653589793
/*      */     //   3378: dcmpl
/*      */     //   3379: ifle -> 3399
/*      */     //   3382: aload_0
/*      */     //   3383: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3386: dup
/*      */     //   3387: getfield rotateAngleX : F
/*      */     //   3390: f2d
/*      */     //   3391: ldc2_w 6.283185307179586
/*      */     //   3394: dsub
/*      */     //   3395: d2f
/*      */     //   3396: putfield rotateAngleX : F
/*      */     //   3399: aload_0
/*      */     //   3400: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3403: dup
/*      */     //   3404: getfield rotateAngleX : F
/*      */     //   3407: ldc_w 0.04
/*      */     //   3410: fadd
/*      */     //   3411: putfield rotateAngleX : F
/*      */     //   3414: aload_0
/*      */     //   3415: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3418: getfield rotateAngleX : F
/*      */     //   3421: f2d
/*      */     //   3422: ldc2_w 3.141592653589793
/*      */     //   3425: dcmpl
/*      */     //   3426: ifle -> 3446
/*      */     //   3429: aload_0
/*      */     //   3430: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3433: dup
/*      */     //   3434: getfield rotateAngleX : F
/*      */     //   3437: f2d
/*      */     //   3438: ldc2_w 6.283185307179586
/*      */     //   3441: dsub
/*      */     //   3442: d2f
/*      */     //   3443: putfield rotateAngleX : F
/*      */     //   3446: aload_0
/*      */     //   3447: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3450: dup
/*      */     //   3451: getfield rotateAngleX : F
/*      */     //   3454: ldc_w 0.05
/*      */     //   3457: fadd
/*      */     //   3458: putfield rotateAngleX : F
/*      */     //   3461: aload_0
/*      */     //   3462: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3465: getfield rotateAngleX : F
/*      */     //   3468: f2d
/*      */     //   3469: ldc2_w 3.141592653589793
/*      */     //   3472: dcmpl
/*      */     //   3473: ifle -> 3493
/*      */     //   3476: aload_0
/*      */     //   3477: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3480: dup
/*      */     //   3481: getfield rotateAngleX : F
/*      */     //   3484: f2d
/*      */     //   3485: ldc2_w 6.283185307179586
/*      */     //   3488: dsub
/*      */     //   3489: d2f
/*      */     //   3490: putfield rotateAngleX : F
/*      */     //   3493: aload_0
/*      */     //   3494: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3497: dup
/*      */     //   3498: getfield rotateAngleY : F
/*      */     //   3501: ldc_w 0.035
/*      */     //   3504: fadd
/*      */     //   3505: putfield rotateAngleY : F
/*      */     //   3508: aload_0
/*      */     //   3509: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3512: getfield rotateAngleY : F
/*      */     //   3515: f2d
/*      */     //   3516: ldc2_w 3.141592653589793
/*      */     //   3519: dcmpl
/*      */     //   3520: ifle -> 3540
/*      */     //   3523: aload_0
/*      */     //   3524: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3527: dup
/*      */     //   3528: getfield rotateAngleY : F
/*      */     //   3531: f2d
/*      */     //   3532: ldc2_w 6.283185307179586
/*      */     //   3535: dsub
/*      */     //   3536: d2f
/*      */     //   3537: putfield rotateAngleY : F
/*      */     //   3540: aload_0
/*      */     //   3541: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3544: dup
/*      */     //   3545: getfield rotateAngleY : F
/*      */     //   3548: ldc_w 0.046
/*      */     //   3551: fadd
/*      */     //   3552: putfield rotateAngleY : F
/*      */     //   3555: aload_0
/*      */     //   3556: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3559: getfield rotateAngleY : F
/*      */     //   3562: f2d
/*      */     //   3563: ldc2_w 3.141592653589793
/*      */     //   3566: dcmpl
/*      */     //   3567: ifle -> 3587
/*      */     //   3570: aload_0
/*      */     //   3571: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3574: dup
/*      */     //   3575: getfield rotateAngleY : F
/*      */     //   3578: f2d
/*      */     //   3579: ldc2_w 6.283185307179586
/*      */     //   3582: dsub
/*      */     //   3583: d2f
/*      */     //   3584: putfield rotateAngleY : F
/*      */     //   3587: aload_0
/*      */     //   3588: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3591: dup
/*      */     //   3592: getfield rotateAngleY : F
/*      */     //   3595: ldc_w 0.065
/*      */     //   3598: fadd
/*      */     //   3599: putfield rotateAngleY : F
/*      */     //   3602: aload_0
/*      */     //   3603: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3606: getfield rotateAngleY : F
/*      */     //   3609: f2d
/*      */     //   3610: ldc2_w 3.141592653589793
/*      */     //   3613: dcmpl
/*      */     //   3614: ifle -> 3634
/*      */     //   3617: aload_0
/*      */     //   3618: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3621: dup
/*      */     //   3622: getfield rotateAngleY : F
/*      */     //   3625: f2d
/*      */     //   3626: ldc2_w 6.283185307179586
/*      */     //   3629: dsub
/*      */     //   3630: d2f
/*      */     //   3631: putfield rotateAngleY : F
/*      */     //   3634: aload_0
/*      */     //   3635: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3638: dup
/*      */     //   3639: getfield rotateAngleZ : F
/*      */     //   3642: ldc_w 0.05
/*      */     //   3645: fadd
/*      */     //   3646: putfield rotateAngleZ : F
/*      */     //   3649: aload_0
/*      */     //   3650: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3653: getfield rotateAngleZ : F
/*      */     //   3656: f2d
/*      */     //   3657: ldc2_w 3.141592653589793
/*      */     //   3660: dcmpl
/*      */     //   3661: ifle -> 3681
/*      */     //   3664: aload_0
/*      */     //   3665: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3668: dup
/*      */     //   3669: getfield rotateAngleZ : F
/*      */     //   3672: f2d
/*      */     //   3673: ldc2_w 6.283185307179586
/*      */     //   3676: dsub
/*      */     //   3677: d2f
/*      */     //   3678: putfield rotateAngleZ : F
/*      */     //   3681: aload_0
/*      */     //   3682: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3685: dup
/*      */     //   3686: getfield rotateAngleZ : F
/*      */     //   3689: ldc_w 0.13
/*      */     //   3692: fadd
/*      */     //   3693: putfield rotateAngleZ : F
/*      */     //   3696: aload_0
/*      */     //   3697: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3700: getfield rotateAngleZ : F
/*      */     //   3703: f2d
/*      */     //   3704: ldc2_w 3.141592653589793
/*      */     //   3707: dcmpl
/*      */     //   3708: ifle -> 3728
/*      */     //   3711: aload_0
/*      */     //   3712: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3715: dup
/*      */     //   3716: getfield rotateAngleZ : F
/*      */     //   3719: f2d
/*      */     //   3720: ldc2_w 6.283185307179586
/*      */     //   3723: dsub
/*      */     //   3724: d2f
/*      */     //   3725: putfield rotateAngleZ : F
/*      */     //   3728: aload_0
/*      */     //   3729: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3732: dup
/*      */     //   3733: getfield rotateAngleZ : F
/*      */     //   3736: ldc_w 0.03
/*      */     //   3739: fadd
/*      */     //   3740: putfield rotateAngleZ : F
/*      */     //   3743: aload_0
/*      */     //   3744: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3747: getfield rotateAngleZ : F
/*      */     //   3750: f2d
/*      */     //   3751: ldc2_w 3.141592653589793
/*      */     //   3754: dcmpl
/*      */     //   3755: ifle -> 3775
/*      */     //   3758: aload_0
/*      */     //   3759: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3762: dup
/*      */     //   3763: getfield rotateAngleZ : F
/*      */     //   3766: f2d
/*      */     //   3767: ldc2_w 6.283185307179586
/*      */     //   3770: dsub
/*      */     //   3771: d2f
/*      */     //   3772: putfield rotateAngleZ : F
/*      */     //   3775: aload_0
/*      */     //   3776: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3779: fload #7
/*      */     //   3781: invokevirtual render : (F)V
/*      */     //   3784: aload_0
/*      */     //   3785: getfield LThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3788: fload #7
/*      */     //   3790: invokevirtual render : (F)V
/*      */     //   3793: aload_0
/*      */     //   3794: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3797: fload #7
/*      */     //   3799: invokevirtual render : (F)V
/*      */     //   3802: aload_0
/*      */     //   3803: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3806: fload #7
/*      */     //   3808: invokevirtual render : (F)V
/*      */     //   3811: aload_0
/*      */     //   3812: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3815: fload #7
/*      */     //   3817: invokevirtual render : (F)V
/*      */     //   3820: aload_0
/*      */     //   3821: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3824: fload #7
/*      */     //   3826: invokevirtual render : (F)V
/*      */     //   3829: aload_0
/*      */     //   3830: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3833: fload #7
/*      */     //   3835: invokevirtual render : (F)V
/*      */     //   3838: aload_0
/*      */     //   3839: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3842: fload #7
/*      */     //   3844: invokevirtual render : (F)V
/*      */     //   3847: aload_0
/*      */     //   3848: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3851: fload #7
/*      */     //   3853: invokevirtual render : (F)V
/*      */     //   3856: aload_0
/*      */     //   3857: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3860: fload #7
/*      */     //   3862: invokevirtual render : (F)V
/*      */     //   3865: aload_0
/*      */     //   3866: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3869: fload #7
/*      */     //   3871: invokevirtual render : (F)V
/*      */     //   3874: aload_0
/*      */     //   3875: getfield Body1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3878: fload #7
/*      */     //   3880: invokevirtual render : (F)V
/*      */     //   3883: aload_0
/*      */     //   3884: getfield NeckC1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3887: fload #7
/*      */     //   3889: invokevirtual render : (F)V
/*      */     //   3892: aload_0
/*      */     //   3893: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3896: fload #7
/*      */     //   3898: invokevirtual render : (F)V
/*      */     //   3901: aload_0
/*      */     //   3902: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3905: fload #7
/*      */     //   3907: invokevirtual render : (F)V
/*      */     //   3910: aload_0
/*      */     //   3911: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3914: fload #7
/*      */     //   3916: invokevirtual render : (F)V
/*      */     //   3919: aload_0
/*      */     //   3920: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3923: fload #7
/*      */     //   3925: invokevirtual render : (F)V
/*      */     //   3928: aload_0
/*      */     //   3929: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3932: fload #7
/*      */     //   3934: invokevirtual render : (F)V
/*      */     //   3937: aload_0
/*      */     //   3938: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3941: fload #7
/*      */     //   3943: invokevirtual render : (F)V
/*      */     //   3946: aload_0
/*      */     //   3947: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3950: fload #7
/*      */     //   3952: invokevirtual render : (F)V
/*      */     //   3955: aload_0
/*      */     //   3956: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3959: fload #7
/*      */     //   3961: invokevirtual render : (F)V
/*      */     //   3964: aload_0
/*      */     //   3965: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3968: fload #7
/*      */     //   3970: invokevirtual render : (F)V
/*      */     //   3973: aload_0
/*      */     //   3974: getfield NeckL1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3977: fload #7
/*      */     //   3979: invokevirtual render : (F)V
/*      */     //   3982: aload_0
/*      */     //   3983: getfield NeckR1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3986: fload #7
/*      */     //   3988: invokevirtual render : (F)V
/*      */     //   3991: aload_0
/*      */     //   3992: getfield RThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3995: fload #7
/*      */     //   3997: invokevirtual render : (F)V
/*      */     //   4000: aload_0
/*      */     //   4001: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4004: fload #7
/*      */     //   4006: invokevirtual render : (F)V
/*      */     //   4009: aload_0
/*      */     //   4010: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4013: fload #7
/*      */     //   4015: invokevirtual render : (F)V
/*      */     //   4018: aload_0
/*      */     //   4019: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4022: fload #7
/*      */     //   4024: invokevirtual render : (F)V
/*      */     //   4027: aload_0
/*      */     //   4028: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4031: fload #7
/*      */     //   4033: invokevirtual render : (F)V
/*      */     //   4036: aload_0
/*      */     //   4037: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4040: fload #7
/*      */     //   4042: invokevirtual render : (F)V
/*      */     //   4045: aload_0
/*      */     //   4046: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4049: fload #7
/*      */     //   4051: invokevirtual render : (F)V
/*      */     //   4054: aload_0
/*      */     //   4055: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4058: fload #7
/*      */     //   4060: invokevirtual render : (F)V
/*      */     //   4063: aload_0
/*      */     //   4064: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4067: fload #7
/*      */     //   4069: invokevirtual render : (F)V
/*      */     //   4072: aload_0
/*      */     //   4073: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4076: fload #7
/*      */     //   4078: invokevirtual render : (F)V
/*      */     //   4081: aload_0
/*      */     //   4082: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4085: fload #7
/*      */     //   4087: invokevirtual render : (F)V
/*      */     //   4090: aload_0
/*      */     //   4091: getfield NeckL2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4094: fload #7
/*      */     //   4096: invokevirtual render : (F)V
/*      */     //   4099: aload_0
/*      */     //   4100: getfield NeckC2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4103: fload #7
/*      */     //   4105: invokevirtual render : (F)V
/*      */     //   4108: aload_0
/*      */     //   4109: getfield NeckR2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4112: fload #7
/*      */     //   4114: invokevirtual render : (F)V
/*      */     //   4117: aload_0
/*      */     //   4118: getfield NeckL3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4121: fload #7
/*      */     //   4123: invokevirtual render : (F)V
/*      */     //   4126: aload_0
/*      */     //   4127: getfield NeckC3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4130: fload #7
/*      */     //   4132: invokevirtual render : (F)V
/*      */     //   4135: aload_0
/*      */     //   4136: getfield NeckR3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4139: fload #7
/*      */     //   4141: invokevirtual render : (F)V
/*      */     //   4144: aload_0
/*      */     //   4145: getfield NeckL4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4148: fload #7
/*      */     //   4150: invokevirtual render : (F)V
/*      */     //   4153: aload_0
/*      */     //   4154: getfield LHead1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4157: fload #7
/*      */     //   4159: invokevirtual render : (F)V
/*      */     //   4162: aload_0
/*      */     //   4163: getfield LHead2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4166: fload #7
/*      */     //   4168: invokevirtual render : (F)V
/*      */     //   4171: aload_0
/*      */     //   4172: getfield LHead3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4175: fload #7
/*      */     //   4177: invokevirtual render : (F)V
/*      */     //   4180: aload_0
/*      */     //   4181: getfield LJaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4184: fload #7
/*      */     //   4186: invokevirtual render : (F)V
/*      */     //   4189: aload_0
/*      */     //   4190: getfield LJaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4193: fload #7
/*      */     //   4195: invokevirtual render : (F)V
/*      */     //   4198: aload_0
/*      */     //   4199: getfield LJaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4202: fload #7
/*      */     //   4204: invokevirtual render : (F)V
/*      */     //   4207: aload_0
/*      */     //   4208: getfield LTooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4211: fload #7
/*      */     //   4213: invokevirtual render : (F)V
/*      */     //   4216: aload_0
/*      */     //   4217: getfield LTooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4220: fload #7
/*      */     //   4222: invokevirtual render : (F)V
/*      */     //   4225: aload_0
/*      */     //   4226: getfield LTooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4229: fload #7
/*      */     //   4231: invokevirtual render : (F)V
/*      */     //   4234: aload_0
/*      */     //   4235: getfield LTooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4238: fload #7
/*      */     //   4240: invokevirtual render : (F)V
/*      */     //   4243: aload_0
/*      */     //   4244: getfield NeckC4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4247: fload #7
/*      */     //   4249: invokevirtual render : (F)V
/*      */     //   4252: aload_0
/*      */     //   4253: getfield NeckR4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4256: fload #7
/*      */     //   4258: invokevirtual render : (F)V
/*      */     //   4261: aload_0
/*      */     //   4262: getfield CHead1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4265: fload #7
/*      */     //   4267: invokevirtual render : (F)V
/*      */     //   4270: aload_0
/*      */     //   4271: getfield RHead1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4274: fload #7
/*      */     //   4276: invokevirtual render : (F)V
/*      */     //   4279: aload_0
/*      */     //   4280: getfield CHead2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4283: fload #7
/*      */     //   4285: invokevirtual render : (F)V
/*      */     //   4288: aload_0
/*      */     //   4289: getfield RHead2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4292: fload #7
/*      */     //   4294: invokevirtual render : (F)V
/*      */     //   4297: aload_0
/*      */     //   4298: getfield CHead3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4301: fload #7
/*      */     //   4303: invokevirtual render : (F)V
/*      */     //   4306: aload_0
/*      */     //   4307: getfield RHead3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4310: fload #7
/*      */     //   4312: invokevirtual render : (F)V
/*      */     //   4315: aload_0
/*      */     //   4316: getfield CJaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4319: fload #7
/*      */     //   4321: invokevirtual render : (F)V
/*      */     //   4324: aload_0
/*      */     //   4325: getfield CJaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4328: fload #7
/*      */     //   4330: invokevirtual render : (F)V
/*      */     //   4333: aload_0
/*      */     //   4334: getfield CJaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4337: fload #7
/*      */     //   4339: invokevirtual render : (F)V
/*      */     //   4342: aload_0
/*      */     //   4343: getfield RJaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4346: fload #7
/*      */     //   4348: invokevirtual render : (F)V
/*      */     //   4351: aload_0
/*      */     //   4352: getfield RJaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4355: fload #7
/*      */     //   4357: invokevirtual render : (F)V
/*      */     //   4360: aload_0
/*      */     //   4361: getfield RJaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4364: fload #7
/*      */     //   4366: invokevirtual render : (F)V
/*      */     //   4369: aload_0
/*      */     //   4370: getfield CTooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4373: fload #7
/*      */     //   4375: invokevirtual render : (F)V
/*      */     //   4378: aload_0
/*      */     //   4379: getfield CTooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4382: fload #7
/*      */     //   4384: invokevirtual render : (F)V
/*      */     //   4387: aload_0
/*      */     //   4388: getfield CTooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4391: fload #7
/*      */     //   4393: invokevirtual render : (F)V
/*      */     //   4396: aload_0
/*      */     //   4397: getfield CTooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4400: fload #7
/*      */     //   4402: invokevirtual render : (F)V
/*      */     //   4405: aload_0
/*      */     //   4406: getfield RTooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4409: fload #7
/*      */     //   4411: invokevirtual render : (F)V
/*      */     //   4414: aload_0
/*      */     //   4415: getfield RTooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4418: fload #7
/*      */     //   4420: invokevirtual render : (F)V
/*      */     //   4423: aload_0
/*      */     //   4424: getfield RTooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4427: fload #7
/*      */     //   4429: invokevirtual render : (F)V
/*      */     //   4432: aload_0
/*      */     //   4433: getfield RTooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4436: fload #7
/*      */     //   4438: invokevirtual render : (F)V
/*      */     //   4441: aload_0
/*      */     //   4442: getfield LHeadMane : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4445: fload #7
/*      */     //   4447: invokevirtual render : (F)V
/*      */     //   4450: aload_0
/*      */     //   4451: getfield CHeadMane : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4454: fload #7
/*      */     //   4456: invokevirtual render : (F)V
/*      */     //   4459: aload_0
/*      */     //   4460: getfield RHeadMane : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4463: fload #7
/*      */     //   4465: invokevirtual render : (F)V
/*      */     //   4468: aload_0
/*      */     //   4469: getfield LLNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4472: fload #7
/*      */     //   4474: invokevirtual render : (F)V
/*      */     //   4477: aload_0
/*      */     //   4478: getfield LRNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4481: fload #7
/*      */     //   4483: invokevirtual render : (F)V
/*      */     //   4486: aload_0
/*      */     //   4487: getfield CLNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4490: fload #7
/*      */     //   4492: invokevirtual render : (F)V
/*      */     //   4495: aload_0
/*      */     //   4496: getfield CRNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4499: fload #7
/*      */     //   4501: invokevirtual render : (F)V
/*      */     //   4504: aload_0
/*      */     //   4505: getfield RLNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4508: fload #7
/*      */     //   4510: invokevirtual render : (F)V
/*      */     //   4513: aload_0
/*      */     //   4514: getfield RRNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4517: fload #7
/*      */     //   4519: invokevirtual render : (F)V
/*      */     //   4522: aload_0
/*      */     //   4523: getfield Back1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4526: fload #7
/*      */     //   4528: invokevirtual render : (F)V
/*      */     //   4531: aload_0
/*      */     //   4532: getfield Back2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4535: fload #7
/*      */     //   4537: invokevirtual render : (F)V
/*      */     //   4540: aload_0
/*      */     //   4541: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4544: fload #7
/*      */     //   4546: invokevirtual render : (F)V
/*      */     //   4549: aload_0
/*      */     //   4550: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4553: fload #7
/*      */     //   4555: invokevirtual render : (F)V
/*      */     //   4558: aload_0
/*      */     //   4559: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4562: fload #7
/*      */     //   4564: invokevirtual render : (F)V
/*      */     //   4567: aload_0
/*      */     //   4568: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4571: fload #7
/*      */     //   4573: invokevirtual render : (F)V
/*      */     //   4576: aload_0
/*      */     //   4577: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4580: fload #7
/*      */     //   4582: invokevirtual render : (F)V
/*      */     //   4585: aload_0
/*      */     //   4586: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4589: fload #7
/*      */     //   4591: invokevirtual render : (F)V
/*      */     //   4594: aload_0
/*      */     //   4595: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4598: fload #7
/*      */     //   4600: invokevirtual render : (F)V
/*      */     //   4603: aload_0
/*      */     //   4604: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4607: fload #7
/*      */     //   4609: invokevirtual render : (F)V
/*      */     //   4612: aload_0
/*      */     //   4613: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4616: fload #7
/*      */     //   4618: invokevirtual render : (F)V
/*      */     //   4621: aload_0
/*      */     //   4622: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4625: fload #7
/*      */     //   4627: invokevirtual render : (F)V
/*      */     //   4630: aload_0
/*      */     //   4631: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4634: fload #7
/*      */     //   4636: invokevirtual render : (F)V
/*      */     //   4639: aload_0
/*      */     //   4640: getfield Ridge1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4643: fload #7
/*      */     //   4645: invokevirtual render : (F)V
/*      */     //   4648: aload_0
/*      */     //   4649: getfield Ridge2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4652: fload #7
/*      */     //   4654: invokevirtual render : (F)V
/*      */     //   4657: aload_0
/*      */     //   4658: getfield Ridge3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4661: fload #7
/*      */     //   4663: invokevirtual render : (F)V
/*      */     //   4666: aload_0
/*      */     //   4667: getfield Ridge4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4670: fload #7
/*      */     //   4672: invokevirtual render : (F)V
/*      */     //   4675: aload_0
/*      */     //   4676: getfield Ridge5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4679: fload #7
/*      */     //   4681: invokevirtual render : (F)V
/*      */     //   4684: aload_0
/*      */     //   4685: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4688: fload #7
/*      */     //   4690: invokevirtual render : (F)V
/*      */     //   4693: aload_0
/*      */     //   4694: getfield NeckBone1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4697: fload #7
/*      */     //   4699: invokevirtual render : (F)V
/*      */     //   4702: aload_0
/*      */     //   4703: getfield NeckBone2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4706: fload #7
/*      */     //   4708: invokevirtual render : (F)V
/*      */     //   4711: aload_0
/*      */     //   4712: getfield NeckBone3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4715: fload #7
/*      */     //   4717: invokevirtual render : (F)V
/*      */     //   4720: aload_0
/*      */     //   4721: getfield Rib1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4724: fload #7
/*      */     //   4726: invokevirtual render : (F)V
/*      */     //   4729: aload_0
/*      */     //   4730: getfield Rib2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4733: fload #7
/*      */     //   4735: invokevirtual render : (F)V
/*      */     //   4738: aload_0
/*      */     //   4739: getfield Rib3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4742: fload #7
/*      */     //   4744: invokevirtual render : (F)V
/*      */     //   4747: aload_0
/*      */     //   4748: getfield Rib4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4751: fload #7
/*      */     //   4753: invokevirtual render : (F)V
/*      */     //   4756: aload_0
/*      */     //   4757: getfield Rib5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4760: fload #7
/*      */     //   4762: invokevirtual render : (F)V
/*      */     //   4765: aload_0
/*      */     //   4766: getfield Rib6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4769: fload #7
/*      */     //   4771: invokevirtual render : (F)V
/*      */     //   4774: invokestatic glPushMatrix : ()V
/*      */     //   4777: sipush #2977
/*      */     //   4780: invokestatic glEnable : (I)V
/*      */     //   4783: sipush #3042
/*      */     //   4786: invokestatic glEnable : (I)V
/*      */     //   4789: sipush #770
/*      */     //   4792: sipush #771
/*      */     //   4795: invokestatic glBlendFunc : (II)V
/*      */     //   4798: ldc_w 0.75
/*      */     //   4801: ldc_w 0.75
/*      */     //   4804: ldc_w 0.75
/*      */     //   4807: ldc_w 0.55
/*      */     //   4810: invokestatic glColor4f : (FFFF)V
/*      */     //   4813: aload_0
/*      */     //   4814: getfield Lwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4817: fload #7
/*      */     //   4819: invokevirtual render : (F)V
/*      */     //   4822: aload_0
/*      */     //   4823: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4826: fload #7
/*      */     //   4828: invokevirtual render : (F)V
/*      */     //   4831: aload_0
/*      */     //   4832: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4835: fload #7
/*      */     //   4837: invokevirtual render : (F)V
/*      */     //   4840: aload_0
/*      */     //   4841: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4844: fload #7
/*      */     //   4846: invokevirtual render : (F)V
/*      */     //   4849: aload_0
/*      */     //   4850: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4853: fload #7
/*      */     //   4855: invokevirtual render : (F)V
/*      */     //   4858: aload_0
/*      */     //   4859: getfield Rwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4862: fload #7
/*      */     //   4864: invokevirtual render : (F)V
/*      */     //   4867: aload_0
/*      */     //   4868: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4871: fload #7
/*      */     //   4873: invokevirtual render : (F)V
/*      */     //   4876: aload_0
/*      */     //   4877: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4880: fload #7
/*      */     //   4882: invokevirtual render : (F)V
/*      */     //   4885: aload_0
/*      */     //   4886: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4889: fload #7
/*      */     //   4891: invokevirtual render : (F)V
/*      */     //   4894: aload_0
/*      */     //   4895: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4898: fload #7
/*      */     //   4900: invokevirtual render : (F)V
/*      */     //   4903: getstatic net/minecraft/client/renderer/OpenGlHelper.lightmapTexUnit : I
/*      */     //   4906: ldc_w 240.0
/*      */     //   4909: ldc_w 240.0
/*      */     //   4912: invokestatic setLightmapTextureCoords : (IFF)V
/*      */     //   4915: aload_0
/*      */     //   4916: getfield PowerCube1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4919: fload #7
/*      */     //   4921: invokevirtual render : (F)V
/*      */     //   4924: aload #9
/*      */     //   4926: invokevirtual getPower : ()I
/*      */     //   4929: sipush #350
/*      */     //   4932: if_icmple -> 4944
/*      */     //   4935: aload_0
/*      */     //   4936: getfield PowerCube2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4939: fload #7
/*      */     //   4941: invokevirtual render : (F)V
/*      */     //   4944: aload #9
/*      */     //   4946: invokevirtual getPower : ()I
/*      */     //   4949: sipush #650
/*      */     //   4952: if_icmple -> 4964
/*      */     //   4955: aload_0
/*      */     //   4956: getfield PowerCube3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4959: fload #7
/*      */     //   4961: invokevirtual render : (F)V
/*      */     //   4964: fconst_1
/*      */     //   4965: fconst_1
/*      */     //   4966: fconst_1
/*      */     //   4967: fconst_1
/*      */     //   4968: invokestatic glColor4f : (FFFF)V
/*      */     //   4971: sipush #3042
/*      */     //   4974: invokestatic glDisable : (I)V
/*      */     //   4977: aload_0
/*      */     //   4978: getfield LLEye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4981: fload #7
/*      */     //   4983: invokevirtual render : (F)V
/*      */     //   4986: aload_0
/*      */     //   4987: getfield LREye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4990: fload #7
/*      */     //   4992: invokevirtual render : (F)V
/*      */     //   4995: aload_0
/*      */     //   4996: getfield CLEye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4999: fload #7
/*      */     //   5001: invokevirtual render : (F)V
/*      */     //   5004: aload_0
/*      */     //   5005: getfield CREye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   5008: fload #7
/*      */     //   5010: invokevirtual render : (F)V
/*      */     //   5013: aload_0
/*      */     //   5014: getfield RLEye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   5017: fload #7
/*      */     //   5019: invokevirtual render : (F)V
/*      */     //   5022: aload_0
/*      */     //   5023: getfield RREye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   5026: fload #7
/*      */     //   5028: invokevirtual render : (F)V
/*      */     //   5031: invokestatic glPopMatrix : ()V
/*      */     //   5034: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #938	-> 0
/*      */     //   #939	-> 3
/*      */     //   #940	-> 9
/*      */     //   #941	-> 14
/*      */     //   #942	-> 19
/*      */     //   #943	-> 23
/*      */     //   #944	-> 26
/*      */     //   #945	-> 29
/*      */     //   #946	-> 32
/*      */     //   #947	-> 35
/*      */     //   #948	-> 38
/*      */     //   #949	-> 41
/*      */     //   #950	-> 44
/*      */     //   #951	-> 47
/*      */     //   #953	-> 50
/*      */     //   #954	-> 65
/*      */     //   #956	-> 80
/*      */     //   #957	-> 88
/*      */     //   #959	-> 115
/*      */     //   #963	-> 139
/*      */     //   #964	-> 148
/*      */     //   #965	-> 157
/*      */     //   #966	-> 174
/*      */     //   #967	-> 205
/*      */     //   #968	-> 236
/*      */     //   #969	-> 250
/*      */     //   #970	-> 264
/*      */     //   #971	-> 278
/*      */     //   #972	-> 295
/*      */     //   #973	-> 326
/*      */     //   #974	-> 357
/*      */     //   #975	-> 371
/*      */     //   #976	-> 385
/*      */     //   #977	-> 399
/*      */     //   #978	-> 421
/*      */     //   #979	-> 443
/*      */     //   #980	-> 465
/*      */     //   #981	-> 487
/*      */     //   #982	-> 513
/*      */     //   #984	-> 539
/*      */     //   #985	-> 549
/*      */     //   #986	-> 559
/*      */     //   #987	-> 577
/*      */     //   #988	-> 608
/*      */     //   #989	-> 639
/*      */     //   #990	-> 653
/*      */     //   #991	-> 667
/*      */     //   #992	-> 681
/*      */     //   #993	-> 699
/*      */     //   #994	-> 730
/*      */     //   #995	-> 761
/*      */     //   #996	-> 775
/*      */     //   #997	-> 789
/*      */     //   #998	-> 803
/*      */     //   #999	-> 825
/*      */     //   #1000	-> 847
/*      */     //   #1001	-> 869
/*      */     //   #1002	-> 891
/*      */     //   #1003	-> 917
/*      */     //   #1005	-> 943
/*      */     //   #1006	-> 951
/*      */     //   #1008	-> 978
/*      */     //   #1011	-> 981
/*      */     //   #1013	-> 1002
/*      */     //   #1014	-> 1015
/*      */     //   #1015	-> 1028
/*      */     //   #1016	-> 1041
/*      */     //   #1017	-> 1054
/*      */     //   #1018	-> 1067
/*      */     //   #1020	-> 1080
/*      */     //   #1021	-> 1093
/*      */     //   #1022	-> 1106
/*      */     //   #1023	-> 1119
/*      */     //   #1024	-> 1132
/*      */     //   #1025	-> 1145
/*      */     //   #1027	-> 1158
/*      */     //   #1028	-> 1166
/*      */     //   #1030	-> 1193
/*      */     //   #1033	-> 1196
/*      */     //   #1034	-> 1221
/*      */     //   #1035	-> 1244
/*      */     //   #1036	-> 1283
/*      */     //   #1037	-> 1322
/*      */     //   #1038	-> 1365
/*      */     //   #1039	-> 1408
/*      */     //   #1040	-> 1430
/*      */     //   #1041	-> 1452
/*      */     //   #1042	-> 1474
/*      */     //   #1043	-> 1496
/*      */     //   #1044	-> 1531
/*      */     //   #1046	-> 1566
/*      */     //   #1047	-> 1591
/*      */     //   #1048	-> 1614
/*      */     //   #1049	-> 1653
/*      */     //   #1050	-> 1692
/*      */     //   #1051	-> 1735
/*      */     //   #1052	-> 1778
/*      */     //   #1053	-> 1800
/*      */     //   #1054	-> 1822
/*      */     //   #1055	-> 1844
/*      */     //   #1056	-> 1866
/*      */     //   #1057	-> 1901
/*      */     //   #1060	-> 1936
/*      */     //   #1061	-> 1944
/*      */     //   #1062	-> 1949
/*      */     //   #1065	-> 1954
/*      */     //   #1066	-> 1983
/*      */     //   #1068	-> 2005
/*      */     //   #1069	-> 2036
/*      */     //   #1070	-> 2069
/*      */     //   #1072	-> 2099
/*      */     //   #1073	-> 2130
/*      */     //   #1074	-> 2161
/*      */     //   #1076	-> 2193
/*      */     //   #1077	-> 2224
/*      */     //   #1078	-> 2255
/*      */     //   #1080	-> 2289
/*      */     //   #1081	-> 2318
/*      */     //   #1082	-> 2324
/*      */     //   #1083	-> 2355
/*      */     //   #1084	-> 2386
/*      */     //   #1086	-> 2403
/*      */     //   #1087	-> 2434
/*      */     //   #1088	-> 2465
/*      */     //   #1090	-> 2482
/*      */     //   #1091	-> 2520
/*      */     //   #1092	-> 2558
/*      */     //   #1094	-> 2583
/*      */     //   #1095	-> 2622
/*      */     //   #1096	-> 2661
/*      */     //   #1098	-> 2686
/*      */     //   #1099	-> 2717
/*      */     //   #1100	-> 2748
/*      */     //   #1104	-> 2765
/*      */     //   #1105	-> 2773
/*      */     //   #1106	-> 2797
/*      */     //   #1107	-> 2821
/*      */     //   #1109	-> 2845
/*      */     //   #1110	-> 2869
/*      */     //   #1111	-> 2893
/*      */     //   #1113	-> 2917
/*      */     //   #1114	-> 2941
/*      */     //   #1115	-> 2965
/*      */     //   #1117	-> 2989
/*      */     //   #1118	-> 2997
/*      */     //   #1119	-> 3004
/*      */     //   #1120	-> 3012
/*      */     //   #1121	-> 3019
/*      */     //   #1122	-> 3027
/*      */     //   #1124	-> 3037
/*      */     //   #1125	-> 3061
/*      */     //   #1126	-> 3085
/*      */     //   #1128	-> 3109
/*      */     //   #1129	-> 3133
/*      */     //   #1130	-> 3157
/*      */     //   #1132	-> 3181
/*      */     //   #1133	-> 3205
/*      */     //   #1134	-> 3229
/*      */     //   #1136	-> 3253
/*      */     //   #1137	-> 3261
/*      */     //   #1138	-> 3268
/*      */     //   #1139	-> 3276
/*      */     //   #1140	-> 3283
/*      */     //   #1141	-> 3291
/*      */     //   #1145	-> 3298
/*      */     //   #1146	-> 3310
/*      */     //   #1149	-> 3322
/*      */     //   #1150	-> 3332
/*      */     //   #1151	-> 3342
/*      */     //   #1153	-> 3352
/*      */     //   #1154	-> 3367
/*      */     //   #1155	-> 3399
/*      */     //   #1156	-> 3414
/*      */     //   #1157	-> 3446
/*      */     //   #1158	-> 3461
/*      */     //   #1160	-> 3493
/*      */     //   #1161	-> 3508
/*      */     //   #1162	-> 3540
/*      */     //   #1163	-> 3555
/*      */     //   #1164	-> 3587
/*      */     //   #1165	-> 3602
/*      */     //   #1167	-> 3634
/*      */     //   #1168	-> 3649
/*      */     //   #1169	-> 3681
/*      */     //   #1170	-> 3696
/*      */     //   #1171	-> 3728
/*      */     //   #1172	-> 3743
/*      */     //   #1176	-> 3775
/*      */     //   #1177	-> 3784
/*      */     //   #1178	-> 3793
/*      */     //   #1179	-> 3802
/*      */     //   #1180	-> 3811
/*      */     //   #1181	-> 3820
/*      */     //   #1182	-> 3829
/*      */     //   #1183	-> 3838
/*      */     //   #1184	-> 3847
/*      */     //   #1185	-> 3856
/*      */     //   #1186	-> 3865
/*      */     //   #1187	-> 3874
/*      */     //   #1189	-> 3883
/*      */     //   #1190	-> 3892
/*      */     //   #1191	-> 3901
/*      */     //   #1192	-> 3910
/*      */     //   #1193	-> 3919
/*      */     //   #1194	-> 3928
/*      */     //   #1195	-> 3937
/*      */     //   #1196	-> 3946
/*      */     //   #1197	-> 3955
/*      */     //   #1198	-> 3964
/*      */     //   #1199	-> 3973
/*      */     //   #1200	-> 3982
/*      */     //   #1201	-> 3991
/*      */     //   #1202	-> 4000
/*      */     //   #1203	-> 4009
/*      */     //   #1204	-> 4018
/*      */     //   #1205	-> 4027
/*      */     //   #1206	-> 4036
/*      */     //   #1207	-> 4045
/*      */     //   #1208	-> 4054
/*      */     //   #1209	-> 4063
/*      */     //   #1210	-> 4072
/*      */     //   #1211	-> 4081
/*      */     //   #1212	-> 4090
/*      */     //   #1213	-> 4099
/*      */     //   #1214	-> 4108
/*      */     //   #1215	-> 4117
/*      */     //   #1216	-> 4126
/*      */     //   #1217	-> 4135
/*      */     //   #1218	-> 4144
/*      */     //   #1219	-> 4153
/*      */     //   #1220	-> 4162
/*      */     //   #1221	-> 4171
/*      */     //   #1222	-> 4180
/*      */     //   #1223	-> 4189
/*      */     //   #1224	-> 4198
/*      */     //   #1225	-> 4207
/*      */     //   #1226	-> 4216
/*      */     //   #1227	-> 4225
/*      */     //   #1228	-> 4234
/*      */     //   #1229	-> 4243
/*      */     //   #1230	-> 4252
/*      */     //   #1231	-> 4261
/*      */     //   #1232	-> 4270
/*      */     //   #1233	-> 4279
/*      */     //   #1234	-> 4288
/*      */     //   #1235	-> 4297
/*      */     //   #1236	-> 4306
/*      */     //   #1237	-> 4315
/*      */     //   #1238	-> 4324
/*      */     //   #1239	-> 4333
/*      */     //   #1240	-> 4342
/*      */     //   #1241	-> 4351
/*      */     //   #1242	-> 4360
/*      */     //   #1243	-> 4369
/*      */     //   #1244	-> 4378
/*      */     //   #1245	-> 4387
/*      */     //   #1246	-> 4396
/*      */     //   #1247	-> 4405
/*      */     //   #1248	-> 4414
/*      */     //   #1249	-> 4423
/*      */     //   #1250	-> 4432
/*      */     //   #1252	-> 4441
/*      */     //   #1253	-> 4450
/*      */     //   #1254	-> 4459
/*      */     //   #1255	-> 4468
/*      */     //   #1256	-> 4477
/*      */     //   #1257	-> 4486
/*      */     //   #1258	-> 4495
/*      */     //   #1259	-> 4504
/*      */     //   #1260	-> 4513
/*      */     //   #1261	-> 4522
/*      */     //   #1262	-> 4531
/*      */     //   #1263	-> 4540
/*      */     //   #1264	-> 4549
/*      */     //   #1265	-> 4558
/*      */     //   #1266	-> 4567
/*      */     //   #1267	-> 4576
/*      */     //   #1268	-> 4585
/*      */     //   #1269	-> 4594
/*      */     //   #1270	-> 4603
/*      */     //   #1271	-> 4612
/*      */     //   #1272	-> 4621
/*      */     //   #1273	-> 4630
/*      */     //   #1274	-> 4639
/*      */     //   #1275	-> 4648
/*      */     //   #1276	-> 4657
/*      */     //   #1277	-> 4666
/*      */     //   #1278	-> 4675
/*      */     //   #1279	-> 4684
/*      */     //   #1280	-> 4693
/*      */     //   #1281	-> 4702
/*      */     //   #1282	-> 4711
/*      */     //   #1284	-> 4720
/*      */     //   #1285	-> 4729
/*      */     //   #1286	-> 4738
/*      */     //   #1287	-> 4747
/*      */     //   #1288	-> 4756
/*      */     //   #1289	-> 4765
/*      */     //   #1292	-> 4774
/*      */     //   #1293	-> 4777
/*      */     //   #1294	-> 4783
/*      */     //   #1295	-> 4789
/*      */     //   #1297	-> 4798
/*      */     //   #1298	-> 4813
/*      */     //   #1299	-> 4822
/*      */     //   #1300	-> 4831
/*      */     //   #1301	-> 4840
/*      */     //   #1302	-> 4849
/*      */     //   #1303	-> 4858
/*      */     //   #1304	-> 4867
/*      */     //   #1305	-> 4876
/*      */     //   #1306	-> 4885
/*      */     //   #1307	-> 4894
/*      */     //   #1309	-> 4903
/*      */     //   #1310	-> 4915
/*      */     //   #1311	-> 4924
/*      */     //   #1312	-> 4944
/*      */     //   #1313	-> 4964
/*      */     //   #1314	-> 4971
/*      */     //   #1315	-> 4977
/*      */     //   #1316	-> 4986
/*      */     //   #1317	-> 4995
/*      */     //   #1318	-> 5004
/*      */     //   #1319	-> 5013
/*      */     //   #1320	-> 5022
/*      */     //   #1322	-> 5031
/*      */     //   #1325	-> 5034
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   0	5035	0	this	Ldanger/orespawn/ModelTheQueen;
/*      */     //   0	5035	1	entity	Lnet/minecraft/entity/Entity;
/*      */     //   0	5035	2	f	F
/*      */     //   0	5035	3	f1	F
/*      */     //   0	5035	4	f2	F
/*      */     //   0	5035	5	f3	F
/*      */     //   0	5035	6	f4	F
/*      */     //   0	5035	7	f5	F
/*      */     //   3	5032	8	newangle	F
/*      */     //   9	5026	9	k	Ldanger/orespawn/TheQueen;
/*      */     //   14	5021	10	tailspeed	F
/*      */     //   19	5016	11	tailamp	F
/*      */     //   23	5012	12	pi4	F
/*      */     //   26	5009	13	Lheadlr	F
/*      */     //   29	5006	14	Lheadud	F
/*      */     //   32	5003	15	Ljawangle	F
/*      */     //   35	5000	16	Cheadlr	F
/*      */     //   38	4997	17	Cheadud	F
/*      */     //   41	4994	18	Cjawangle	F
/*      */     //   44	4991	19	Rheadlr	F
/*      */     //   47	4988	20	Rheadud	F
/*      */     //   50	4985	21	Rjawangle	F
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 1329 */     model.rotateAngleX = x;
/* 1330 */     model.rotateAngleY = y;
/* 1331 */     model.rotateAngleZ = z;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 1336 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveLeftHead(float Lheadlr, float Lheadud, float Ljawangle) {
/* 1344 */     this.LJaw1.rotateAngleX = Ljawangle;
/* 1345 */     this.LJaw2.rotateAngleX = Ljawangle;
/* 1346 */     this.LJaw3.rotateAngleX = Ljawangle;
/* 1347 */     this.LTooth1.rotateAngleX = Ljawangle;
/* 1348 */     this.LTooth2.rotateAngleX = Ljawangle;
/* 1349 */     this.LTooth3.rotateAngleX = Ljawangle;
/* 1350 */     this.LTooth4.rotateAngleX = Ljawangle;
/*      */ 
/*      */ 
/*      */     
/* 1354 */     this.NeckL1.rotateAngleY = Lheadlr * 0.125F;
/* 1355 */     this.NeckL1.rotationPointZ -= (float)Math.cos(this.NeckL1.rotateAngleY) * 20.0F;
/* 1356 */     this.NeckL1.rotationPointX -= (float)Math.sin(this.NeckL1.rotateAngleY) * 20.0F;
/* 1357 */     this.NeckL2.rotateAngleY = Lheadlr * 0.25F;
/* 1358 */     this.NeckL2.rotationPointZ -= (float)Math.cos(this.NeckL2.rotateAngleY) * 36.0F;
/* 1359 */     this.NeckL2.rotationPointX -= (float)Math.sin(this.NeckL2.rotateAngleY) * 36.0F;
/* 1360 */     this.NeckL3.rotateAngleY = Lheadlr * 0.38F;
/* 1361 */     this.NeckL3.rotationPointZ -= (float)Math.cos(this.NeckL3.rotateAngleY) * 36.0F;
/* 1362 */     this.NeckL3.rotationPointX -= (float)Math.sin(this.NeckL3.rotateAngleY) * 36.0F;
/* 1363 */     this.NeckL4.rotateAngleY = Lheadlr * 0.5F;
/* 1364 */     this.NeckL4.rotationPointZ -= (float)Math.cos(this.NeckL4.rotateAngleY) * 36.0F;
/* 1365 */     this.NeckL4.rotationPointX -= (float)Math.sin(this.NeckL4.rotateAngleY) * 36.0F;
/* 1366 */     this.LHead1.rotateAngleY = Lheadlr;
/*      */     
/* 1368 */     this.LHead2.rotateAngleY = Lheadlr;
/* 1369 */     this.LHead2.rotationPointZ = this.LHead1.rotationPointZ;
/* 1370 */     this.LHead2.rotationPointX = this.LHead1.rotationPointX;
/* 1371 */     this.LHead3.rotateAngleY = Lheadlr;
/* 1372 */     this.LHead3.rotationPointZ = this.LHead1.rotationPointZ;
/* 1373 */     this.LHead3.rotationPointX = this.LHead1.rotationPointX;
/* 1374 */     this.LHeadMane.rotateAngleY = Lheadlr;
/* 1375 */     this.LHeadMane.rotationPointZ = this.LHead1.rotationPointZ;
/* 1376 */     this.LHeadMane.rotationPointX = this.LHead1.rotationPointX;
/* 1377 */     this.LLEye.rotateAngleY = Lheadlr;
/* 1378 */     this.LLEye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1379 */     this.LLEye.rotationPointX = this.LHead1.rotationPointX;
/* 1380 */     this.LREye.rotateAngleY = Lheadlr;
/* 1381 */     this.LREye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1382 */     this.LREye.rotationPointX = this.LHead1.rotationPointX;
/* 1383 */     this.LLNoseSpike.rotateAngleY = 0.244F + Lheadlr;
/* 1384 */     this.LLNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1385 */     this.LLNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/* 1386 */     this.LRNoseSpike.rotateAngleY = -0.261F + Lheadlr;
/* 1387 */     this.LRNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1388 */     this.LRNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/*      */ 
/*      */     
/* 1391 */     this.LJaw1.rotateAngleY = Lheadlr;
/* 1392 */     this.NeckL4.rotationPointZ -= (float)Math.cos(this.NeckL4.rotateAngleY) * 37.0F;
/* 1393 */     this.NeckL4.rotationPointX -= (float)Math.sin(this.NeckL4.rotateAngleY) * 37.0F;
/*      */     
/* 1395 */     this.LJaw2.rotateAngleY = Lheadlr;
/* 1396 */     this.LJaw2.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1397 */     this.LJaw2.rotationPointX = this.LJaw1.rotationPointX;
/* 1398 */     this.LJaw3.rotateAngleY = Lheadlr;
/* 1399 */     this.LJaw3.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1400 */     this.LJaw3.rotationPointX = this.LJaw1.rotationPointX;
/* 1401 */     this.LTooth1.rotateAngleY = Lheadlr;
/* 1402 */     this.LTooth1.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1403 */     this.LTooth1.rotationPointX = this.LJaw1.rotationPointX;
/* 1404 */     this.LTooth2.rotateAngleY = Lheadlr;
/* 1405 */     this.LTooth2.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1406 */     this.LTooth2.rotationPointX = this.LJaw1.rotationPointX;
/* 1407 */     this.LTooth3.rotateAngleY = Lheadlr;
/* 1408 */     this.LTooth3.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1409 */     this.LTooth3.rotationPointX = this.LJaw1.rotationPointX;
/* 1410 */     this.LTooth4.rotateAngleY = Lheadlr;
/* 1411 */     this.LTooth4.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1412 */     this.LTooth4.rotationPointX = this.LJaw1.rotationPointX;
/*      */ 
/*      */ 
/*      */     
/* 1416 */     this.NeckL1.rotateAngleX = Lheadud * 0.125F;
/* 1417 */     this.NeckL1.rotationPointY += (float)Math.sin(this.NeckL1.rotateAngleX) * 20.0F;
/* 1418 */     this.NeckL1.rotationPointZ += (this.NeckL2.rotationPointZ - this.NeckL1.rotationPointZ) * (float)Math.cos(this.NeckL1.rotateAngleX);
/* 1419 */     this.NeckL1.rotationPointX += (this.NeckL2.rotationPointX - this.NeckL1.rotationPointX) * (float)Math.cos(this.NeckL1.rotateAngleX);
/* 1420 */     this.NeckL2.rotateAngleX = Lheadud * 0.25F;
/* 1421 */     this.NeckL2.rotationPointY += (float)Math.sin(this.NeckL2.rotateAngleX) * 36.0F;
/* 1422 */     this.NeckL2.rotationPointZ += (this.NeckL3.rotationPointZ - this.NeckL2.rotationPointZ) * (float)Math.cos(this.NeckL2.rotateAngleX);
/* 1423 */     this.NeckL2.rotationPointX += (this.NeckL3.rotationPointX - this.NeckL2.rotationPointX) * (float)Math.cos(this.NeckL2.rotateAngleX);
/* 1424 */     this.NeckL3.rotateAngleX = Lheadud * 0.38F;
/* 1425 */     this.NeckL3.rotationPointY += (float)Math.sin(this.NeckL3.rotateAngleX) * 36.0F;
/* 1426 */     this.NeckL3.rotationPointZ += (this.NeckL4.rotationPointZ - this.NeckL3.rotationPointZ) * (float)Math.cos(this.NeckL3.rotateAngleX);
/* 1427 */     this.NeckL3.rotationPointX += (this.NeckL4.rotationPointX - this.NeckL3.rotationPointX) * (float)Math.cos(this.NeckL3.rotateAngleX);
/* 1428 */     this.NeckL4.rotateAngleX = Lheadud * 0.5F;
/* 1429 */     this.NeckL4.rotationPointY += (float)Math.sin(this.NeckL4.rotateAngleX) * 36.0F;
/* 1430 */     this.NeckL4.rotationPointZ += (this.LHead1.rotationPointZ - this.NeckL4.rotationPointZ) * (float)Math.cos(this.NeckL4.rotateAngleX);
/* 1431 */     this.NeckL4.rotationPointX += (this.LHead1.rotationPointX - this.NeckL4.rotationPointX) * (float)Math.cos(this.NeckL4.rotateAngleX);
/* 1432 */     this.LHead1.rotateAngleX = Lheadud;
/*      */     
/* 1434 */     this.LHead2.rotateAngleX = Lheadud;
/* 1435 */     this.LHead2.rotationPointZ = this.LHead1.rotationPointZ;
/* 1436 */     this.LHead2.rotationPointX = this.LHead1.rotationPointX;
/* 1437 */     this.LHead2.rotationPointY = this.LHead1.rotationPointY;
/* 1438 */     this.LHead3.rotateAngleX = Lheadud;
/* 1439 */     this.LHead3.rotationPointZ = this.LHead1.rotationPointZ;
/* 1440 */     this.LHead3.rotationPointX = this.LHead1.rotationPointX;
/* 1441 */     this.LHead3.rotationPointY = this.LHead1.rotationPointY;
/* 1442 */     this.LHeadMane.rotateAngleX = 0.384F + Lheadud;
/* 1443 */     this.LHeadMane.rotationPointZ = this.LHead1.rotationPointZ;
/* 1444 */     this.LHeadMane.rotationPointX = this.LHead1.rotationPointX;
/* 1445 */     this.LHeadMane.rotationPointY = this.LHead1.rotationPointY;
/* 1446 */     this.LLEye.rotateAngleX = Lheadud;
/* 1447 */     this.LLEye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1448 */     this.LLEye.rotationPointX = this.LHead1.rotationPointX;
/* 1449 */     this.LLEye.rotationPointY = this.LHead1.rotationPointY;
/* 1450 */     this.LREye.rotateAngleX = Lheadud;
/* 1451 */     this.LREye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1452 */     this.LREye.rotationPointX = this.LHead1.rotationPointX;
/* 1453 */     this.LREye.rotationPointY = this.LHead1.rotationPointY;
/* 1454 */     this.LLNoseSpike.rotateAngleX = 0.244F + Lheadud;
/* 1455 */     this.LLNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1456 */     this.LLNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/* 1457 */     this.LLNoseSpike.rotationPointY = this.LHead1.rotationPointY;
/* 1458 */     this.LRNoseSpike.rotateAngleX = 0.261F + Lheadud;
/* 1459 */     this.LRNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1460 */     this.LRNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/* 1461 */     this.LRNoseSpike.rotationPointY = this.LHead1.rotationPointY;
/*      */ 
/*      */     
/* 1464 */     this.LHead1.rotationPointY += (float)Math.cos(this.LHead1.rotateAngleX) * 14.0F;
/* 1465 */     this.NeckL4.rotationPointZ += (this.LJaw1.rotationPointZ - this.NeckL4.rotationPointZ) * (float)Math.cos(this.NeckL4.rotateAngleX);
/* 1466 */     this.LJaw1.rotationPointZ += (float)Math.sin(this.LHead1.rotateAngleX) * 14.0F;
/* 1467 */     this.NeckL4.rotationPointX += (this.LJaw1.rotationPointX - this.NeckL4.rotationPointX) * (float)Math.cos(this.NeckL4.rotateAngleX);
/*      */     
/* 1469 */     this.LJaw2.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1470 */     this.LJaw2.rotationPointX = this.LJaw1.rotationPointX;
/* 1471 */     this.LJaw2.rotationPointY = this.LJaw1.rotationPointY;
/* 1472 */     this.LJaw3.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1473 */     this.LJaw3.rotationPointX = this.LJaw1.rotationPointX;
/* 1474 */     this.LJaw3.rotationPointY = this.LJaw1.rotationPointY;
/* 1475 */     this.LTooth1.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1476 */     this.LTooth1.rotationPointX = this.LJaw1.rotationPointX;
/* 1477 */     this.LTooth1.rotationPointY = this.LJaw1.rotationPointY;
/* 1478 */     this.LTooth2.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1479 */     this.LTooth2.rotationPointX = this.LJaw1.rotationPointX;
/* 1480 */     this.LTooth2.rotationPointY = this.LJaw1.rotationPointY;
/* 1481 */     this.LTooth3.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1482 */     this.LTooth3.rotationPointX = this.LJaw1.rotationPointX;
/* 1483 */     this.LTooth3.rotationPointY = this.LJaw1.rotationPointY;
/* 1484 */     this.LTooth4.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1485 */     this.LTooth4.rotationPointX = this.LJaw1.rotationPointX;
/* 1486 */     this.LTooth4.rotationPointY = this.LJaw1.rotationPointY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveCenterHead(float Cheadlr, float Cheadud, float Cjawangle) {
/* 1494 */     this.CJaw1.rotateAngleX = Cjawangle;
/* 1495 */     this.CJaw2.rotateAngleX = Cjawangle;
/* 1496 */     this.CJaw3.rotateAngleX = Cjawangle;
/* 1497 */     this.CTooth1.rotateAngleX = Cjawangle;
/* 1498 */     this.CTooth2.rotateAngleX = Cjawangle;
/* 1499 */     this.CTooth3.rotateAngleX = Cjawangle;
/* 1500 */     this.CTooth4.rotateAngleX = Cjawangle;
/*      */ 
/*      */ 
/*      */     
/* 1504 */     this.NeckC1.rotateAngleY = Cheadlr * 0.125F;
/* 1505 */     this.NeckC1.rotationPointZ -= (float)Math.cos(this.NeckC1.rotateAngleY) * 20.0F;
/* 1506 */     this.NeckC1.rotationPointX -= (float)Math.sin(this.NeckC1.rotateAngleY) * 20.0F;
/* 1507 */     this.NeckC2.rotateAngleY = Cheadlr * 0.25F;
/* 1508 */     this.NeckC2.rotationPointZ -= (float)Math.cos(this.NeckC2.rotateAngleY) * 36.0F;
/* 1509 */     this.NeckC2.rotationPointX -= (float)Math.sin(this.NeckC2.rotateAngleY) * 36.0F;
/* 1510 */     this.NeckC3.rotateAngleY = Cheadlr * 0.38F;
/* 1511 */     this.NeckC3.rotationPointZ -= (float)Math.cos(this.NeckC3.rotateAngleY) * 36.0F;
/* 1512 */     this.NeckC3.rotationPointX -= (float)Math.sin(this.NeckC3.rotateAngleY) * 36.0F;
/* 1513 */     this.NeckC4.rotateAngleY = Cheadlr * 0.5F;
/* 1514 */     this.NeckC4.rotationPointZ -= (float)Math.cos(this.NeckC4.rotateAngleY) * 36.0F;
/* 1515 */     this.NeckC4.rotationPointX -= (float)Math.sin(this.NeckC4.rotateAngleY) * 36.0F;
/* 1516 */     this.CHead1.rotateAngleY = Cheadlr;
/*      */     
/* 1518 */     this.CHead2.rotateAngleY = Cheadlr;
/* 1519 */     this.CHead2.rotationPointZ = this.CHead1.rotationPointZ;
/* 1520 */     this.CHead2.rotationPointX = this.CHead1.rotationPointX;
/* 1521 */     this.CHead3.rotateAngleY = Cheadlr;
/* 1522 */     this.CHead3.rotationPointZ = this.CHead1.rotationPointZ;
/* 1523 */     this.CHead3.rotationPointX = this.CHead1.rotationPointX;
/* 1524 */     this.CHeadMane.rotateAngleY = Cheadlr;
/* 1525 */     this.CHeadMane.rotationPointZ = this.CHead1.rotationPointZ;
/* 1526 */     this.CHeadMane.rotationPointX = this.CHead1.rotationPointX;
/* 1527 */     this.CLEye.rotateAngleY = Cheadlr;
/* 1528 */     this.CLEye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1529 */     this.CLEye.rotationPointX = this.CHead1.rotationPointX;
/* 1530 */     this.CREye.rotateAngleY = Cheadlr;
/* 1531 */     this.CREye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1532 */     this.CREye.rotationPointX = this.CHead1.rotationPointX;
/* 1533 */     this.CLNoseSpike.rotateAngleY = 0.244F + Cheadlr;
/* 1534 */     this.CLNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1535 */     this.CLNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/* 1536 */     this.CRNoseSpike.rotateAngleY = -0.261F + Cheadlr;
/* 1537 */     this.CRNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1538 */     this.CRNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/*      */ 
/*      */     
/* 1541 */     this.CJaw1.rotateAngleY = Cheadlr;
/* 1542 */     this.NeckC4.rotationPointZ -= (float)Math.cos(this.NeckC4.rotateAngleY) * 37.0F;
/* 1543 */     this.NeckC4.rotationPointX -= (float)Math.sin(this.NeckC4.rotateAngleY) * 37.0F;
/*      */     
/* 1545 */     this.CJaw2.rotateAngleY = Cheadlr;
/* 1546 */     this.CJaw2.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1547 */     this.CJaw2.rotationPointX = this.CJaw1.rotationPointX;
/* 1548 */     this.CJaw3.rotateAngleY = Cheadlr;
/* 1549 */     this.CJaw3.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1550 */     this.CJaw3.rotationPointX = this.CJaw1.rotationPointX;
/* 1551 */     this.CTooth1.rotateAngleY = Cheadlr;
/* 1552 */     this.CTooth1.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1553 */     this.CTooth1.rotationPointX = this.CJaw1.rotationPointX;
/* 1554 */     this.CTooth2.rotateAngleY = Cheadlr;
/* 1555 */     this.CTooth2.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1556 */     this.CTooth2.rotationPointX = this.CJaw1.rotationPointX;
/* 1557 */     this.CTooth3.rotateAngleY = Cheadlr;
/* 1558 */     this.CTooth3.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1559 */     this.CTooth3.rotationPointX = this.CJaw1.rotationPointX;
/* 1560 */     this.CTooth4.rotateAngleY = Cheadlr;
/* 1561 */     this.CTooth4.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1562 */     this.CTooth4.rotationPointX = this.CJaw1.rotationPointX;
/*      */ 
/*      */ 
/*      */     
/* 1566 */     this.NeckC1.rotateAngleX = Cheadud * 0.125F;
/* 1567 */     this.NeckC1.rotationPointY += (float)Math.sin(this.NeckC1.rotateAngleX) * 20.0F;
/* 1568 */     this.NeckC1.rotationPointZ += (this.NeckC2.rotationPointZ - this.NeckC1.rotationPointZ) * (float)Math.cos(this.NeckC1.rotateAngleX);
/* 1569 */     this.NeckC1.rotationPointX += (this.NeckC2.rotationPointX - this.NeckC1.rotationPointX) * (float)Math.cos(this.NeckC1.rotateAngleX);
/* 1570 */     this.NeckC2.rotateAngleX = Cheadud * 0.25F;
/* 1571 */     this.NeckC2.rotationPointY += (float)Math.sin(this.NeckC2.rotateAngleX) * 36.0F;
/* 1572 */     this.NeckC2.rotationPointZ += (this.NeckC3.rotationPointZ - this.NeckC2.rotationPointZ) * (float)Math.cos(this.NeckC2.rotateAngleX);
/* 1573 */     this.NeckC2.rotationPointX += (this.NeckC3.rotationPointX - this.NeckC2.rotationPointX) * (float)Math.cos(this.NeckC2.rotateAngleX);
/* 1574 */     this.NeckC3.rotateAngleX = Cheadud * 0.38F;
/* 1575 */     this.NeckC3.rotationPointY += (float)Math.sin(this.NeckC3.rotateAngleX) * 36.0F;
/* 1576 */     this.NeckC3.rotationPointZ += (this.NeckC4.rotationPointZ - this.NeckC3.rotationPointZ) * (float)Math.cos(this.NeckC3.rotateAngleX);
/* 1577 */     this.NeckC3.rotationPointX += (this.NeckC4.rotationPointX - this.NeckC3.rotationPointX) * (float)Math.cos(this.NeckC3.rotateAngleX);
/* 1578 */     this.NeckC4.rotateAngleX = Cheadud * 0.5F;
/* 1579 */     this.NeckC4.rotationPointY += (float)Math.sin(this.NeckC4.rotateAngleX) * 36.0F;
/* 1580 */     this.NeckC4.rotationPointZ += (this.CHead1.rotationPointZ - this.NeckC4.rotationPointZ) * (float)Math.cos(this.NeckC4.rotateAngleX);
/* 1581 */     this.NeckC4.rotationPointX += (this.CHead1.rotationPointX - this.NeckC4.rotationPointX) * (float)Math.cos(this.NeckC4.rotateAngleX);
/* 1582 */     this.CHead1.rotateAngleX = Cheadud;
/*      */     
/* 1584 */     this.CHead2.rotateAngleX = Cheadud;
/* 1585 */     this.CHead2.rotationPointZ = this.CHead1.rotationPointZ;
/* 1586 */     this.CHead2.rotationPointX = this.CHead1.rotationPointX;
/* 1587 */     this.CHead2.rotationPointY = this.CHead1.rotationPointY;
/* 1588 */     this.CHead3.rotateAngleX = Cheadud;
/* 1589 */     this.CHead3.rotationPointZ = this.CHead1.rotationPointZ;
/* 1590 */     this.CHead3.rotationPointX = this.CHead1.rotationPointX;
/* 1591 */     this.CHead3.rotationPointY = this.CHead1.rotationPointY;
/* 1592 */     this.CHeadMane.rotateAngleX = 0.384F + Cheadud;
/* 1593 */     this.CHeadMane.rotationPointZ = this.CHead1.rotationPointZ;
/* 1594 */     this.CHeadMane.rotationPointX = this.CHead1.rotationPointX;
/* 1595 */     this.CHeadMane.rotationPointY = this.CHead1.rotationPointY;
/* 1596 */     this.CLEye.rotateAngleX = Cheadud;
/* 1597 */     this.CLEye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1598 */     this.CLEye.rotationPointX = this.CHead1.rotationPointX;
/* 1599 */     this.CLEye.rotationPointY = this.CHead1.rotationPointY;
/* 1600 */     this.CREye.rotateAngleX = Cheadud;
/* 1601 */     this.CREye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1602 */     this.CREye.rotationPointX = this.CHead1.rotationPointX;
/* 1603 */     this.CREye.rotationPointY = this.CHead1.rotationPointY;
/* 1604 */     this.CLNoseSpike.rotateAngleX = 0.244F + Cheadud;
/* 1605 */     this.CLNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1606 */     this.CLNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/* 1607 */     this.CLNoseSpike.rotationPointY = this.CHead1.rotationPointY;
/* 1608 */     this.CRNoseSpike.rotateAngleX = 0.261F + Cheadud;
/* 1609 */     this.CRNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1610 */     this.CRNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/* 1611 */     this.CRNoseSpike.rotationPointY = this.CHead1.rotationPointY;
/*      */ 
/*      */     
/* 1614 */     this.CHead1.rotationPointY += (float)Math.cos(this.CHead1.rotateAngleX) * 14.0F;
/* 1615 */     this.NeckC4.rotationPointZ += (this.CJaw1.rotationPointZ - this.NeckC4.rotationPointZ) * (float)Math.cos(this.NeckC4.rotateAngleX);
/* 1616 */     this.CJaw1.rotationPointZ += (float)Math.sin(this.CHead1.rotateAngleX) * 14.0F;
/* 1617 */     this.NeckC4.rotationPointX += (this.CJaw1.rotationPointX - this.NeckC4.rotationPointX) * (float)Math.cos(this.NeckC4.rotateAngleX);
/*      */     
/* 1619 */     this.CJaw2.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1620 */     this.CJaw2.rotationPointX = this.CJaw1.rotationPointX;
/* 1621 */     this.CJaw2.rotationPointY = this.CJaw1.rotationPointY;
/* 1622 */     this.CJaw3.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1623 */     this.CJaw3.rotationPointX = this.CJaw1.rotationPointX;
/* 1624 */     this.CJaw3.rotationPointY = this.CJaw1.rotationPointY;
/* 1625 */     this.CTooth1.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1626 */     this.CTooth1.rotationPointX = this.CJaw1.rotationPointX;
/* 1627 */     this.CTooth1.rotationPointY = this.CJaw1.rotationPointY;
/* 1628 */     this.CTooth2.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1629 */     this.CTooth2.rotationPointX = this.CJaw1.rotationPointX;
/* 1630 */     this.CTooth2.rotationPointY = this.CJaw1.rotationPointY;
/* 1631 */     this.CTooth3.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1632 */     this.CTooth3.rotationPointX = this.CJaw1.rotationPointX;
/* 1633 */     this.CTooth3.rotationPointY = this.CJaw1.rotationPointY;
/* 1634 */     this.CTooth4.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1635 */     this.CTooth4.rotationPointX = this.CJaw1.rotationPointX;
/* 1636 */     this.CTooth4.rotationPointY = this.CJaw1.rotationPointY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveRightHead(float Rheadlr, float Rheadud, float Rjawangle) {
/* 1644 */     this.RJaw1.rotateAngleX = Rjawangle;
/* 1645 */     this.RJaw2.rotateAngleX = Rjawangle;
/* 1646 */     this.RJaw3.rotateAngleX = Rjawangle;
/* 1647 */     this.RTooth1.rotateAngleX = Rjawangle;
/* 1648 */     this.RTooth2.rotateAngleX = Rjawangle;
/* 1649 */     this.RTooth3.rotateAngleX = Rjawangle;
/* 1650 */     this.RTooth4.rotateAngleX = Rjawangle;
/*      */ 
/*      */ 
/*      */     
/* 1654 */     this.NeckR1.rotateAngleY = Rheadlr * 0.125F;
/* 1655 */     this.NeckR1.rotationPointZ -= (float)Math.cos(this.NeckR1.rotateAngleY) * 20.0F;
/* 1656 */     this.NeckR1.rotationPointX -= (float)Math.sin(this.NeckR1.rotateAngleY) * 20.0F;
/* 1657 */     this.NeckR2.rotateAngleY = Rheadlr * 0.25F;
/* 1658 */     this.NeckR2.rotationPointZ -= (float)Math.cos(this.NeckR2.rotateAngleY) * 36.0F;
/* 1659 */     this.NeckR2.rotationPointX -= (float)Math.sin(this.NeckR2.rotateAngleY) * 36.0F;
/* 1660 */     this.NeckR3.rotateAngleY = Rheadlr * 0.38F;
/* 1661 */     this.NeckR3.rotationPointZ -= (float)Math.cos(this.NeckR3.rotateAngleY) * 36.0F;
/* 1662 */     this.NeckR3.rotationPointX -= (float)Math.sin(this.NeckR3.rotateAngleY) * 36.0F;
/* 1663 */     this.NeckR4.rotateAngleY = Rheadlr * 0.5F;
/* 1664 */     this.NeckR4.rotationPointZ -= (float)Math.cos(this.NeckR4.rotateAngleY) * 36.0F;
/* 1665 */     this.NeckR4.rotationPointX -= (float)Math.sin(this.NeckR4.rotateAngleY) * 36.0F;
/* 1666 */     this.RHead1.rotateAngleY = Rheadlr;
/*      */     
/* 1668 */     this.RHead2.rotateAngleY = Rheadlr;
/* 1669 */     this.RHead2.rotationPointZ = this.RHead1.rotationPointZ;
/* 1670 */     this.RHead2.rotationPointX = this.RHead1.rotationPointX;
/* 1671 */     this.RHead3.rotateAngleY = Rheadlr;
/* 1672 */     this.RHead3.rotationPointZ = this.RHead1.rotationPointZ;
/* 1673 */     this.RHead3.rotationPointX = this.RHead1.rotationPointX;
/* 1674 */     this.RHeadMane.rotateAngleY = Rheadlr;
/* 1675 */     this.RHeadMane.rotationPointZ = this.RHead1.rotationPointZ;
/* 1676 */     this.RHeadMane.rotationPointX = this.RHead1.rotationPointX;
/* 1677 */     this.RLEye.rotateAngleY = Rheadlr;
/* 1678 */     this.RLEye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1679 */     this.RLEye.rotationPointX = this.RHead1.rotationPointX;
/* 1680 */     this.RREye.rotateAngleY = Rheadlr;
/* 1681 */     this.RREye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1682 */     this.RREye.rotationPointX = this.RHead1.rotationPointX;
/* 1683 */     this.RLNoseSpike.rotateAngleY = 0.244F + Rheadlr;
/* 1684 */     this.RLNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1685 */     this.RLNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/* 1686 */     this.RRNoseSpike.rotateAngleY = -0.261F + Rheadlr;
/* 1687 */     this.RRNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1688 */     this.RRNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/*      */ 
/*      */     
/* 1691 */     this.RJaw1.rotateAngleY = Rheadlr;
/* 1692 */     this.NeckR4.rotationPointZ -= (float)Math.cos(this.NeckR4.rotateAngleY) * 37.0F;
/* 1693 */     this.NeckR4.rotationPointX -= (float)Math.sin(this.NeckR4.rotateAngleY) * 37.0F;
/*      */     
/* 1695 */     this.RJaw2.rotateAngleY = Rheadlr;
/* 1696 */     this.RJaw2.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1697 */     this.RJaw2.rotationPointX = this.RJaw1.rotationPointX;
/* 1698 */     this.RJaw3.rotateAngleY = Rheadlr;
/* 1699 */     this.RJaw3.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1700 */     this.RJaw3.rotationPointX = this.RJaw1.rotationPointX;
/* 1701 */     this.RTooth1.rotateAngleY = Rheadlr;
/* 1702 */     this.RTooth1.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1703 */     this.RTooth1.rotationPointX = this.RJaw1.rotationPointX;
/* 1704 */     this.RTooth2.rotateAngleY = Rheadlr;
/* 1705 */     this.RTooth2.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1706 */     this.RTooth2.rotationPointX = this.RJaw1.rotationPointX;
/* 1707 */     this.RTooth3.rotateAngleY = Rheadlr;
/* 1708 */     this.RTooth3.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1709 */     this.RTooth3.rotationPointX = this.RJaw1.rotationPointX;
/* 1710 */     this.RTooth4.rotateAngleY = Rheadlr;
/* 1711 */     this.RTooth4.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1712 */     this.RTooth4.rotationPointX = this.RJaw1.rotationPointX;
/*      */ 
/*      */ 
/*      */     
/* 1716 */     this.NeckR1.rotateAngleX = Rheadud * 0.125F;
/* 1717 */     this.NeckR1.rotationPointY += (float)Math.sin(this.NeckR1.rotateAngleX) * 20.0F;
/* 1718 */     this.NeckR1.rotationPointZ += (this.NeckR2.rotationPointZ - this.NeckR1.rotationPointZ) * (float)Math.cos(this.NeckR1.rotateAngleX);
/* 1719 */     this.NeckR1.rotationPointX += (this.NeckR2.rotationPointX - this.NeckR1.rotationPointX) * (float)Math.cos(this.NeckR1.rotateAngleX);
/* 1720 */     this.NeckR2.rotateAngleX = Rheadud * 0.25F;
/* 1721 */     this.NeckR2.rotationPointY += (float)Math.sin(this.NeckR2.rotateAngleX) * 36.0F;
/* 1722 */     this.NeckR2.rotationPointZ += (this.NeckR3.rotationPointZ - this.NeckR2.rotationPointZ) * (float)Math.cos(this.NeckR2.rotateAngleX);
/* 1723 */     this.NeckR2.rotationPointX += (this.NeckR3.rotationPointX - this.NeckR2.rotationPointX) * (float)Math.cos(this.NeckR2.rotateAngleX);
/* 1724 */     this.NeckR3.rotateAngleX = Rheadud * 0.38F;
/* 1725 */     this.NeckR3.rotationPointY += (float)Math.sin(this.NeckR3.rotateAngleX) * 36.0F;
/* 1726 */     this.NeckR3.rotationPointZ += (this.NeckR4.rotationPointZ - this.NeckR3.rotationPointZ) * (float)Math.cos(this.NeckR3.rotateAngleX);
/* 1727 */     this.NeckR3.rotationPointX += (this.NeckR4.rotationPointX - this.NeckR3.rotationPointX) * (float)Math.cos(this.NeckR3.rotateAngleX);
/* 1728 */     this.NeckR4.rotateAngleX = Rheadud * 0.5F;
/* 1729 */     this.NeckR4.rotationPointY += (float)Math.sin(this.NeckR4.rotateAngleX) * 36.0F;
/* 1730 */     this.NeckR4.rotationPointZ += (this.RHead1.rotationPointZ - this.NeckR4.rotationPointZ) * (float)Math.cos(this.NeckR4.rotateAngleX);
/* 1731 */     this.NeckR4.rotationPointX += (this.RHead1.rotationPointX - this.NeckR4.rotationPointX) * (float)Math.cos(this.NeckR4.rotateAngleX);
/* 1732 */     this.RHead1.rotateAngleX = Rheadud;
/*      */     
/* 1734 */     this.RHead2.rotateAngleX = Rheadud;
/* 1735 */     this.RHead2.rotationPointZ = this.RHead1.rotationPointZ;
/* 1736 */     this.RHead2.rotationPointX = this.RHead1.rotationPointX;
/* 1737 */     this.RHead2.rotationPointY = this.RHead1.rotationPointY;
/* 1738 */     this.RHead3.rotateAngleX = Rheadud;
/* 1739 */     this.RHead3.rotationPointZ = this.RHead1.rotationPointZ;
/* 1740 */     this.RHead3.rotationPointX = this.RHead1.rotationPointX;
/* 1741 */     this.RHead3.rotationPointY = this.RHead1.rotationPointY;
/* 1742 */     this.RHeadMane.rotateAngleX = 0.384F + Rheadud;
/* 1743 */     this.RHeadMane.rotationPointZ = this.RHead1.rotationPointZ;
/* 1744 */     this.RHeadMane.rotationPointX = this.RHead1.rotationPointX;
/* 1745 */     this.RHeadMane.rotationPointY = this.RHead1.rotationPointY;
/* 1746 */     this.RLEye.rotateAngleX = Rheadud;
/* 1747 */     this.RLEye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1748 */     this.RLEye.rotationPointX = this.RHead1.rotationPointX;
/* 1749 */     this.RLEye.rotationPointY = this.RHead1.rotationPointY;
/* 1750 */     this.RREye.rotateAngleX = Rheadud;
/* 1751 */     this.RREye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1752 */     this.RREye.rotationPointX = this.RHead1.rotationPointX;
/* 1753 */     this.RREye.rotationPointY = this.RHead1.rotationPointY;
/* 1754 */     this.RLNoseSpike.rotateAngleX = 0.244F + Rheadud;
/* 1755 */     this.RLNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1756 */     this.RLNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/* 1757 */     this.RLNoseSpike.rotationPointY = this.RHead1.rotationPointY;
/* 1758 */     this.RRNoseSpike.rotateAngleX = 0.261F + Rheadud;
/* 1759 */     this.RRNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1760 */     this.RRNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/* 1761 */     this.RRNoseSpike.rotationPointY = this.RHead1.rotationPointY;
/*      */ 
/*      */     
/* 1764 */     this.RHead1.rotationPointY += (float)Math.cos(this.RHead1.rotateAngleX) * 14.0F;
/* 1765 */     this.NeckR4.rotationPointZ += (this.RJaw1.rotationPointZ - this.NeckR4.rotationPointZ) * (float)Math.cos(this.NeckR4.rotateAngleX);
/* 1766 */     this.RJaw1.rotationPointZ += (float)Math.sin(this.RHead1.rotateAngleX) * 14.0F;
/* 1767 */     this.NeckR4.rotationPointX += (this.RJaw1.rotationPointX - this.NeckR4.rotationPointX) * (float)Math.cos(this.NeckR4.rotateAngleX);
/*      */     
/* 1769 */     this.RJaw2.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1770 */     this.RJaw2.rotationPointX = this.RJaw1.rotationPointX;
/* 1771 */     this.RJaw2.rotationPointY = this.RJaw1.rotationPointY;
/* 1772 */     this.RJaw3.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1773 */     this.RJaw3.rotationPointX = this.RJaw1.rotationPointX;
/* 1774 */     this.RJaw3.rotationPointY = this.RJaw1.rotationPointY;
/* 1775 */     this.RTooth1.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1776 */     this.RTooth1.rotationPointX = this.RJaw1.rotationPointX;
/* 1777 */     this.RTooth1.rotationPointY = this.RJaw1.rotationPointY;
/* 1778 */     this.RTooth2.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1779 */     this.RTooth2.rotationPointX = this.RJaw1.rotationPointX;
/* 1780 */     this.RTooth2.rotationPointY = this.RJaw1.rotationPointY;
/* 1781 */     this.RTooth3.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1782 */     this.RTooth3.rotationPointX = this.RJaw1.rotationPointX;
/* 1783 */     this.RTooth3.rotationPointY = this.RJaw1.rotationPointY;
/* 1784 */     this.RTooth4.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1785 */     this.RTooth4.rotationPointX = this.RJaw1.rotationPointX;
/* 1786 */     this.RTooth4.rotationPointY = this.RJaw1.rotationPointY;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelTheQueen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
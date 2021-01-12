/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ModelThePrinceAdult
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
/*      */   ModelRenderer Chest;
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
/*      */   
/*      */   public ModelThePrinceAdult(float f1) {
/*  138 */     this.wingspeed = f1;
/*      */     
/*  140 */     this.textureWidth = 2048;
/*  141 */     this.textureHeight = 2048;
/*      */     
/*  143 */     this.LCClaw1 = new ModelRenderer(this, 0, 1450);
/*  144 */     this.LCClaw1.addBox(-5.0F, -5.0F, -20.0F, 10, 10, 20);
/*  145 */     this.LCClaw1.setRotationPoint(52.0F, -2.0F, -7.0F);
/*  146 */     this.LCClaw1.setTextureSize(64, 32);
/*  147 */     this.LCClaw1.mirror = true;
/*  148 */     setRotation(this.LCClaw1, 0.3839724F, 0.0F, 0.0F);
/*  149 */     this.LThigh = new ModelRenderer(this, 0, 1050);
/*  150 */     this.LThigh.addBox(0.0F, -14.0F, -21.0F, 25, 34, 42);
/*  151 */     this.LThigh.setRotationPoint(40.0F, -91.0F, 2.0F);
/*  152 */     this.LThigh.setTextureSize(64, 32);
/*  153 */     this.LThigh.mirror = true;
/*  154 */     setRotation(this.LThigh, 0.7853982F, 0.0F, 0.0F);
/*  155 */     this.LUpperLeg = new ModelRenderer(this, 0, 1137);
/*  156 */     this.LUpperLeg.addBox(0.0F, 12.0F, -16.0F, 24, 52, 24);
/*  157 */     this.LUpperLeg.setRotationPoint(40.0F, -91.0F, 2.0F);
/*  158 */     this.LUpperLeg.setTextureSize(64, 32);
/*  159 */     this.LUpperLeg.mirror = true;
/*  160 */     setRotation(this.LUpperLeg, 0.7853982F, 0.0F, 0.0F);
/*  161 */     this.TailTip = new ModelRenderer(this, 500, 102);
/*  162 */     this.TailTip.addBox(-51.0F, -3.0F, 0.0F, 100, 6, 36);
/*  163 */     this.TailTip.setRotationPoint(0.0F, -86.0F, 308.0F);
/*  164 */     this.TailTip.setTextureSize(64, 32);
/*  165 */     this.TailTip.mirror = true;
/*  166 */     setRotation(this.TailTip, 0.0F, 0.0F, 0.0F);
/*  167 */     this.Tail1 = new ModelRenderer(this, 500, 614);
/*  168 */     this.Tail1.addBox(-32.0F, 0.0F, 0.0F, 64, 52, 58);
/*  169 */     this.Tail1.setRotationPoint(0.0F, -114.0F, 29.0F);
/*  170 */     this.Tail1.setTextureSize(64, 32);
/*  171 */     this.Tail1.mirror = true;
/*  172 */     setRotation(this.Tail1, 0.0F, 0.0F, 0.0F);
/*  173 */     this.Tail2 = new ModelRenderer(this, 500, 520);
/*  174 */     this.Tail2.addBox(-25.0F, -19.0F, -3.0F, 50, 42, 46);
/*  175 */     this.Tail2.setRotationPoint(0.0F, -90.0F, 79.0F);
/*  176 */     this.Tail2.setTextureSize(64, 32);
/*  177 */     this.Tail2.mirror = true;
/*  178 */     setRotation(this.Tail2, 0.0F, 0.0F, 0.0F);
/*  179 */     this.Tail3 = new ModelRenderer(this, 500, 432);
/*  180 */     this.Tail3.addBox(-20.0F, -18.0F, 0.0F, 40, 36, 45);
/*  181 */     this.Tail3.setRotationPoint(0.0F, -88.0F, 117.0F);
/*  182 */     this.Tail3.setTextureSize(64, 32);
/*  183 */     this.Tail3.mirror = true;
/*  184 */     setRotation(this.Tail3, 0.0F, 0.0F, 0.0F);
/*  185 */     this.Tail4 = new ModelRenderer(this, 500, 355);
/*  186 */     this.Tail4.addBox(-16.0F, -15.0F, 0.0F, 32, 30, 38);
/*  187 */     this.Tail4.setRotationPoint(0.0F, -87.0F, 156.0F);
/*  188 */     this.Tail4.setTextureSize(64, 32);
/*  189 */     this.Tail4.mirror = true;
/*  190 */     setRotation(this.Tail4, 0.0F, 0.0F, 0.0F);
/*  191 */     this.Tail5 = new ModelRenderer(this, 500, 286);
/*  192 */     this.Tail5.addBox(-13.0F, -12.0F, 0.0F, 26, 24, 38);
/*  193 */     this.Tail5.setRotationPoint(0.0F, -87.0F, 189.0F);
/*  194 */     this.Tail5.setTextureSize(64, 32);
/*  195 */     this.Tail5.mirror = true;
/*  196 */     setRotation(this.Tail5, 0.0F, 0.0F, 0.0F);
/*  197 */     this.Tail6 = new ModelRenderer(this, 500, 218);
/*  198 */     this.Tail6.addBox(-10.0F, -9.0F, 0.0F, 20, 18, 44);
/*  199 */     this.Tail6.setRotationPoint(0.0F, -87.0F, 222.0F);
/*  200 */     this.Tail6.setTextureSize(64, 32);
/*  201 */     this.Tail6.mirror = true;
/*  202 */     setRotation(this.Tail6, 0.0F, 0.0F, 0.0F);
/*  203 */     this.Tail7 = new ModelRenderer(this, 500, 150);
/*  204 */     this.Tail7.addBox(-8.0F, -6.0F, -7.0F, 16, 12, 49);
/*  205 */     this.Tail7.setRotationPoint(0.0F, -87.0F, 268.0F);
/*  206 */     this.Tail7.setTextureSize(64, 32);
/*  207 */     this.Tail7.mirror = true;
/*  208 */     setRotation(this.Tail7, 0.0F, 0.0F, 0.0F);
/*  209 */     this.Body1 = new ModelRenderer(this, 500, 732);
/*  210 */     this.Body1.addBox(-40.0F, -32.0F, -36.0F, 80, 64, 72);
/*  211 */     this.Body1.setRotationPoint(0.0F, -89.0F, 1.0F);
/*  212 */     this.Body1.setTextureSize(64, 32);
/*  213 */     this.Body1.mirror = true;
/*  214 */     setRotation(this.Body1, 0.0F, 0.0F, 0.0F);
/*  215 */     this.Chest = new ModelRenderer(this, 0, 73);
/*  216 */     this.Chest.addBox(-41.0F, -32.0F, -60.0F, 82, 44, 60);
/*  217 */     this.Chest.setRotationPoint(0.0F, -91.0F, -22.0F);
/*  218 */     this.Chest.setTextureSize(64, 32);
/*  219 */     this.Chest.mirror = true;
/*  220 */     setRotation(this.Chest, 0.0F, 0.0F, 0.0F);
/*  221 */     this.NeckC1 = new ModelRenderer(this, 700, 1100);
/*  222 */     this.NeckC1.addBox(-12.0F, -12.0F, -24.0F, 24, 24, 24);
/*  223 */     this.NeckC1.setRotationPoint(0.0F, -113.0F, -76.0F);
/*  224 */     this.NeckC1.setTextureSize(64, 32);
/*  225 */     this.NeckC1.mirror = true;
/*  226 */     setRotation(this.NeckC1, -0.1047198F, 0.0F, 0.0F);
/*  227 */     this.LLowerLeg = new ModelRenderer(this, 0, 1220);
/*  228 */     this.LLowerLeg.addBox(-11.0F, 0.0F, -10.0F, 22, 59, 20);
/*  229 */     this.LLowerLeg.setRotationPoint(52.0F, -52.0F, 36.0F);
/*  230 */     this.LLowerLeg.setTextureSize(64, 32);
/*  231 */     this.LLowerLeg.mirror = true;
/*  232 */     setRotation(this.LLowerLeg, -0.6283185F, 0.0F, 0.0F);
/*  233 */     this.LFoot = new ModelRenderer(this, 0, 1307);
/*  234 */     this.LFoot.addBox(-18.0F, 59.0F, -10.0F, 36, 12, 20);
/*  235 */     this.LFoot.setRotationPoint(52.0F, -52.0F, 36.0F);
/*  236 */     this.LFoot.setTextureSize(64, 32);
/*  237 */     this.LFoot.mirror = true;
/*  238 */     setRotation(this.LFoot, -0.6283185F, 0.0F, 0.0F);
/*  239 */     this.LLClaw1 = new ModelRenderer(this, 0, 1400);
/*  240 */     this.LLClaw1.addBox(-5.0F, -5.0F, -20.0F, 10, 10, 20);
/*  241 */     this.LLClaw1.setRotationPoint(67.0F, -2.0F, -7.0F);
/*  242 */     this.LLClaw1.setTextureSize(64, 32);
/*  243 */     this.LLClaw1.mirror = true;
/*  244 */     setRotation(this.LLClaw1, 0.3839724F, 0.0F, 0.0F);
/*  245 */     this.LRClaw1 = new ModelRenderer(this, 0, 1500);
/*  246 */     this.LRClaw1.addBox(-5.0F, -5.0F, -20.0F, 10, 10, 20);
/*  247 */     this.LRClaw1.setRotationPoint(37.0F, -2.0F, -7.0F);
/*  248 */     this.LRClaw1.setTextureSize(64, 32);
/*  249 */     this.LRClaw1.mirror = true;
/*  250 */     setRotation(this.LRClaw1, 0.3839724F, 0.0F, 0.0F);
/*  251 */     this.LCClaw2 = new ModelRenderer(this, 0, 1600);
/*  252 */     this.LCClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 28);
/*  253 */     this.LCClaw2.setRotationPoint(52.0F, -2.0F, -7.0F);
/*  254 */     this.LCClaw2.setTextureSize(64, 32);
/*  255 */     this.LCClaw2.mirror = true;
/*  256 */     setRotation(this.LCClaw2, 0.6457718F, 0.0F, 0.0F);
/*  257 */     this.LLClaw2 = new ModelRenderer(this, 0, 1550);
/*  258 */     this.LLClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 28);
/*  259 */     this.LLClaw2.setRotationPoint(67.0F, -2.0F, -7.0F);
/*  260 */     this.LLClaw2.setTextureSize(64, 32);
/*  261 */     this.LLClaw2.mirror = true;
/*  262 */     setRotation(this.LLClaw2, 0.6457718F, 0.0F, 0.0F);
/*  263 */     this.TailSpike = new ModelRenderer(this, 500, 0);
/*  264 */     this.TailSpike.addBox(-2.0F, -1.0F, -7.0F, 4, 4, 53);
/*  265 */     this.TailSpike.setRotationPoint(0.0F, -87.0F, 375.0F);
/*  266 */     this.TailSpike.setTextureSize(64, 32);
/*  267 */     this.TailSpike.mirror = true;
/*  268 */     setRotation(this.TailSpike, 0.0F, 0.0F, 0.0F);
/*  269 */     this.LRClaw2 = new ModelRenderer(this, 0, 1650);
/*  270 */     this.LRClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 28);
/*  271 */     this.LRClaw2.setRotationPoint(37.0F, -2.0F, -7.0F);
/*  272 */     this.LRClaw2.setTextureSize(64, 32);
/*  273 */     this.LRClaw2.mirror = true;
/*  274 */     setRotation(this.LRClaw2, 0.6457718F, 0.0F, 0.0F);
/*  275 */     this.LClawRear = new ModelRenderer(this, 0, 1350);
/*  276 */     this.LClawRear.addBox(-2.0F, -3.0F, 0.0F, 4, 9, 28);
/*  277 */     this.LClawRear.setRotationPoint(52.0F, 4.0F, 4.0F);
/*  278 */     this.LClawRear.setTextureSize(64, 32);
/*  279 */     this.LClawRear.mirror = true;
/*  280 */     setRotation(this.LClawRear, -0.9250245F, 0.0F, 0.0F);
/*  281 */     this.NeckL1 = new ModelRenderer(this, 500, 1100);
/*  282 */     this.NeckL1.addBox(-12.0F, -12.0F, -24.0F, 24, 24, 24);
/*  283 */     this.NeckL1.setRotationPoint(30.0F, -113.0F, -76.0F);
/*  284 */     this.NeckL1.setTextureSize(64, 32);
/*  285 */     this.NeckL1.mirror = true;
/*  286 */     setRotation(this.NeckL1, -0.0523599F, -0.1047198F, 0.0F);
/*  287 */     this.NeckR1 = new ModelRenderer(this, 900, 1100);
/*  288 */     this.NeckR1.addBox(-12.0F, -12.0F, -24.0F, 24, 24, 24);
/*  289 */     this.NeckR1.setRotationPoint(-30.0F, -113.0F, -76.0F);
/*  290 */     this.NeckR1.setTextureSize(64, 32);
/*  291 */     this.NeckR1.mirror = true;
/*  292 */     setRotation(this.NeckR1, -0.0523599F, 0.1047198F, 0.0F);
/*  293 */     this.RThigh = new ModelRenderer(this, 200, 1050);
/*  294 */     this.RThigh.addBox(0.0F, -14.0F, -21.0F, 25, 34, 42);
/*  295 */     this.RThigh.setRotationPoint(-65.0F, -91.0F, 2.0F);
/*  296 */     this.RThigh.setTextureSize(64, 32);
/*  297 */     this.RThigh.mirror = true;
/*  298 */     setRotation(this.RThigh, 0.7853982F, 0.0F, 0.0F);
/*  299 */     this.RUpperLeg = new ModelRenderer(this, 200, 1137);
/*  300 */     this.RUpperLeg.addBox(0.0F, 12.0F, -16.0F, 24, 52, 24);
/*  301 */     this.RUpperLeg.setRotationPoint(-64.0F, -91.0F, 2.0F);
/*  302 */     this.RUpperLeg.setTextureSize(64, 32);
/*  303 */     this.RUpperLeg.mirror = true;
/*  304 */     setRotation(this.RUpperLeg, 0.7853982F, 0.0F, 0.0F);
/*  305 */     this.RLowerLeg = new ModelRenderer(this, 200, 1220);
/*  306 */     this.RLowerLeg.addBox(-4.0F, 0.0F, -10.0F, 22, 59, 20);
/*  307 */     this.RLowerLeg.setRotationPoint(-59.0F, -52.0F, 36.0F);
/*  308 */     this.RLowerLeg.setTextureSize(64, 32);
/*  309 */     this.RLowerLeg.mirror = true;
/*  310 */     setRotation(this.RLowerLeg, -0.6283185F, 0.0F, 0.0F);
/*  311 */     this.RFoot = new ModelRenderer(this, 200, 1307);
/*  312 */     this.RFoot.addBox(-11.0F, 59.0F, -10.0F, 36, 12, 20);
/*  313 */     this.RFoot.setRotationPoint(-59.0F, -52.0F, 36.0F);
/*  314 */     this.RFoot.setTextureSize(64, 32);
/*  315 */     this.RFoot.mirror = true;
/*  316 */     setRotation(this.RFoot, -0.6283185F, 0.0F, 0.0F);
/*  317 */     this.RClawRear = new ModelRenderer(this, 200, 1350);
/*  318 */     this.RClawRear.addBox(-2.0F, -3.0F, 0.0F, 4, 9, 28);
/*  319 */     this.RClawRear.setRotationPoint(-52.0F, 4.0F, 4.0F);
/*  320 */     this.RClawRear.setTextureSize(64, 32);
/*  321 */     this.RClawRear.mirror = true;
/*  322 */     setRotation(this.RClawRear, -0.9250245F, 0.0F, 0.0F);
/*  323 */     this.RLClaw1 = new ModelRenderer(this, 200, 1400);
/*  324 */     this.RLClaw1.addBox(-5.0F, -5.0F, -20.0F, 10, 10, 20);
/*  325 */     this.RLClaw1.setRotationPoint(-37.0F, -2.0F, -7.0F);
/*  326 */     this.RLClaw1.setTextureSize(64, 32);
/*  327 */     this.RLClaw1.mirror = true;
/*  328 */     setRotation(this.RLClaw1, 0.3839724F, 0.0F, 0.0F);
/*  329 */     this.RCClaw1 = new ModelRenderer(this, 200, 1450);
/*  330 */     this.RCClaw1.addBox(-5.0F, -5.0F, -20.0F, 10, 10, 20);
/*  331 */     this.RCClaw1.setRotationPoint(-52.0F, -2.0F, -7.0F);
/*  332 */     this.RCClaw1.setTextureSize(64, 32);
/*  333 */     this.RCClaw1.mirror = true;
/*  334 */     setRotation(this.RCClaw1, 0.3839724F, 0.0F, 0.0F);
/*  335 */     this.RRClaw1 = new ModelRenderer(this, 200, 1500);
/*  336 */     this.RRClaw1.addBox(-5.0F, -5.0F, -20.0F, 10, 10, 20);
/*  337 */     this.RRClaw1.setRotationPoint(-67.0F, -2.0F, -7.0F);
/*  338 */     this.RRClaw1.setTextureSize(64, 32);
/*  339 */     this.RRClaw1.mirror = true;
/*  340 */     setRotation(this.RRClaw1, 0.3839724F, 0.0F, 0.0F);
/*  341 */     this.RLClaw2 = new ModelRenderer(this, 200, 1550);
/*  342 */     this.RLClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 28);
/*  343 */     this.RLClaw2.setRotationPoint(-37.0F, -2.0F, -7.0F);
/*  344 */     this.RLClaw2.setTextureSize(64, 32);
/*  345 */     this.RLClaw2.mirror = true;
/*  346 */     setRotation(this.RLClaw2, 0.6457718F, 0.0F, 0.0F);
/*  347 */     this.RCClaw2 = new ModelRenderer(this, 200, 1600);
/*  348 */     this.RCClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 28);
/*  349 */     this.RCClaw2.setRotationPoint(-52.0F, -2.0F, -7.0F);
/*  350 */     this.RCClaw2.setTextureSize(64, 32);
/*  351 */     this.RCClaw2.mirror = true;
/*  352 */     setRotation(this.RCClaw2, 0.6457718F, 0.0F, 0.0F);
/*  353 */     this.RRClaw2 = new ModelRenderer(this, 200, 1650);
/*  354 */     this.RRClaw2.addBox(-2.0F, -7.0F, -46.0F, 4, 7, 28);
/*  355 */     this.RRClaw2.setRotationPoint(-67.0F, -2.0F, -7.0F);
/*  356 */     this.RRClaw2.setTextureSize(64, 32);
/*  357 */     this.RRClaw2.mirror = true;
/*  358 */     setRotation(this.RRClaw2, 0.6457718F, 0.0F, 0.0F);
/*  359 */     this.NeckL2 = new ModelRenderer(this, 500, 1154);
/*  360 */     this.NeckL2.addBox(-11.0F, -11.0F, -40.0F, 22, 22, 40);
/*  361 */     this.NeckL2.setRotationPoint(32.0F, -114.0F, -95.0F);
/*  362 */     this.NeckL2.setTextureSize(64, 32);
/*  363 */     this.NeckL2.mirror = true;
/*  364 */     setRotation(this.NeckL2, 0.0F, -0.1745329F, 0.0F);
/*  365 */     this.NeckC2 = new ModelRenderer(this, 700, 1154);
/*  366 */     this.NeckC2.addBox(-11.0F, -11.0F, -40.0F, 22, 22, 40);
/*  367 */     this.NeckC2.setRotationPoint(0.0F, -115.0F, -95.0F);
/*  368 */     this.NeckC2.setTextureSize(64, 32);
/*  369 */     this.NeckC2.mirror = true;
/*  370 */     setRotation(this.NeckC2, -0.1570796F, 0.0F, 0.0F);
/*  371 */     this.NeckR2 = new ModelRenderer(this, 900, 1154);
/*  372 */     this.NeckR2.addBox(-11.0F, -11.0F, -40.0F, 22, 22, 40);
/*  373 */     this.NeckR2.setRotationPoint(-32.0F, -114.0F, -95.0F);
/*  374 */     this.NeckR2.setTextureSize(64, 32);
/*  375 */     this.NeckR2.mirror = true;
/*  376 */     setRotation(this.NeckR2, -0.0523599F, 0.1745329F, 0.0F);
/*  377 */     this.NeckL3 = new ModelRenderer(this, 500, 1222);
/*  378 */     this.NeckL3.addBox(-10.0F, -10.0F, -40.0F, 20, 20, 40);
/*  379 */     this.NeckL3.setRotationPoint(38.0F, -114.0F, -131.0F);
/*  380 */     this.NeckL3.setTextureSize(64, 32);
/*  381 */     this.NeckL3.mirror = true;
/*  382 */     setRotation(this.NeckL3, 0.0698132F, -0.2617994F, 0.0F);
/*  383 */     this.NeckC3 = new ModelRenderer(this, 700, 1222);
/*  384 */     this.NeckC3.addBox(-10.0F, -10.0F, -40.0F, 20, 20, 40);
/*  385 */     this.NeckC3.setRotationPoint(0.0F, -120.0F, -131.0F);
/*  386 */     this.NeckC3.setTextureSize(64, 32);
/*  387 */     this.NeckC3.mirror = true;
/*  388 */     setRotation(this.NeckC3, -0.2094395F, 0.0F, 0.0F);
/*  389 */     this.NeckR3 = new ModelRenderer(this, 900, 1222);
/*  390 */     this.NeckR3.addBox(-10.0F, -10.0F, -40.0F, 20, 20, 40);
/*  391 */     this.NeckR3.setRotationPoint(-37.0F, -116.0F, -128.0F);
/*  392 */     this.NeckR3.setTextureSize(64, 32);
/*  393 */     this.NeckR3.mirror = true;
/*  394 */     setRotation(this.NeckR3, -0.0523599F, 0.3141593F, 0.0F);
/*  395 */     this.NeckL4 = new ModelRenderer(this, 500, 1300);
/*  396 */     this.NeckL4.addBox(-9.0F, -9.0F, -40.0F, 18, 18, 40);
/*  397 */     this.NeckL4.setRotationPoint(46.0F, -112.0F, -163.0F);
/*  398 */     this.NeckL4.setTextureSize(64, 32);
/*  399 */     this.NeckL4.mirror = true;
/*  400 */     setRotation(this.NeckL4, 0.1396263F, -0.3839724F, 0.0F);
/*  401 */     this.LHead1 = new ModelRenderer(this, 500, 1425);
/*  402 */     this.LHead1.addBox(-13.0F, -13.0F, -30.0F, 26, 26, 30);
/*  403 */     this.LHead1.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  404 */     this.LHead1.setTextureSize(64, 32);
/*  405 */     this.LHead1.mirror = true;
/*  406 */     setRotation(this.LHead1, 0.1396263F, -0.3839724F, 0.0F);
/*  407 */     this.LHead2 = new ModelRenderer(this, 500, 1550);
/*  408 */     this.LHead2.addBox(-10.0F, -7.0F, -58.0F, 20, 20, 28);
/*  409 */     this.LHead2.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  410 */     this.LHead2.setTextureSize(64, 32);
/*  411 */     this.LHead2.mirror = true;
/*  412 */     setRotation(this.LHead2, 0.1396263F, -0.3839724F, 0.0F);
/*  413 */     this.LHead3 = new ModelRenderer(this, 500, 1605);
/*  414 */     this.LHead3.addBox(-8.0F, -3.0F, -83.0F, 16, 16, 26);
/*  415 */     this.LHead3.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  416 */     this.LHead3.setTextureSize(64, 32);
/*  417 */     this.LHead3.mirror = true;
/*  418 */     setRotation(this.LHead3, 0.1396263F, -0.3839724F, 0.0F);
/*  419 */     this.LJaw1 = new ModelRenderer(this, 500, 1660);
/*  420 */     this.LJaw1.addBox(-14.0F, -2.0F, -14.0F, 28, 7, 16);
/*  421 */     this.LJaw1.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  422 */     this.LJaw1.setTextureSize(64, 32);
/*  423 */     this.LJaw1.mirror = true;
/*  424 */     setRotation(this.LJaw1, 0.2443461F, -0.3839724F, 0.0F);
/*  425 */     this.LJaw2 = new ModelRenderer(this, 500, 1700);
/*  426 */     this.LJaw2.addBox(-12.0F, -2.0F, -55.0F, 24, 6, 46);
/*  427 */     this.LJaw2.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  428 */     this.LJaw2.setTextureSize(64, 32);
/*  429 */     this.LJaw2.mirror = true;
/*  430 */     setRotation(this.LJaw2, 0.2443461F, -0.3839724F, 0.0F);
/*  431 */     this.LJaw3 = new ModelRenderer(this, 500, 1765);
/*  432 */     this.LJaw3.addBox(-10.0F, -2.0F, -77.0F, 20, 6, 22);
/*  433 */     this.LJaw3.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  434 */     this.LJaw3.setTextureSize(64, 32);
/*  435 */     this.LJaw3.mirror = true;
/*  436 */     setRotation(this.LJaw3, 0.2443461F, -0.3839724F, 0.0F);
/*  437 */     this.LTooth1 = new ModelRenderer(this, 10, 0);
/*  438 */     this.LTooth1.addBox(-10.0F, -10.0F, -77.0F, 2, 8, 2);
/*  439 */     this.LTooth1.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  440 */     this.LTooth1.setTextureSize(64, 32);
/*  441 */     this.LTooth1.mirror = true;
/*  442 */     setRotation(this.LTooth1, 0.2443461F, -0.3839724F, 0.0F);
/*  443 */     this.LTooth2 = new ModelRenderer(this, 20, 0);
/*  444 */     this.LTooth2.addBox(8.0F, -10.0F, -77.0F, 2, 8, 2);
/*  445 */     this.LTooth2.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  446 */     this.LTooth2.setTextureSize(64, 32);
/*  447 */     this.LTooth2.mirror = true;
/*  448 */     setRotation(this.LTooth2, 0.2443461F, -0.3839724F, 0.0F);
/*  449 */     this.LTooth3 = new ModelRenderer(this, 30, 0);
/*  450 */     this.LTooth3.addBox(-12.0F, -8.0F, -55.0F, 2, 6, 2);
/*  451 */     this.LTooth3.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  452 */     this.LTooth3.setTextureSize(64, 32);
/*  453 */     this.LTooth3.mirror = true;
/*  454 */     setRotation(this.LTooth3, 0.2443461F, -0.3839724F, 0.0F);
/*  455 */     this.LTooth4 = new ModelRenderer(this, 40, 0);
/*  456 */     this.LTooth4.addBox(10.0F, -8.0F, -55.0F, 2, 6, 2);
/*  457 */     this.LTooth4.setRotationPoint(59.0F, -100.0F, -196.0F);
/*  458 */     this.LTooth4.setTextureSize(64, 32);
/*  459 */     this.LTooth4.mirror = true;
/*  460 */     setRotation(this.LTooth4, 0.2443461F, -0.3839724F, 0.0F);
/*  461 */     this.NeckC4 = new ModelRenderer(this, 700, 1300);
/*  462 */     this.NeckC4.addBox(-9.0F, -9.0F, -40.0F, 18, 18, 40);
/*  463 */     this.NeckC4.setRotationPoint(0.0F, -126.0F, -162.0F);
/*  464 */     this.NeckC4.setTextureSize(64, 32);
/*  465 */     this.NeckC4.mirror = true;
/*  466 */     setRotation(this.NeckC4, -0.2617994F, 0.0F, 0.0F);
/*  467 */     this.NeckR4 = new ModelRenderer(this, 900, 1300);
/*  468 */     this.NeckR4.addBox(-9.0F, -9.0F, -40.0F, 18, 18, 40);
/*  469 */     this.NeckR4.setRotationPoint(-47.0F, -118.0F, -161.0F);
/*  470 */     this.NeckR4.setTextureSize(64, 32);
/*  471 */     this.NeckR4.mirror = true;
/*  472 */     setRotation(this.NeckR4, -0.1047198F, 0.3665191F, 0.0F);
/*  473 */     this.CHead1 = new ModelRenderer(this, 700, 1425);
/*  474 */     this.CHead1.addBox(-13.0F, -13.0F, -30.0F, 26, 26, 30);
/*  475 */     this.CHead1.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  476 */     this.CHead1.setTextureSize(64, 32);
/*  477 */     this.CHead1.mirror = true;
/*  478 */     setRotation(this.CHead1, -0.296706F, 0.0F, 0.0F);
/*  479 */     this.RHead1 = new ModelRenderer(this, 900, 1425);
/*  480 */     this.RHead1.addBox(-13.0F, -13.0F, -30.0F, 26, 26, 30);
/*  481 */     this.RHead1.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  482 */     this.RHead1.setTextureSize(64, 32);
/*  483 */     this.RHead1.mirror = true;
/*  484 */     setRotation(this.RHead1, -0.122173F, 0.418879F, 0.0F);
/*  485 */     this.CHead2 = new ModelRenderer(this, 700, 1550);
/*  486 */     this.CHead2.addBox(-10.0F, -7.0F, -58.0F, 20, 20, 28);
/*  487 */     this.CHead2.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  488 */     this.CHead2.setTextureSize(64, 32);
/*  489 */     this.CHead2.mirror = true;
/*  490 */     setRotation(this.CHead2, -0.296706F, 0.0F, 0.0F);
/*  491 */     this.RHead2 = new ModelRenderer(this, 900, 1550);
/*  492 */     this.RHead2.addBox(-10.0F, -7.0F, -58.0F, 20, 20, 28);
/*  493 */     this.RHead2.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  494 */     this.RHead2.setTextureSize(64, 32);
/*  495 */     this.RHead2.mirror = true;
/*  496 */     setRotation(this.RHead2, -0.122173F, 0.418879F, 0.0F);
/*  497 */     this.CHead3 = new ModelRenderer(this, 700, 1605);
/*  498 */     this.CHead3.addBox(-8.0F, -3.0F, -83.0F, 16, 16, 26);
/*  499 */     this.CHead3.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  500 */     this.CHead3.setTextureSize(64, 32);
/*  501 */     this.CHead3.mirror = true;
/*  502 */     setRotation(this.CHead3, -0.296706F, 0.0F, 0.0F);
/*  503 */     this.RHead3 = new ModelRenderer(this, 900, 1605);
/*  504 */     this.RHead3.addBox(-8.0F, -3.0F, -83.0F, 16, 16, 26);
/*  505 */     this.RHead3.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  506 */     this.RHead3.setTextureSize(64, 32);
/*  507 */     this.RHead3.mirror = true;
/*  508 */     setRotation(this.RHead3, -0.122173F, 0.418879F, 0.0F);
/*  509 */     this.CJaw1 = new ModelRenderer(this, 700, 1660);
/*  510 */     this.CJaw1.addBox(-14.0F, -2.0F, -14.0F, 28, 7, 16);
/*  511 */     this.CJaw1.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  512 */     this.CJaw1.setTextureSize(64, 32);
/*  513 */     this.CJaw1.mirror = true;
/*  514 */     setRotation(this.CJaw1, -0.1047198F, 0.0F, 0.0F);
/*  515 */     this.CJaw2 = new ModelRenderer(this, 700, 1700);
/*  516 */     this.CJaw2.addBox(-12.0F, -2.0F, -55.0F, 24, 6, 46);
/*  517 */     this.CJaw2.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  518 */     this.CJaw2.setTextureSize(64, 32);
/*  519 */     this.CJaw2.mirror = true;
/*  520 */     setRotation(this.CJaw2, -0.1047198F, 0.0F, 0.0F);
/*  521 */     this.CJaw3 = new ModelRenderer(this, 700, 1765);
/*  522 */     this.CJaw3.addBox(-10.0F, -2.0F, -77.0F, 20, 6, 22);
/*  523 */     this.CJaw3.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  524 */     this.CJaw3.setTextureSize(64, 32);
/*  525 */     this.CJaw3.mirror = true;
/*  526 */     setRotation(this.CJaw3, -0.1047198F, 0.0F, 0.0F);
/*  527 */     this.RJaw1 = new ModelRenderer(this, 900, 1660);
/*  528 */     this.RJaw1.addBox(-14.0F, -2.0F, -14.0F, 28, 7, 16);
/*  529 */     this.RJaw1.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  530 */     this.RJaw1.setTextureSize(64, 32);
/*  531 */     this.RJaw1.mirror = true;
/*  532 */     setRotation(this.RJaw1, 0.1570796F, 0.418879F, 0.0F);
/*  533 */     this.RJaw2 = new ModelRenderer(this, 900, 1700);
/*  534 */     this.RJaw2.addBox(-12.0F, -2.0F, -55.0F, 24, 6, 46);
/*  535 */     this.RJaw2.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  536 */     this.RJaw2.setTextureSize(64, 32);
/*  537 */     this.RJaw2.mirror = true;
/*  538 */     setRotation(this.RJaw2, 0.1570796F, 0.418879F, 0.0F);
/*  539 */     this.RJaw3 = new ModelRenderer(this, 900, 1765);
/*  540 */     this.RJaw3.addBox(-10.0F, -2.0F, -77.0F, 20, 6, 22);
/*  541 */     this.RJaw3.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  542 */     this.RJaw3.setTextureSize(64, 32);
/*  543 */     this.RJaw3.mirror = true;
/*  544 */     setRotation(this.RJaw3, 0.1570796F, 0.418879F, 0.0F);
/*  545 */     this.CTooth3 = new ModelRenderer(this, 70, 0);
/*  546 */     this.CTooth3.addBox(-12.0F, -8.0F, -55.0F, 2, 6, 2);
/*  547 */     this.CTooth3.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  548 */     this.CTooth3.setTextureSize(64, 32);
/*  549 */     this.CTooth3.mirror = true;
/*  550 */     setRotation(this.CTooth3, -0.1047198F, 0.0F, 0.0F);
/*  551 */     this.CTooth4 = new ModelRenderer(this, 80, 0);
/*  552 */     this.CTooth4.addBox(10.0F, -8.0F, -55.0F, 2, 6, 2);
/*  553 */     this.CTooth4.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  554 */     this.CTooth4.setTextureSize(64, 32);
/*  555 */     this.CTooth4.mirror = true;
/*  556 */     setRotation(this.CTooth4, -0.1047198F, 0.0F, 0.0F);
/*  557 */     this.CTooth1 = new ModelRenderer(this, 50, 0);
/*  558 */     this.CTooth1.addBox(-10.0F, -10.0F, -77.0F, 2, 8, 2);
/*  559 */     this.CTooth1.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  560 */     this.CTooth1.setTextureSize(64, 32);
/*  561 */     this.CTooth1.mirror = true;
/*  562 */     setRotation(this.CTooth1, -0.1047198F, 0.0F, 0.0F);
/*  563 */     this.CTooth2 = new ModelRenderer(this, 60, 0);
/*  564 */     this.CTooth2.addBox(8.0F, -10.0F, -77.0F, 2, 8, 2);
/*  565 */     this.CTooth2.setRotationPoint(0.0F, -130.0F, -201.0F);
/*  566 */     this.CTooth2.setTextureSize(64, 32);
/*  567 */     this.CTooth2.mirror = true;
/*  568 */     setRotation(this.CTooth2, -0.1047198F, 0.0F, 0.0F);
/*  569 */     this.RTooth3 = new ModelRenderer(this, 110, 0);
/*  570 */     this.RTooth3.addBox(-12.0F, -8.0F, -55.0F, 2, 6, 2);
/*  571 */     this.RTooth3.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  572 */     this.RTooth3.setTextureSize(64, 32);
/*  573 */     this.RTooth3.mirror = true;
/*  574 */     setRotation(this.RTooth3, 0.1570796F, 0.418879F, 0.0F);
/*  575 */     this.RTooth4 = new ModelRenderer(this, 120, 0);
/*  576 */     this.RTooth4.addBox(10.0F, -8.0F, -55.0F, 2, 6, 2);
/*  577 */     this.RTooth4.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  578 */     this.RTooth4.setTextureSize(64, 32);
/*  579 */     this.RTooth4.mirror = true;
/*  580 */     setRotation(this.RTooth4, 0.1570796F, 0.418879F, 0.0F);
/*  581 */     this.RTooth1 = new ModelRenderer(this, 90, 0);
/*  582 */     this.RTooth1.addBox(-10.0F, -10.0F, -77.0F, 2, 8, 2);
/*  583 */     this.RTooth1.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  584 */     this.RTooth1.setTextureSize(64, 32);
/*  585 */     this.RTooth1.mirror = true;
/*  586 */     setRotation(this.RTooth1, 0.1570796F, 0.418879F, 0.0F);
/*  587 */     this.RTooth2 = new ModelRenderer(this, 100, 0);
/*  588 */     this.RTooth2.addBox(8.0F, -10.0F, -77.0F, 2, 8, 2);
/*  589 */     this.RTooth2.setRotationPoint(-62.0F, -115.0F, -200.0F);
/*  590 */     this.RTooth2.setTextureSize(64, 32);
/*  591 */     this.RTooth2.mirror = true;
/*  592 */     setRotation(this.RTooth2, 0.1570796F, 0.418879F, 0.0F);
/*  593 */     this.LLEye = new ModelRenderer(this, 500, 1500);
/*  594 */     this.LLEye.addBox(13.0F, -12.0F, -29.0F, 2, 6, 10);
/*  595 */     this.LLEye.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  596 */     this.LLEye.setTextureSize(64, 32);
/*  597 */     this.LLEye.mirror = true;
/*  598 */     setRotation(this.LLEye, 0.1396263F, -0.3839724F, 0.0F);
/*  599 */     this.LREye = new ModelRenderer(this, 533, 1500);
/*  600 */     this.LREye.addBox(-15.0F, -12.0F, -29.0F, 2, 6, 10);
/*  601 */     this.LREye.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  602 */     this.LREye.setTextureSize(64, 32);
/*  603 */     this.LREye.mirror = true;
/*  604 */     setRotation(this.LREye, 0.1396263F, -0.3839724F, 0.0F);
/*  605 */     this.CLEye = new ModelRenderer(this, 700, 1500);
/*  606 */     this.CLEye.addBox(13.0F, -12.0F, -29.0F, 2, 6, 10);
/*  607 */     this.CLEye.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  608 */     this.CLEye.setTextureSize(64, 32);
/*  609 */     this.CLEye.mirror = true;
/*  610 */     setRotation(this.CLEye, -0.296706F, 0.0F, 0.0F);
/*  611 */     this.CREye = new ModelRenderer(this, 733, 1500);
/*  612 */     this.CREye.addBox(-15.0F, -12.0F, -29.0F, 2, 6, 10);
/*  613 */     this.CREye.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  614 */     this.CREye.setTextureSize(64, 32);
/*  615 */     this.CREye.mirror = true;
/*  616 */     setRotation(this.CREye, -0.296706F, 0.0F, 0.0F);
/*  617 */     this.RLEye = new ModelRenderer(this, 900, 1500);
/*  618 */     this.RLEye.addBox(13.0F, -12.0F, -29.0F, 2, 6, 10);
/*  619 */     this.RLEye.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  620 */     this.RLEye.setTextureSize(64, 32);
/*  621 */     this.RLEye.mirror = true;
/*  622 */     setRotation(this.RLEye, -0.122173F, 0.418879F, 0.0F);
/*  623 */     this.RREye = new ModelRenderer(this, 933, 1500);
/*  624 */     this.RREye.addBox(-15.0F, -12.0F, -29.0F, 2, 5, 10);
/*  625 */     this.RREye.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  626 */     this.RREye.setTextureSize(64, 32);
/*  627 */     this.RREye.mirror = true;
/*  628 */     setRotation(this.RREye, -0.122173F, 0.418879F, 0.0F);
/*  629 */     this.LHeadMane = new ModelRenderer(this, 500, 1375);
/*  630 */     this.LHeadMane.addBox(0.0F, -14.0F, 0.0F, 1, 23, 19);
/*  631 */     this.LHeadMane.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  632 */     this.LHeadMane.setTextureSize(64, 32);
/*  633 */     this.LHeadMane.mirror = true;
/*  634 */     setRotation(this.LHeadMane, 0.5235988F, -0.3839724F, 0.0F);
/*  635 */     this.CHeadMane = new ModelRenderer(this, 700, 1375);
/*  636 */     this.CHeadMane.addBox(0.0F, -14.0F, 0.0F, 1, 23, 19);
/*  637 */     this.CHeadMane.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  638 */     this.CHeadMane.setTextureSize(64, 32);
/*  639 */     this.CHeadMane.mirror = true;
/*  640 */     setRotation(this.CHeadMane, 0.1047198F, 0.0F, 0.0F);
/*  641 */     this.RHeadMane = new ModelRenderer(this, 900, 1375);
/*  642 */     this.RHeadMane.addBox(0.0F, -14.0F, 0.0F, 1, 23, 19);
/*  643 */     this.RHeadMane.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  644 */     this.RHeadMane.setTextureSize(64, 32);
/*  645 */     this.RHeadMane.mirror = true;
/*  646 */     setRotation(this.RHeadMane, 0.3665191F, 0.418879F, 0.0F);
/*  647 */     this.LLNoseSpike = new ModelRenderer(this, 0, 300);
/*  648 */     this.LLNoseSpike.addBox(24.0F, -23.0F, -76.0F, 1, 1, 17);
/*  649 */     this.LLNoseSpike.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  650 */     this.LLNoseSpike.setTextureSize(64, 32);
/*  651 */     this.LLNoseSpike.mirror = true;
/*  652 */     setRotation(this.LLNoseSpike, 0.4014257F, -0.1570796F, 0.0F);
/*  653 */     this.LRNoseSpike = new ModelRenderer(this, 0, 325);
/*  654 */     this.LRNoseSpike.addBox(-26.0F, -24.0F, -75.0F, 1, 1, 17);
/*  655 */     this.LRNoseSpike.setRotationPoint(59.0F, -114.0F, -195.0F);
/*  656 */     this.LRNoseSpike.setTextureSize(64, 32);
/*  657 */     this.LRNoseSpike.mirror = true;
/*  658 */     setRotation(this.LRNoseSpike, 0.418879F, -0.6283185F, 0.0F);
/*  659 */     this.CLNoseSpike = new ModelRenderer(this, 0, 350);
/*  660 */     this.CLNoseSpike.addBox(24.0F, -23.0F, -76.0F, 1, 1, 17);
/*  661 */     this.CLNoseSpike.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  662 */     this.CLNoseSpike.setTextureSize(64, 32);
/*  663 */     this.CLNoseSpike.mirror = true;
/*  664 */     setRotation(this.CLNoseSpike, -0.0523599F, 0.2443461F, 0.0F);
/*  665 */     this.CRNoseSpike = new ModelRenderer(this, 0, 375);
/*  666 */     this.CRNoseSpike.addBox(-26.0F, -24.0F, -75.0F, 1, 1, 17);
/*  667 */     this.CRNoseSpike.setRotationPoint(0.0F, -141.0F, -195.0F);
/*  668 */     this.CRNoseSpike.setTextureSize(64, 32);
/*  669 */     this.CRNoseSpike.mirror = true;
/*  670 */     setRotation(this.CRNoseSpike, -0.0349066F, -0.2617994F, 0.0F);
/*  671 */     this.RLNoseSpike = new ModelRenderer(this, 0, 400);
/*  672 */     this.RLNoseSpike.addBox(24.0F, -23.0F, -76.0F, 1, 1, 17);
/*  673 */     this.RLNoseSpike.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  674 */     this.RLNoseSpike.setTextureSize(64, 32);
/*  675 */     this.RLNoseSpike.mirror = true;
/*  676 */     setRotation(this.RLNoseSpike, 0.1396263F, 0.6457718F, 0.0F);
/*  677 */     this.RRNoseSpike = new ModelRenderer(this, 0, 425);
/*  678 */     this.RRNoseSpike.addBox(-26.0F, -24.0F, -75.0F, 1, 1, 17);
/*  679 */     this.RRNoseSpike.setRotationPoint(-60.0F, -128.0F, -195.0F);
/*  680 */     this.RRNoseSpike.setTextureSize(64, 32);
/*  681 */     this.RRNoseSpike.mirror = true;
/*  682 */     setRotation(this.RRNoseSpike, 0.1570796F, 0.1745329F, 0.0F);
/*  683 */     this.Back1 = new ModelRenderer(this, 167, 186);
/*  684 */     this.Back1.addBox(0.0F, 0.0F, 0.0F, 30, 15, 49);
/*  685 */     this.Back1.setRotationPoint(-45.0F, -127.0F, -58.0F);
/*  686 */     this.Back1.setTextureSize(64, 32);
/*  687 */     this.Back1.mirror = true;
/*  688 */     setRotation(this.Back1, -0.0698132F, 0.0F, 0.0F);
/*  689 */     this.Back2 = new ModelRenderer(this, 0, 186);
/*  690 */     this.Back2.addBox(0.0F, 0.0F, 0.0F, 30, 15, 49);
/*  691 */     this.Back2.setRotationPoint(15.0F, -127.0F, -58.0F);
/*  692 */     this.Back2.setTextureSize(64, 32);
/*  693 */     this.Back2.mirror = true;
/*  694 */     setRotation(this.Back2, -0.0698132F, 0.0F, 0.0F);
/*  695 */     this.Lwing1 = new ModelRenderer(this, 250, 1000);
/*  696 */     this.Lwing1.addBox(0.0F, 0.0F, 0.0F, 87, 5, 5);
/*  697 */     this.Lwing1.setRotationPoint(40.0F, -121.0F, -50.0F);
/*  698 */     this.Lwing1.setTextureSize(64, 32);
/*  699 */     this.Lwing1.mirror = true;
/*  700 */     setRotation(this.Lwing1, 0.0F, 0.0349066F, 0.0F);
/*  701 */     this.Lwing2 = new ModelRenderer(this, 1220, 782);
/*  702 */     this.Lwing2.addBox(0.0F, 2.0F, 0.0F, 87, 1, 110);
/*  703 */     this.Lwing2.setRotationPoint(40.0F, -121.0F, -49.0F);
/*  704 */     this.Lwing2.setTextureSize(64, 32);
/*  705 */     this.Lwing2.mirror = true;
/*  706 */     setRotation(this.Lwing2, 0.0F, 0.0349066F, 0.0F);
/*  707 */     this.Lwing3 = new ModelRenderer(this, 250, 975);
/*  708 */     this.Lwing3.addBox(0.0F, 0.0F, 0.0F, 188, 5, 5);
/*  709 */     this.Lwing3.setRotationPoint(124.0F, -121.0F, -53.0F);
/*  710 */     this.Lwing3.setTextureSize(64, 32);
/*  711 */     this.Lwing3.mirror = true;
/*  712 */     setRotation(this.Lwing3, 0.0F, 0.0F, 0.0F);
/*  713 */     this.Lwing4 = new ModelRenderer(this, 1341, 625);
/*  714 */     this.Lwing4.addBox(0.0F, 2.0F, 0.0F, 188, 1, 147);
/*  715 */     this.Lwing4.setRotationPoint(124.0F, -121.0F, -50.0F);
/*  716 */     this.Lwing4.setTextureSize(64, 32);
/*  717 */     this.Lwing4.mirror = true;
/*  718 */     setRotation(this.Lwing4, 0.0F, 0.0F, 0.0F);
/*  719 */     this.Lwing5 = new ModelRenderer(this, 245, 950);
/*  720 */     this.Lwing5.addBox(0.0F, 0.0F, 0.0F, 87, 5, 5);
/*  721 */     this.Lwing5.setRotationPoint(309.0F, -121.0F, -53.0F);
/*  722 */     this.Lwing5.setTextureSize(64, 32);
/*  723 */     this.Lwing5.mirror = true;
/*  724 */     setRotation(this.Lwing5, 0.0F, -0.0349066F, 0.0F);
/*  725 */     this.Lwing6 = new ModelRenderer(this, 1300, 1300);
/*  726 */     this.Lwing6.addBox(0.0F, 2.0F, 1.0F, 87, 1, 125);
/*  727 */     this.Lwing6.setRotationPoint(309.0F, -121.0F, -50.0F);
/*  728 */     this.Lwing6.setTextureSize(64, 32);
/*  729 */     this.Lwing6.mirror = true;
/*  730 */     setRotation(this.Lwing6, 0.0F, 0.0F, 0.0F);
/*  731 */     this.Lwing7 = new ModelRenderer(this, 250, 900);
/*  732 */     this.Lwing7.addBox(0.0F, 0.0F, 0.0F, 150, 5, 5);
/*  733 */     this.Lwing7.setRotationPoint(124.0F, -121.0F, -53.0F);
/*  734 */     this.Lwing7.setTextureSize(64, 32);
/*  735 */     this.Lwing7.mirror = true;
/*  736 */     setRotation(this.Lwing7, 0.0F, 0.0F, 0.2617994F);
/*  737 */     this.Lwing9 = new ModelRenderer(this, 250, 925);
/*  738 */     this.Lwing9.addBox(0.0F, 0.0F, 0.0F, 175, 5, 5);
/*  739 */     this.Lwing9.setRotationPoint(124.0F, -121.0F, -53.0F);
/*  740 */     this.Lwing9.setTextureSize(64, 32);
/*  741 */     this.Lwing9.mirror = true;
/*  742 */     setRotation(this.Lwing9, 0.0F, 0.0F, -0.2617994F);
/*  743 */     this.Lwing8 = new ModelRenderer(this, 1300, 1156);
/*  744 */     this.Lwing8.addBox(0.0F, 2.0F, 0.0F, 150, 1, 120);
/*  745 */     this.Lwing8.setRotationPoint(124.0F, -121.0F, -50.0F);
/*  746 */     this.Lwing8.setTextureSize(64, 32);
/*  747 */     this.Lwing8.mirror = true;
/*  748 */     setRotation(this.Lwing8, 0.0F, 0.0F, 0.2617994F);
/*  749 */     this.Lwing10 = new ModelRenderer(this, 1392, 326);
/*  750 */     this.Lwing10.addBox(0.0F, 2.0F, 0.0F, 176, 1, 136);
/*  751 */     this.Lwing10.setRotationPoint(124.0F, -121.0F, -50.0F);
/*  752 */     this.Lwing10.setTextureSize(64, 32);
/*  753 */     this.Lwing10.mirror = true;
/*  754 */     setRotation(this.Lwing10, 0.0F, 0.0F, -0.2617994F);
/*  755 */     this.Rwing1 = new ModelRenderer(this, 650, 1000);
/*  756 */     this.Rwing1.addBox(-87.0F, 0.0F, 0.0F, 87, 5, 5);
/*  757 */     this.Rwing1.setRotationPoint(-40.0F, -121.0F, -50.0F);
/*  758 */     this.Rwing1.setTextureSize(64, 32);
/*  759 */     this.Rwing1.mirror = true;
/*  760 */     setRotation(this.Rwing1, 0.0F, -0.0349066F, 0.0F);
/*  761 */     this.Rwing2 = new ModelRenderer(this, 1619, 782);
/*  762 */     this.Rwing2.addBox(-87.0F, 2.0F, 0.0F, 87, 1, 110);
/*  763 */     this.Rwing2.setRotationPoint(-40.0F, -121.0F, -49.0F);
/*  764 */     this.Rwing2.setTextureSize(64, 32);
/*  765 */     this.Rwing2.mirror = true;
/*  766 */     setRotation(this.Rwing2, 0.0F, -0.0349066F, 0.0F);
/*  767 */     this.Rwing3 = new ModelRenderer(this, 550, 950);
/*  768 */     this.Rwing3.addBox(-188.0F, 0.0F, 0.0F, 188, 5, 5);
/*  769 */     this.Rwing3.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  770 */     this.Rwing3.setTextureSize(64, 32);
/*  771 */     this.Rwing3.mirror = true;
/*  772 */     setRotation(this.Rwing3, 0.0F, 0.0F, 0.0F);
/*  773 */     this.Rwing4 = new ModelRenderer(this, 1341, 470);
/*  774 */     this.Rwing4.addBox(-188.0F, 2.0F, 0.0F, 188, 1, 147);
/*  775 */     this.Rwing4.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  776 */     this.Rwing4.setTextureSize(64, 32);
/*  777 */     this.Rwing4.mirror = true;
/*  778 */     setRotation(this.Rwing4, 0.0F, 0.0F, 0.0F);
/*  779 */     this.Rwing5 = new ModelRenderer(this, 750, 975);
/*  780 */     this.Rwing5.addBox(-87.0F, 0.0F, 0.0F, 87, 5, 5);
/*  781 */     this.Rwing5.setRotationPoint(-309.0F, -121.0F, -53.0F);
/*  782 */     this.Rwing5.setTextureSize(64, 32);
/*  783 */     this.Rwing5.mirror = true;
/*  784 */     setRotation(this.Rwing5, 0.0F, 0.0349066F, 0.0F);
/*  785 */     this.Rwing6 = new ModelRenderer(this, 1300, 1436);
/*  786 */     this.Rwing6.addBox(-87.0F, 2.0F, 1.0F, 87, 1, 125);
/*  787 */     this.Rwing6.setRotationPoint(-309.0F, -121.0F, -50.0F);
/*  788 */     this.Rwing6.setTextureSize(64, 32);
/*  789 */     this.Rwing6.mirror = true;
/*  790 */     setRotation(this.Rwing6, 0.0F, 0.0F, 0.0F);
/*  791 */     this.Rwing7 = new ModelRenderer(this, 650, 900);
/*  792 */     this.Rwing7.addBox(-150.0F, 0.0F, 0.0F, 150, 5, 5);
/*  793 */     this.Rwing7.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  794 */     this.Rwing7.setTextureSize(64, 32);
/*  795 */     this.Rwing7.mirror = true;
/*  796 */     setRotation(this.Rwing7, 0.0F, 0.0F, -0.2617994F);
/*  797 */     this.Rwing8 = new ModelRenderer(this, 1300, 1024);
/*  798 */     this.Rwing8.addBox(-150.0F, 2.0F, 0.0F, 150, 1, 120);
/*  799 */     this.Rwing8.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  800 */     this.Rwing8.setTextureSize(64, 32);
/*  801 */     this.Rwing8.mirror = true;
/*  802 */     setRotation(this.Rwing8, 0.0F, 0.0F, -0.2617994F);
/*  803 */     this.Rwing9 = new ModelRenderer(this, 621, 925);
/*  804 */     this.Rwing9.addBox(-175.0F, 0.0F, 0.0F, 175, 5, 5);
/*  805 */     this.Rwing9.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  806 */     this.Rwing9.setTextureSize(64, 32);
/*  807 */     this.Rwing9.mirror = true;
/*  808 */     setRotation(this.Rwing9, 0.0F, 0.0F, 0.2617994F);
/*  809 */     this.Rwing10 = new ModelRenderer(this, 1391, 184);
/*  810 */     this.Rwing10.addBox(-176.0F, 2.0F, 0.0F, 176, 1, 136);
/*  811 */     this.Rwing10.setRotationPoint(-124.0F, -121.0F, -53.0F);
/*  812 */     this.Rwing10.setTextureSize(64, 32);
/*  813 */     this.Rwing10.mirror = true;
/*  814 */     setRotation(this.Rwing10, 0.0F, 0.0F, 0.2617994F);
/*  815 */     this.TailTip2 = new ModelRenderer(this, 500, 63);
/*  816 */     this.TailTip2.addBox(-35.0F, -2.0F, 36.0F, 70, 4, 26);
/*  817 */     this.TailTip2.setRotationPoint(0.0F, -86.0F, 308.0F);
/*  818 */     this.TailTip2.setTextureSize(64, 32);
/*  819 */     this.TailTip2.mirror = true;
/*  820 */     setRotation(this.TailTip2, 0.0F, 0.0F, 0.0F);
/*  821 */     this.Ridge1 = new ModelRenderer(this, 850, 717);
/*  822 */     this.Ridge1.addBox(-1.0F, 0.0F, 0.0F, 3, 10, 24);
/*  823 */     this.Ridge1.setRotationPoint(0.0F, -122.0F, -75.0F);
/*  824 */     this.Ridge1.setTextureSize(64, 32);
/*  825 */     this.Ridge1.mirror = true;
/*  826 */     setRotation(this.Ridge1, 0.3665191F, 0.0F, 0.0F);
/*  827 */     this.Ridge2 = new ModelRenderer(this, 850, 676);
/*  828 */     this.Ridge2.addBox(-1.0F, 0.0F, 0.0F, 3, 10, 24);
/*  829 */     this.Ridge2.setRotationPoint(0.0F, -122.0F, -50.0F);
/*  830 */     this.Ridge2.setTextureSize(64, 32);
/*  831 */     this.Ridge2.mirror = true;
/*  832 */     setRotation(this.Ridge2, 0.3665191F, 0.0F, 0.0F);
/*  833 */     this.Ridge3 = new ModelRenderer(this, 800, 600);
/*  834 */     this.Ridge3.addBox(-1.0F, 0.0F, 0.0F, 3, 20, 49);
/*  835 */     this.Ridge3.setRotationPoint(0.0F, -120.0F, -20.0F);
/*  836 */     this.Ridge3.setTextureSize(64, 32);
/*  837 */     this.Ridge3.mirror = true;
/*  838 */     setRotation(this.Ridge3, 0.3665191F, 0.0F, 0.0F);
/*  839 */     this.Ridge4 = new ModelRenderer(this, 800, 550);
/*  840 */     this.Ridge4.addBox(-1.0F, 3.0F, 9.0F, 3, 10, 22);
/*  841 */     this.Ridge4.setRotationPoint(0.0F, -114.0F, 29.0F);
/*  842 */     this.Ridge4.setTextureSize(64, 32);
/*  843 */     this.Ridge4.mirror = true;
/*  844 */     setRotation(this.Ridge4, 0.3665191F, 0.0F, 0.0F);
/*  845 */     this.Ridge5 = new ModelRenderer(this, 800, 500);
/*  846 */     this.Ridge5.addBox(-1.0F, 13.0F, 33.0F, 3, 10, 20);
/*  847 */     this.Ridge5.setRotationPoint(0.0F, -114.0F, 29.0F);
/*  848 */     this.Ridge5.setTextureSize(64, 32);
/*  849 */     this.Ridge5.mirror = true;
/*  850 */     setRotation(this.Ridge5, 0.3665191F, 0.0F, 0.0F);
/*  851 */     this.Ridge6 = new ModelRenderer(this, 638, 165);
/*  852 */     this.Ridge6.addBox(-1.0F, 2.0F, 20.0F, 3, 10, 20);
/*  853 */     this.Ridge6.setRotationPoint(0.0F, -87.0F, 268.0F);
/*  854 */     this.Ridge6.setTextureSize(64, 32);
/*  855 */     this.Ridge6.mirror = true;
/*  856 */     setRotation(this.Ridge6, 0.3665191F, 0.0F, 0.0F);
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
/*      */     //   4: checkcast danger/orespawn/ThePrinceAdult
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
/*      */     //   90: ldc_w 0.75
/*      */     //   93: fmul
/*      */     //   94: aload_0
/*      */     //   95: getfield wingspeed : F
/*      */     //   98: fmul
/*      */     //   99: invokestatic cos : (F)F
/*      */     //   102: ldc_w 3.1415927
/*      */     //   105: fmul
/*      */     //   106: ldc_w 0.21
/*      */     //   109: fmul
/*      */     //   110: fstore #8
/*      */     //   112: goto -> 173
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
/*      */     //   139: aload #9
/*      */     //   141: invokevirtual getActivity : ()I
/*      */     //   144: ifne -> 173
/*      */     //   147: fload #4
/*      */     //   149: ldc_w 0.35
/*      */     //   152: fmul
/*      */     //   153: aload_0
/*      */     //   154: getfield wingspeed : F
/*      */     //   157: fmul
/*      */     //   158: invokestatic cos : (F)F
/*      */     //   161: ldc_w 3.1415927
/*      */     //   164: fmul
/*      */     //   165: ldc_w 0.15
/*      */     //   168: fmul
/*      */     //   169: fload_3
/*      */     //   170: fmul
/*      */     //   171: fstore #8
/*      */     //   173: aload #9
/*      */     //   175: invokevirtual isSitting : ()Z
/*      */     //   178: ifeq -> 184
/*      */     //   181: fconst_0
/*      */     //   182: fstore #8
/*      */     //   184: aload_0
/*      */     //   185: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   188: fload #8
/*      */     //   190: putfield rotateAngleZ : F
/*      */     //   193: aload_0
/*      */     //   194: getfield Lwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   197: fload #8
/*      */     //   199: putfield rotateAngleZ : F
/*      */     //   202: aload_0
/*      */     //   203: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   206: fload #8
/*      */     //   208: ldc_w 5.0
/*      */     //   211: fmul
/*      */     //   212: ldc_w 3.0
/*      */     //   215: fdiv
/*      */     //   216: putfield rotateAngleZ : F
/*      */     //   219: aload_0
/*      */     //   220: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   223: aload_0
/*      */     //   224: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   227: getfield rotationPointY : F
/*      */     //   230: aload_0
/*      */     //   231: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   234: getfield rotateAngleZ : F
/*      */     //   237: f2d
/*      */     //   238: invokestatic sin : (D)D
/*      */     //   241: d2f
/*      */     //   242: ldc_w 84.0
/*      */     //   245: fmul
/*      */     //   246: fadd
/*      */     //   247: putfield rotationPointY : F
/*      */     //   250: aload_0
/*      */     //   251: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   254: aload_0
/*      */     //   255: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   258: getfield rotationPointX : F
/*      */     //   261: aload_0
/*      */     //   262: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   265: getfield rotateAngleZ : F
/*      */     //   268: f2d
/*      */     //   269: invokestatic cos : (D)D
/*      */     //   272: d2f
/*      */     //   273: ldc_w 84.0
/*      */     //   276: fmul
/*      */     //   277: fadd
/*      */     //   278: putfield rotationPointX : F
/*      */     //   281: aload_0
/*      */     //   282: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   285: aload_0
/*      */     //   286: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   289: getfield rotateAngleZ : F
/*      */     //   292: putfield rotateAngleZ : F
/*      */     //   295: aload_0
/*      */     //   296: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   299: aload_0
/*      */     //   300: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   303: getfield rotationPointY : F
/*      */     //   306: putfield rotationPointY : F
/*      */     //   309: aload_0
/*      */     //   310: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   313: aload_0
/*      */     //   314: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   317: getfield rotationPointX : F
/*      */     //   320: putfield rotationPointX : F
/*      */     //   323: aload_0
/*      */     //   324: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   327: fload #8
/*      */     //   329: ldc_w 7.0
/*      */     //   332: fmul
/*      */     //   333: ldc_w 3.0
/*      */     //   336: fdiv
/*      */     //   337: putfield rotateAngleZ : F
/*      */     //   340: aload_0
/*      */     //   341: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   344: aload_0
/*      */     //   345: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   348: getfield rotationPointY : F
/*      */     //   351: aload_0
/*      */     //   352: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   355: getfield rotateAngleZ : F
/*      */     //   358: f2d
/*      */     //   359: invokestatic sin : (D)D
/*      */     //   362: d2f
/*      */     //   363: ldc_w 184.0
/*      */     //   366: fmul
/*      */     //   367: fadd
/*      */     //   368: putfield rotationPointY : F
/*      */     //   371: aload_0
/*      */     //   372: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   375: aload_0
/*      */     //   376: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   379: getfield rotationPointX : F
/*      */     //   382: aload_0
/*      */     //   383: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   386: getfield rotateAngleZ : F
/*      */     //   389: f2d
/*      */     //   390: invokestatic cos : (D)D
/*      */     //   393: d2f
/*      */     //   394: ldc_w 184.0
/*      */     //   397: fmul
/*      */     //   398: fadd
/*      */     //   399: putfield rotationPointX : F
/*      */     //   402: aload_0
/*      */     //   403: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   406: aload_0
/*      */     //   407: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   410: getfield rotateAngleZ : F
/*      */     //   413: putfield rotateAngleZ : F
/*      */     //   416: aload_0
/*      */     //   417: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   420: aload_0
/*      */     //   421: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   424: getfield rotationPointY : F
/*      */     //   427: putfield rotationPointY : F
/*      */     //   430: aload_0
/*      */     //   431: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   434: aload_0
/*      */     //   435: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   438: getfield rotationPointX : F
/*      */     //   441: putfield rotationPointX : F
/*      */     //   444: aload_0
/*      */     //   445: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   448: aload_0
/*      */     //   449: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   452: aload_0
/*      */     //   453: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   456: getfield rotationPointY : F
/*      */     //   459: dup_x1
/*      */     //   460: putfield rotationPointY : F
/*      */     //   463: putfield rotationPointY : F
/*      */     //   466: aload_0
/*      */     //   467: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   470: aload_0
/*      */     //   471: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   474: aload_0
/*      */     //   475: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   478: getfield rotationPointX : F
/*      */     //   481: dup_x1
/*      */     //   482: putfield rotationPointX : F
/*      */     //   485: putfield rotationPointX : F
/*      */     //   488: aload_0
/*      */     //   489: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   492: aload_0
/*      */     //   493: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   496: aload_0
/*      */     //   497: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   500: getfield rotationPointY : F
/*      */     //   503: dup_x1
/*      */     //   504: putfield rotationPointY : F
/*      */     //   507: putfield rotationPointY : F
/*      */     //   510: aload_0
/*      */     //   511: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   514: aload_0
/*      */     //   515: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   518: aload_0
/*      */     //   519: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   522: getfield rotationPointX : F
/*      */     //   525: dup_x1
/*      */     //   526: putfield rotationPointX : F
/*      */     //   529: putfield rotationPointX : F
/*      */     //   532: aload_0
/*      */     //   533: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   536: aload_0
/*      */     //   537: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   540: ldc_w 0.261
/*      */     //   543: aload_0
/*      */     //   544: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   547: getfield rotateAngleZ : F
/*      */     //   550: fadd
/*      */     //   551: dup_x1
/*      */     //   552: putfield rotateAngleZ : F
/*      */     //   555: putfield rotateAngleZ : F
/*      */     //   558: aload_0
/*      */     //   559: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   562: aload_0
/*      */     //   563: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   566: ldc_w -0.261
/*      */     //   569: aload_0
/*      */     //   570: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   573: getfield rotateAngleZ : F
/*      */     //   576: fadd
/*      */     //   577: dup_x1
/*      */     //   578: putfield rotateAngleZ : F
/*      */     //   581: putfield rotateAngleZ : F
/*      */     //   584: aload_0
/*      */     //   585: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   588: fload #8
/*      */     //   590: fneg
/*      */     //   591: putfield rotateAngleZ : F
/*      */     //   594: aload_0
/*      */     //   595: getfield Rwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   598: fload #8
/*      */     //   600: fneg
/*      */     //   601: putfield rotateAngleZ : F
/*      */     //   604: aload_0
/*      */     //   605: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   608: fload #8
/*      */     //   610: fneg
/*      */     //   611: ldc_w 5.0
/*      */     //   614: fmul
/*      */     //   615: ldc_w 3.0
/*      */     //   618: fdiv
/*      */     //   619: putfield rotateAngleZ : F
/*      */     //   622: aload_0
/*      */     //   623: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   626: aload_0
/*      */     //   627: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   630: getfield rotationPointY : F
/*      */     //   633: aload_0
/*      */     //   634: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   637: getfield rotateAngleZ : F
/*      */     //   640: f2d
/*      */     //   641: invokestatic sin : (D)D
/*      */     //   644: d2f
/*      */     //   645: ldc_w 84.0
/*      */     //   648: fmul
/*      */     //   649: fsub
/*      */     //   650: putfield rotationPointY : F
/*      */     //   653: aload_0
/*      */     //   654: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   657: aload_0
/*      */     //   658: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   661: getfield rotationPointX : F
/*      */     //   664: aload_0
/*      */     //   665: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   668: getfield rotateAngleZ : F
/*      */     //   671: f2d
/*      */     //   672: invokestatic cos : (D)D
/*      */     //   675: d2f
/*      */     //   676: ldc_w 84.0
/*      */     //   679: fmul
/*      */     //   680: fsub
/*      */     //   681: putfield rotationPointX : F
/*      */     //   684: aload_0
/*      */     //   685: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   688: aload_0
/*      */     //   689: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   692: getfield rotateAngleZ : F
/*      */     //   695: putfield rotateAngleZ : F
/*      */     //   698: aload_0
/*      */     //   699: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   702: aload_0
/*      */     //   703: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   706: getfield rotationPointY : F
/*      */     //   709: putfield rotationPointY : F
/*      */     //   712: aload_0
/*      */     //   713: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   716: aload_0
/*      */     //   717: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   720: getfield rotationPointX : F
/*      */     //   723: putfield rotationPointX : F
/*      */     //   726: aload_0
/*      */     //   727: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   730: fload #8
/*      */     //   732: fneg
/*      */     //   733: ldc_w 7.0
/*      */     //   736: fmul
/*      */     //   737: ldc_w 3.0
/*      */     //   740: fdiv
/*      */     //   741: putfield rotateAngleZ : F
/*      */     //   744: aload_0
/*      */     //   745: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   748: aload_0
/*      */     //   749: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   752: getfield rotationPointY : F
/*      */     //   755: aload_0
/*      */     //   756: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   759: getfield rotateAngleZ : F
/*      */     //   762: f2d
/*      */     //   763: invokestatic sin : (D)D
/*      */     //   766: d2f
/*      */     //   767: ldc_w 184.0
/*      */     //   770: fmul
/*      */     //   771: fsub
/*      */     //   772: putfield rotationPointY : F
/*      */     //   775: aload_0
/*      */     //   776: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   779: aload_0
/*      */     //   780: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   783: getfield rotationPointX : F
/*      */     //   786: aload_0
/*      */     //   787: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   790: getfield rotateAngleZ : F
/*      */     //   793: f2d
/*      */     //   794: invokestatic cos : (D)D
/*      */     //   797: d2f
/*      */     //   798: ldc_w 184.0
/*      */     //   801: fmul
/*      */     //   802: fsub
/*      */     //   803: putfield rotationPointX : F
/*      */     //   806: aload_0
/*      */     //   807: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   810: aload_0
/*      */     //   811: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   814: getfield rotateAngleZ : F
/*      */     //   817: putfield rotateAngleZ : F
/*      */     //   820: aload_0
/*      */     //   821: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   824: aload_0
/*      */     //   825: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   828: getfield rotationPointY : F
/*      */     //   831: putfield rotationPointY : F
/*      */     //   834: aload_0
/*      */     //   835: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   838: aload_0
/*      */     //   839: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   842: getfield rotationPointX : F
/*      */     //   845: putfield rotationPointX : F
/*      */     //   848: aload_0
/*      */     //   849: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   852: aload_0
/*      */     //   853: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   856: aload_0
/*      */     //   857: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   860: getfield rotationPointY : F
/*      */     //   863: dup_x1
/*      */     //   864: putfield rotationPointY : F
/*      */     //   867: putfield rotationPointY : F
/*      */     //   870: aload_0
/*      */     //   871: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   874: aload_0
/*      */     //   875: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   878: aload_0
/*      */     //   879: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   882: getfield rotationPointX : F
/*      */     //   885: dup_x1
/*      */     //   886: putfield rotationPointX : F
/*      */     //   889: putfield rotationPointX : F
/*      */     //   892: aload_0
/*      */     //   893: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   896: aload_0
/*      */     //   897: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   900: aload_0
/*      */     //   901: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   904: getfield rotationPointY : F
/*      */     //   907: dup_x1
/*      */     //   908: putfield rotationPointY : F
/*      */     //   911: putfield rotationPointY : F
/*      */     //   914: aload_0
/*      */     //   915: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   918: aload_0
/*      */     //   919: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   922: aload_0
/*      */     //   923: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   926: getfield rotationPointX : F
/*      */     //   929: dup_x1
/*      */     //   930: putfield rotationPointX : F
/*      */     //   933: putfield rotationPointX : F
/*      */     //   936: aload_0
/*      */     //   937: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   940: aload_0
/*      */     //   941: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   944: ldc_w -0.261
/*      */     //   947: aload_0
/*      */     //   948: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   951: getfield rotateAngleZ : F
/*      */     //   954: fadd
/*      */     //   955: dup_x1
/*      */     //   956: putfield rotateAngleZ : F
/*      */     //   959: putfield rotateAngleZ : F
/*      */     //   962: aload_0
/*      */     //   963: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   966: aload_0
/*      */     //   967: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   970: ldc_w 0.261
/*      */     //   973: aload_0
/*      */     //   974: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   977: getfield rotateAngleZ : F
/*      */     //   980: fadd
/*      */     //   981: dup_x1
/*      */     //   982: putfield rotateAngleZ : F
/*      */     //   985: putfield rotateAngleZ : F
/*      */     //   988: fconst_0
/*      */     //   989: fstore #8
/*      */     //   991: aload #9
/*      */     //   993: invokevirtual getAttacking : ()I
/*      */     //   996: ifeq -> 1023
/*      */     //   999: fload #4
/*      */     //   1001: ldc_w 0.75
/*      */     //   1004: fmul
/*      */     //   1005: aload_0
/*      */     //   1006: getfield wingspeed : F
/*      */     //   1009: fmul
/*      */     //   1010: invokestatic cos : (F)F
/*      */     //   1013: ldc_w 3.1415927
/*      */     //   1016: fmul
/*      */     //   1017: ldc_w 0.25
/*      */     //   1020: fmul
/*      */     //   1021: fstore #8
/*      */     //   1023: aload_0
/*      */     //   1024: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1027: aload_0
/*      */     //   1028: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1031: ldc_w -0.925
/*      */     //   1034: fload #8
/*      */     //   1036: fadd
/*      */     //   1037: dup_x1
/*      */     //   1038: putfield rotateAngleX : F
/*      */     //   1041: putfield rotateAngleX : F
/*      */     //   1044: aload_0
/*      */     //   1045: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1048: ldc_w 0.384
/*      */     //   1051: fload #8
/*      */     //   1053: fsub
/*      */     //   1054: putfield rotateAngleX : F
/*      */     //   1057: aload_0
/*      */     //   1058: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1061: ldc_w 0.645
/*      */     //   1064: fload #8
/*      */     //   1066: fsub
/*      */     //   1067: putfield rotateAngleX : F
/*      */     //   1070: aload_0
/*      */     //   1071: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1074: ldc_w 0.384
/*      */     //   1077: fload #8
/*      */     //   1079: fsub
/*      */     //   1080: putfield rotateAngleX : F
/*      */     //   1083: aload_0
/*      */     //   1084: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1087: ldc_w 0.645
/*      */     //   1090: fload #8
/*      */     //   1092: fsub
/*      */     //   1093: putfield rotateAngleX : F
/*      */     //   1096: aload_0
/*      */     //   1097: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1100: ldc_w 0.384
/*      */     //   1103: fload #8
/*      */     //   1105: fsub
/*      */     //   1106: putfield rotateAngleX : F
/*      */     //   1109: aload_0
/*      */     //   1110: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1113: ldc_w 0.645
/*      */     //   1116: fload #8
/*      */     //   1118: fsub
/*      */     //   1119: putfield rotateAngleX : F
/*      */     //   1122: aload_0
/*      */     //   1123: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1126: ldc_w 0.384
/*      */     //   1129: fload #8
/*      */     //   1131: fsub
/*      */     //   1132: putfield rotateAngleX : F
/*      */     //   1135: aload_0
/*      */     //   1136: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1139: ldc_w 0.645
/*      */     //   1142: fload #8
/*      */     //   1144: fsub
/*      */     //   1145: putfield rotateAngleX : F
/*      */     //   1148: aload_0
/*      */     //   1149: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1152: ldc_w 0.384
/*      */     //   1155: fload #8
/*      */     //   1157: fsub
/*      */     //   1158: putfield rotateAngleX : F
/*      */     //   1161: aload_0
/*      */     //   1162: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1165: ldc_w 0.645
/*      */     //   1168: fload #8
/*      */     //   1170: fsub
/*      */     //   1171: putfield rotateAngleX : F
/*      */     //   1174: aload_0
/*      */     //   1175: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1178: ldc_w 0.384
/*      */     //   1181: fload #8
/*      */     //   1183: fsub
/*      */     //   1184: putfield rotateAngleX : F
/*      */     //   1187: aload_0
/*      */     //   1188: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1191: ldc_w 0.645
/*      */     //   1194: fload #8
/*      */     //   1196: fsub
/*      */     //   1197: putfield rotateAngleX : F
/*      */     //   1200: fconst_0
/*      */     //   1201: fstore #8
/*      */     //   1203: aload #9
/*      */     //   1205: invokevirtual getAttacking : ()I
/*      */     //   1208: ifeq -> 1238
/*      */     //   1211: fload #4
/*      */     //   1213: ldc_w 0.6
/*      */     //   1216: fmul
/*      */     //   1217: aload_0
/*      */     //   1218: getfield wingspeed : F
/*      */     //   1221: fmul
/*      */     //   1222: invokestatic cos : (F)F
/*      */     //   1225: ldc_w 3.1415927
/*      */     //   1228: fmul
/*      */     //   1229: ldc_w 0.45
/*      */     //   1232: fmul
/*      */     //   1233: fstore #8
/*      */     //   1235: goto -> 1280
/*      */     //   1238: aload #9
/*      */     //   1240: invokevirtual isSitting : ()Z
/*      */     //   1243: ifne -> 1280
/*      */     //   1246: aload #9
/*      */     //   1248: invokevirtual getActivity : ()I
/*      */     //   1251: ifne -> 1280
/*      */     //   1254: fload #4
/*      */     //   1256: ldc_w 0.3
/*      */     //   1259: fmul
/*      */     //   1260: aload_0
/*      */     //   1261: getfield wingspeed : F
/*      */     //   1264: fmul
/*      */     //   1265: invokestatic cos : (F)F
/*      */     //   1268: ldc_w 3.1415927
/*      */     //   1271: fmul
/*      */     //   1272: ldc_w 0.25
/*      */     //   1275: fmul
/*      */     //   1276: fload_3
/*      */     //   1277: fmul
/*      */     //   1278: fstore #8
/*      */     //   1280: aload_0
/*      */     //   1281: getfield LThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1284: aload_0
/*      */     //   1285: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1288: ldc_w 0.785
/*      */     //   1291: fload #8
/*      */     //   1293: ldc_w 4.0
/*      */     //   1296: fdiv
/*      */     //   1297: fadd
/*      */     //   1298: dup_x1
/*      */     //   1299: putfield rotateAngleX : F
/*      */     //   1302: putfield rotateAngleX : F
/*      */     //   1305: aload_0
/*      */     //   1306: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1309: aload_0
/*      */     //   1310: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1313: ldc_w -0.628
/*      */     //   1316: fload #8
/*      */     //   1318: fconst_2
/*      */     //   1319: fdiv
/*      */     //   1320: fadd
/*      */     //   1321: dup_x1
/*      */     //   1322: putfield rotateAngleX : F
/*      */     //   1325: putfield rotateAngleX : F
/*      */     //   1328: aload_0
/*      */     //   1329: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1332: aload_0
/*      */     //   1333: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1336: aload_0
/*      */     //   1337: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1340: getfield rotationPointY : F
/*      */     //   1343: aload_0
/*      */     //   1344: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1347: getfield rotateAngleX : F
/*      */     //   1350: f2d
/*      */     //   1351: invokestatic cos : (D)D
/*      */     //   1354: d2f
/*      */     //   1355: ldc_w 50.0
/*      */     //   1358: fmul
/*      */     //   1359: fadd
/*      */     //   1360: dup_x1
/*      */     //   1361: putfield rotationPointY : F
/*      */     //   1364: putfield rotationPointY : F
/*      */     //   1367: aload_0
/*      */     //   1368: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1371: aload_0
/*      */     //   1372: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1375: aload_0
/*      */     //   1376: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1379: getfield rotationPointZ : F
/*      */     //   1382: aload_0
/*      */     //   1383: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1386: getfield rotateAngleX : F
/*      */     //   1389: f2d
/*      */     //   1390: invokestatic sin : (D)D
/*      */     //   1393: d2f
/*      */     //   1394: ldc_w 50.0
/*      */     //   1397: fmul
/*      */     //   1398: fadd
/*      */     //   1399: dup_x1
/*      */     //   1400: putfield rotationPointZ : F
/*      */     //   1403: putfield rotationPointZ : F
/*      */     //   1406: aload_0
/*      */     //   1407: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1410: aload_0
/*      */     //   1411: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1414: aload_0
/*      */     //   1415: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1418: getfield rotationPointY : F
/*      */     //   1421: aload_0
/*      */     //   1422: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1425: getfield rotateAngleX : F
/*      */     //   1428: ldc_w 0.1
/*      */     //   1431: fsub
/*      */     //   1432: f2d
/*      */     //   1433: invokestatic cos : (D)D
/*      */     //   1436: d2f
/*      */     //   1437: ldc_w 66.0
/*      */     //   1440: fmul
/*      */     //   1441: fadd
/*      */     //   1442: dup_x1
/*      */     //   1443: putfield rotationPointY : F
/*      */     //   1446: putfield rotationPointY : F
/*      */     //   1449: aload_0
/*      */     //   1450: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1453: aload_0
/*      */     //   1454: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1457: aload_0
/*      */     //   1458: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1461: getfield rotationPointZ : F
/*      */     //   1464: aload_0
/*      */     //   1465: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1468: getfield rotateAngleX : F
/*      */     //   1471: ldc_w 0.1
/*      */     //   1474: fsub
/*      */     //   1475: f2d
/*      */     //   1476: invokestatic sin : (D)D
/*      */     //   1479: d2f
/*      */     //   1480: ldc_w 66.0
/*      */     //   1483: fmul
/*      */     //   1484: fadd
/*      */     //   1485: dup_x1
/*      */     //   1486: putfield rotationPointZ : F
/*      */     //   1489: putfield rotationPointZ : F
/*      */     //   1492: aload_0
/*      */     //   1493: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1496: aload_0
/*      */     //   1497: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1500: aload_0
/*      */     //   1501: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1504: getfield rotationPointY : F
/*      */     //   1507: dup_x1
/*      */     //   1508: putfield rotationPointY : F
/*      */     //   1511: putfield rotationPointY : F
/*      */     //   1514: aload_0
/*      */     //   1515: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1518: aload_0
/*      */     //   1519: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1522: aload_0
/*      */     //   1523: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1526: getfield rotationPointY : F
/*      */     //   1529: dup_x1
/*      */     //   1530: putfield rotationPointY : F
/*      */     //   1533: putfield rotationPointY : F
/*      */     //   1536: aload_0
/*      */     //   1537: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1540: aload_0
/*      */     //   1541: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1544: aload_0
/*      */     //   1545: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1548: getfield rotationPointZ : F
/*      */     //   1551: dup_x1
/*      */     //   1552: putfield rotationPointZ : F
/*      */     //   1555: putfield rotationPointZ : F
/*      */     //   1558: aload_0
/*      */     //   1559: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1562: aload_0
/*      */     //   1563: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1566: aload_0
/*      */     //   1567: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1570: getfield rotationPointZ : F
/*      */     //   1573: dup_x1
/*      */     //   1574: putfield rotationPointZ : F
/*      */     //   1577: putfield rotationPointZ : F
/*      */     //   1580: aload_0
/*      */     //   1581: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1584: aload_0
/*      */     //   1585: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1588: getfield rotationPointY : F
/*      */     //   1591: aload_0
/*      */     //   1592: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1595: getfield rotateAngleX : F
/*      */     //   1598: ldc_w 0.15
/*      */     //   1601: fadd
/*      */     //   1602: f2d
/*      */     //   1603: invokestatic cos : (D)D
/*      */     //   1606: d2f
/*      */     //   1607: ldc_w 66.0
/*      */     //   1610: fmul
/*      */     //   1611: fadd
/*      */     //   1612: putfield rotationPointY : F
/*      */     //   1615: aload_0
/*      */     //   1616: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1619: aload_0
/*      */     //   1620: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1623: getfield rotationPointZ : F
/*      */     //   1626: aload_0
/*      */     //   1627: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1630: getfield rotateAngleX : F
/*      */     //   1633: ldc_w 0.15
/*      */     //   1636: fadd
/*      */     //   1637: f2d
/*      */     //   1638: invokestatic sin : (D)D
/*      */     //   1641: d2f
/*      */     //   1642: ldc_w 66.0
/*      */     //   1645: fmul
/*      */     //   1646: fadd
/*      */     //   1647: putfield rotationPointZ : F
/*      */     //   1650: aload_0
/*      */     //   1651: getfield RThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1654: aload_0
/*      */     //   1655: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1658: ldc_w 0.785
/*      */     //   1661: fload #8
/*      */     //   1663: ldc_w 4.0
/*      */     //   1666: fdiv
/*      */     //   1667: fsub
/*      */     //   1668: dup_x1
/*      */     //   1669: putfield rotateAngleX : F
/*      */     //   1672: putfield rotateAngleX : F
/*      */     //   1675: aload_0
/*      */     //   1676: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1679: aload_0
/*      */     //   1680: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1683: ldc_w -0.628
/*      */     //   1686: fload #8
/*      */     //   1688: fconst_2
/*      */     //   1689: fdiv
/*      */     //   1690: fsub
/*      */     //   1691: dup_x1
/*      */     //   1692: putfield rotateAngleX : F
/*      */     //   1695: putfield rotateAngleX : F
/*      */     //   1698: aload_0
/*      */     //   1699: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1702: aload_0
/*      */     //   1703: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1706: aload_0
/*      */     //   1707: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1710: getfield rotationPointY : F
/*      */     //   1713: aload_0
/*      */     //   1714: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1717: getfield rotateAngleX : F
/*      */     //   1720: f2d
/*      */     //   1721: invokestatic cos : (D)D
/*      */     //   1724: d2f
/*      */     //   1725: ldc_w 50.0
/*      */     //   1728: fmul
/*      */     //   1729: fadd
/*      */     //   1730: dup_x1
/*      */     //   1731: putfield rotationPointY : F
/*      */     //   1734: putfield rotationPointY : F
/*      */     //   1737: aload_0
/*      */     //   1738: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1741: aload_0
/*      */     //   1742: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1745: aload_0
/*      */     //   1746: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1749: getfield rotationPointZ : F
/*      */     //   1752: aload_0
/*      */     //   1753: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1756: getfield rotateAngleX : F
/*      */     //   1759: f2d
/*      */     //   1760: invokestatic sin : (D)D
/*      */     //   1763: d2f
/*      */     //   1764: ldc_w 50.0
/*      */     //   1767: fmul
/*      */     //   1768: fadd
/*      */     //   1769: dup_x1
/*      */     //   1770: putfield rotationPointZ : F
/*      */     //   1773: putfield rotationPointZ : F
/*      */     //   1776: aload_0
/*      */     //   1777: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1780: aload_0
/*      */     //   1781: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1784: aload_0
/*      */     //   1785: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1788: getfield rotationPointY : F
/*      */     //   1791: aload_0
/*      */     //   1792: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1795: getfield rotateAngleX : F
/*      */     //   1798: ldc_w 0.1
/*      */     //   1801: fsub
/*      */     //   1802: f2d
/*      */     //   1803: invokestatic cos : (D)D
/*      */     //   1806: d2f
/*      */     //   1807: ldc_w 66.0
/*      */     //   1810: fmul
/*      */     //   1811: fadd
/*      */     //   1812: dup_x1
/*      */     //   1813: putfield rotationPointY : F
/*      */     //   1816: putfield rotationPointY : F
/*      */     //   1819: aload_0
/*      */     //   1820: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1823: aload_0
/*      */     //   1824: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1827: aload_0
/*      */     //   1828: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1831: getfield rotationPointZ : F
/*      */     //   1834: aload_0
/*      */     //   1835: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1838: getfield rotateAngleX : F
/*      */     //   1841: ldc_w 0.1
/*      */     //   1844: fsub
/*      */     //   1845: f2d
/*      */     //   1846: invokestatic sin : (D)D
/*      */     //   1849: d2f
/*      */     //   1850: ldc_w 66.0
/*      */     //   1853: fmul
/*      */     //   1854: fadd
/*      */     //   1855: dup_x1
/*      */     //   1856: putfield rotationPointZ : F
/*      */     //   1859: putfield rotationPointZ : F
/*      */     //   1862: aload_0
/*      */     //   1863: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1866: aload_0
/*      */     //   1867: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1870: aload_0
/*      */     //   1871: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1874: getfield rotationPointY : F
/*      */     //   1877: dup_x1
/*      */     //   1878: putfield rotationPointY : F
/*      */     //   1881: putfield rotationPointY : F
/*      */     //   1884: aload_0
/*      */     //   1885: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1888: aload_0
/*      */     //   1889: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1892: aload_0
/*      */     //   1893: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1896: getfield rotationPointY : F
/*      */     //   1899: dup_x1
/*      */     //   1900: putfield rotationPointY : F
/*      */     //   1903: putfield rotationPointY : F
/*      */     //   1906: aload_0
/*      */     //   1907: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1910: aload_0
/*      */     //   1911: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1914: aload_0
/*      */     //   1915: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1918: getfield rotationPointZ : F
/*      */     //   1921: dup_x1
/*      */     //   1922: putfield rotationPointZ : F
/*      */     //   1925: putfield rotationPointZ : F
/*      */     //   1928: aload_0
/*      */     //   1929: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1932: aload_0
/*      */     //   1933: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1936: aload_0
/*      */     //   1937: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1940: getfield rotationPointZ : F
/*      */     //   1943: dup_x1
/*      */     //   1944: putfield rotationPointZ : F
/*      */     //   1947: putfield rotationPointZ : F
/*      */     //   1950: aload_0
/*      */     //   1951: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1954: aload_0
/*      */     //   1955: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1958: getfield rotationPointY : F
/*      */     //   1961: aload_0
/*      */     //   1962: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1965: getfield rotateAngleX : F
/*      */     //   1968: ldc_w 0.15
/*      */     //   1971: fadd
/*      */     //   1972: f2d
/*      */     //   1973: invokestatic cos : (D)D
/*      */     //   1976: d2f
/*      */     //   1977: ldc_w 66.0
/*      */     //   1980: fmul
/*      */     //   1981: fadd
/*      */     //   1982: putfield rotationPointY : F
/*      */     //   1985: aload_0
/*      */     //   1986: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1989: aload_0
/*      */     //   1990: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   1993: getfield rotationPointZ : F
/*      */     //   1996: aload_0
/*      */     //   1997: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2000: getfield rotateAngleX : F
/*      */     //   2003: ldc_w 0.15
/*      */     //   2006: fadd
/*      */     //   2007: f2d
/*      */     //   2008: invokestatic sin : (D)D
/*      */     //   2011: d2f
/*      */     //   2012: ldc_w 66.0
/*      */     //   2015: fmul
/*      */     //   2016: fadd
/*      */     //   2017: putfield rotationPointZ : F
/*      */     //   2020: aload #9
/*      */     //   2022: invokevirtual getAttacking : ()I
/*      */     //   2025: ifeq -> 2038
/*      */     //   2028: ldc_w 0.56
/*      */     //   2031: fstore #10
/*      */     //   2033: ldc_w 0.19
/*      */     //   2036: fstore #11
/*      */     //   2038: aload #9
/*      */     //   2040: invokevirtual isSitting : ()Z
/*      */     //   2043: ifeq -> 2052
/*      */     //   2046: fconst_0
/*      */     //   2047: fstore #10
/*      */     //   2049: fconst_0
/*      */     //   2050: fstore #11
/*      */     //   2052: aload_0
/*      */     //   2053: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2056: fload #4
/*      */     //   2058: fload #10
/*      */     //   2060: fmul
/*      */     //   2061: aload_0
/*      */     //   2062: getfield wingspeed : F
/*      */     //   2065: fmul
/*      */     //   2066: invokestatic cos : (F)F
/*      */     //   2069: ldc_w 3.1415927
/*      */     //   2072: fmul
/*      */     //   2073: fload #11
/*      */     //   2075: fmul
/*      */     //   2076: fconst_2
/*      */     //   2077: fdiv
/*      */     //   2078: putfield rotateAngleY : F
/*      */     //   2081: aload_0
/*      */     //   2082: getfield Ridge4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2085: aload_0
/*      */     //   2086: getfield Ridge5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2089: aload_0
/*      */     //   2090: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2093: getfield rotateAngleY : F
/*      */     //   2096: dup_x1
/*      */     //   2097: putfield rotateAngleY : F
/*      */     //   2100: putfield rotateAngleY : F
/*      */     //   2103: aload_0
/*      */     //   2104: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2107: aload_0
/*      */     //   2108: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2111: getfield rotationPointZ : F
/*      */     //   2114: aload_0
/*      */     //   2115: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2118: getfield rotateAngleY : F
/*      */     //   2121: f2d
/*      */     //   2122: invokestatic cos : (D)D
/*      */     //   2125: d2f
/*      */     //   2126: ldc_w 54.0
/*      */     //   2129: fmul
/*      */     //   2130: fadd
/*      */     //   2131: putfield rotationPointZ : F
/*      */     //   2134: aload_0
/*      */     //   2135: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2138: aload_0
/*      */     //   2139: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2142: getfield rotationPointX : F
/*      */     //   2145: fconst_1
/*      */     //   2146: fsub
/*      */     //   2147: aload_0
/*      */     //   2148: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2151: getfield rotateAngleY : F
/*      */     //   2154: f2d
/*      */     //   2155: invokestatic sin : (D)D
/*      */     //   2158: d2f
/*      */     //   2159: ldc_w 54.0
/*      */     //   2162: fmul
/*      */     //   2163: fadd
/*      */     //   2164: putfield rotationPointX : F
/*      */     //   2167: aload_0
/*      */     //   2168: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2171: fload #4
/*      */     //   2173: fload #10
/*      */     //   2175: fmul
/*      */     //   2176: aload_0
/*      */     //   2177: getfield wingspeed : F
/*      */     //   2180: fmul
/*      */     //   2181: fload #12
/*      */     //   2183: fsub
/*      */     //   2184: invokestatic cos : (F)F
/*      */     //   2187: ldc_w 3.1415927
/*      */     //   2190: fmul
/*      */     //   2191: fload #11
/*      */     //   2193: fmul
/*      */     //   2194: putfield rotateAngleY : F
/*      */     //   2197: aload_0
/*      */     //   2198: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2201: aload_0
/*      */     //   2202: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2205: getfield rotationPointZ : F
/*      */     //   2208: aload_0
/*      */     //   2209: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2212: getfield rotateAngleY : F
/*      */     //   2215: f2d
/*      */     //   2216: invokestatic cos : (D)D
/*      */     //   2219: d2f
/*      */     //   2220: ldc_w 42.0
/*      */     //   2223: fmul
/*      */     //   2224: fadd
/*      */     //   2225: putfield rotationPointZ : F
/*      */     //   2228: aload_0
/*      */     //   2229: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2232: aload_0
/*      */     //   2233: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2236: getfield rotationPointX : F
/*      */     //   2239: aload_0
/*      */     //   2240: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2243: getfield rotateAngleY : F
/*      */     //   2246: f2d
/*      */     //   2247: invokestatic sin : (D)D
/*      */     //   2250: d2f
/*      */     //   2251: ldc_w 42.0
/*      */     //   2254: fmul
/*      */     //   2255: fadd
/*      */     //   2256: putfield rotationPointX : F
/*      */     //   2259: aload_0
/*      */     //   2260: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2263: fload #4
/*      */     //   2265: fload #10
/*      */     //   2267: fmul
/*      */     //   2268: aload_0
/*      */     //   2269: getfield wingspeed : F
/*      */     //   2272: fmul
/*      */     //   2273: fconst_2
/*      */     //   2274: fload #12
/*      */     //   2276: fmul
/*      */     //   2277: fsub
/*      */     //   2278: invokestatic cos : (F)F
/*      */     //   2281: ldc_w 3.1415927
/*      */     //   2284: fmul
/*      */     //   2285: fload #11
/*      */     //   2287: fmul
/*      */     //   2288: putfield rotateAngleY : F
/*      */     //   2291: aload_0
/*      */     //   2292: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2295: aload_0
/*      */     //   2296: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2299: getfield rotationPointZ : F
/*      */     //   2302: aload_0
/*      */     //   2303: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2306: getfield rotateAngleY : F
/*      */     //   2309: f2d
/*      */     //   2310: invokestatic cos : (D)D
/*      */     //   2313: d2f
/*      */     //   2314: ldc_w 41.0
/*      */     //   2317: fmul
/*      */     //   2318: fadd
/*      */     //   2319: putfield rotationPointZ : F
/*      */     //   2322: aload_0
/*      */     //   2323: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2326: aload_0
/*      */     //   2327: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2330: getfield rotationPointX : F
/*      */     //   2333: aload_0
/*      */     //   2334: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2337: getfield rotateAngleY : F
/*      */     //   2340: f2d
/*      */     //   2341: invokestatic sin : (D)D
/*      */     //   2344: d2f
/*      */     //   2345: ldc_w 41.0
/*      */     //   2348: fmul
/*      */     //   2349: fadd
/*      */     //   2350: putfield rotationPointX : F
/*      */     //   2353: aload_0
/*      */     //   2354: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2357: fload #4
/*      */     //   2359: fload #10
/*      */     //   2361: fmul
/*      */     //   2362: aload_0
/*      */     //   2363: getfield wingspeed : F
/*      */     //   2366: fmul
/*      */     //   2367: ldc_w 3.0
/*      */     //   2370: fload #12
/*      */     //   2372: fmul
/*      */     //   2373: fsub
/*      */     //   2374: invokestatic cos : (F)F
/*      */     //   2377: ldc_w 3.1415927
/*      */     //   2380: fmul
/*      */     //   2381: fload #11
/*      */     //   2383: fmul
/*      */     //   2384: putfield rotateAngleY : F
/*      */     //   2387: fload #4
/*      */     //   2389: fload #10
/*      */     //   2391: fmul
/*      */     //   2392: aload_0
/*      */     //   2393: getfield wingspeed : F
/*      */     //   2396: fmul
/*      */     //   2397: ldc_w 3.0
/*      */     //   2400: fload #12
/*      */     //   2402: fmul
/*      */     //   2403: fsub
/*      */     //   2404: invokestatic cos : (F)F
/*      */     //   2407: ldc_w 3.1415927
/*      */     //   2410: fmul
/*      */     //   2411: fload #11
/*      */     //   2413: fmul
/*      */     //   2414: fstore #8
/*      */     //   2416: fload #8
/*      */     //   2418: fconst_2
/*      */     //   2419: fdiv
/*      */     //   2420: fstore #8
/*      */     //   2422: aload_0
/*      */     //   2423: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2426: aload_0
/*      */     //   2427: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2430: getfield rotationPointZ : F
/*      */     //   2433: aload_0
/*      */     //   2434: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2437: getfield rotateAngleY : F
/*      */     //   2440: f2d
/*      */     //   2441: invokestatic cos : (D)D
/*      */     //   2444: d2f
/*      */     //   2445: ldc_w 34.0
/*      */     //   2448: fmul
/*      */     //   2449: fadd
/*      */     //   2450: putfield rotationPointZ : F
/*      */     //   2453: aload_0
/*      */     //   2454: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2457: aload_0
/*      */     //   2458: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2461: getfield rotationPointX : F
/*      */     //   2464: aload_0
/*      */     //   2465: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2468: getfield rotateAngleY : F
/*      */     //   2471: f2d
/*      */     //   2472: invokestatic sin : (D)D
/*      */     //   2475: d2f
/*      */     //   2476: ldc_w 34.0
/*      */     //   2479: fmul
/*      */     //   2480: fadd
/*      */     //   2481: putfield rotationPointX : F
/*      */     //   2484: aload_0
/*      */     //   2485: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2488: aload_0
/*      */     //   2489: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2492: getfield rotateAngleY : F
/*      */     //   2495: fload #8
/*      */     //   2497: fadd
/*      */     //   2498: putfield rotateAngleY : F
/*      */     //   2501: aload_0
/*      */     //   2502: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2505: aload_0
/*      */     //   2506: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2509: getfield rotationPointZ : F
/*      */     //   2512: aload_0
/*      */     //   2513: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2516: getfield rotateAngleY : F
/*      */     //   2519: f2d
/*      */     //   2520: invokestatic cos : (D)D
/*      */     //   2523: d2f
/*      */     //   2524: ldc_w 34.0
/*      */     //   2527: fmul
/*      */     //   2528: fadd
/*      */     //   2529: putfield rotationPointZ : F
/*      */     //   2532: aload_0
/*      */     //   2533: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2536: aload_0
/*      */     //   2537: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2540: getfield rotationPointX : F
/*      */     //   2543: aload_0
/*      */     //   2544: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2547: getfield rotateAngleY : F
/*      */     //   2550: f2d
/*      */     //   2551: invokestatic sin : (D)D
/*      */     //   2554: d2f
/*      */     //   2555: ldc_w 34.0
/*      */     //   2558: fmul
/*      */     //   2559: fadd
/*      */     //   2560: putfield rotationPointX : F
/*      */     //   2563: aload_0
/*      */     //   2564: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2567: aload_0
/*      */     //   2568: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2571: getfield rotateAngleY : F
/*      */     //   2574: fload #8
/*      */     //   2576: fadd
/*      */     //   2577: putfield rotateAngleY : F
/*      */     //   2580: aload_0
/*      */     //   2581: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2584: aload_0
/*      */     //   2585: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2588: aload_0
/*      */     //   2589: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2592: getfield rotationPointZ : F
/*      */     //   2595: aload_0
/*      */     //   2596: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2599: getfield rotateAngleY : F
/*      */     //   2602: f2d
/*      */     //   2603: invokestatic cos : (D)D
/*      */     //   2606: d2f
/*      */     //   2607: ldc 40.0
/*      */     //   2609: fmul
/*      */     //   2610: fadd
/*      */     //   2611: dup_x1
/*      */     //   2612: putfield rotationPointZ : F
/*      */     //   2615: putfield rotationPointZ : F
/*      */     //   2618: aload_0
/*      */     //   2619: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2622: aload_0
/*      */     //   2623: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2626: aload_0
/*      */     //   2627: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2630: getfield rotationPointX : F
/*      */     //   2633: aload_0
/*      */     //   2634: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2637: getfield rotateAngleY : F
/*      */     //   2640: f2d
/*      */     //   2641: invokestatic sin : (D)D
/*      */     //   2644: d2f
/*      */     //   2645: ldc 40.0
/*      */     //   2647: fmul
/*      */     //   2648: fadd
/*      */     //   2649: dup_x1
/*      */     //   2650: putfield rotationPointX : F
/*      */     //   2653: putfield rotationPointX : F
/*      */     //   2656: aload_0
/*      */     //   2657: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2660: aload_0
/*      */     //   2661: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2664: aload_0
/*      */     //   2665: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2668: getfield rotateAngleY : F
/*      */     //   2671: fload #8
/*      */     //   2673: fadd
/*      */     //   2674: dup_x1
/*      */     //   2675: putfield rotateAngleY : F
/*      */     //   2678: putfield rotateAngleY : F
/*      */     //   2681: aload_0
/*      */     //   2682: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2685: aload_0
/*      */     //   2686: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2689: aload_0
/*      */     //   2690: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2693: getfield rotationPointZ : F
/*      */     //   2696: aload_0
/*      */     //   2697: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2700: getfield rotateAngleY : F
/*      */     //   2703: f2d
/*      */     //   2704: invokestatic cos : (D)D
/*      */     //   2707: d2f
/*      */     //   2708: ldc_w 43.0
/*      */     //   2711: fmul
/*      */     //   2712: fadd
/*      */     //   2713: dup_x1
/*      */     //   2714: putfield rotationPointZ : F
/*      */     //   2717: putfield rotationPointZ : F
/*      */     //   2720: aload_0
/*      */     //   2721: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2724: aload_0
/*      */     //   2725: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2728: aload_0
/*      */     //   2729: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2732: getfield rotationPointX : F
/*      */     //   2735: aload_0
/*      */     //   2736: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2739: getfield rotateAngleY : F
/*      */     //   2742: f2d
/*      */     //   2743: invokestatic sin : (D)D
/*      */     //   2746: d2f
/*      */     //   2747: ldc_w 43.0
/*      */     //   2750: fmul
/*      */     //   2751: fadd
/*      */     //   2752: dup_x1
/*      */     //   2753: putfield rotationPointX : F
/*      */     //   2756: putfield rotationPointX : F
/*      */     //   2759: aload_0
/*      */     //   2760: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2763: aload_0
/*      */     //   2764: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2767: aload_0
/*      */     //   2768: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2771: getfield rotateAngleY : F
/*      */     //   2774: fload #8
/*      */     //   2776: fadd
/*      */     //   2777: dup_x1
/*      */     //   2778: putfield rotateAngleY : F
/*      */     //   2781: putfield rotateAngleY : F
/*      */     //   2784: aload_0
/*      */     //   2785: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2788: aload_0
/*      */     //   2789: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2792: getfield rotationPointZ : F
/*      */     //   2795: aload_0
/*      */     //   2796: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2799: getfield rotateAngleY : F
/*      */     //   2802: f2d
/*      */     //   2803: invokestatic cos : (D)D
/*      */     //   2806: d2f
/*      */     //   2807: ldc_w 58.0
/*      */     //   2810: fmul
/*      */     //   2811: fadd
/*      */     //   2812: putfield rotationPointZ : F
/*      */     //   2815: aload_0
/*      */     //   2816: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2819: aload_0
/*      */     //   2820: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2823: getfield rotationPointX : F
/*      */     //   2826: aload_0
/*      */     //   2827: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2830: getfield rotateAngleY : F
/*      */     //   2833: f2d
/*      */     //   2834: invokestatic sin : (D)D
/*      */     //   2837: d2f
/*      */     //   2838: ldc_w 58.0
/*      */     //   2841: fmul
/*      */     //   2842: fadd
/*      */     //   2843: putfield rotationPointX : F
/*      */     //   2846: aload_0
/*      */     //   2847: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2850: aload_0
/*      */     //   2851: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   2854: getfield rotateAngleY : F
/*      */     //   2857: fload #8
/*      */     //   2859: fadd
/*      */     //   2860: putfield rotateAngleY : F
/*      */     //   2863: aload #9
/*      */     //   2865: invokevirtual getAttacking : ()I
/*      */     //   2868: ifeq -> 3108
/*      */     //   2871: fload #4
/*      */     //   2873: ldc_w 0.3
/*      */     //   2876: fmul
/*      */     //   2877: aload_0
/*      */     //   2878: getfield wingspeed : F
/*      */     //   2881: fmul
/*      */     //   2882: invokestatic sin : (F)F
/*      */     //   2885: ldc_w 3.1415927
/*      */     //   2888: fmul
/*      */     //   2889: ldc_w 0.25
/*      */     //   2892: fmul
/*      */     //   2893: fstore #13
/*      */     //   2895: aload #9
/*      */     //   2897: invokevirtual getHead1Ext : ()I
/*      */     //   2900: bipush #30
/*      */     //   2902: isub
/*      */     //   2903: i2d
/*      */     //   2904: invokestatic toRadians : (D)D
/*      */     //   2907: d2f
/*      */     //   2908: fstore #14
/*      */     //   2910: fload #4
/*      */     //   2912: ldc_w 0.85
/*      */     //   2915: fmul
/*      */     //   2916: aload_0
/*      */     //   2917: getfield wingspeed : F
/*      */     //   2920: fmul
/*      */     //   2921: invokestatic sin : (F)F
/*      */     //   2924: ldc_w 3.1415927
/*      */     //   2927: fmul
/*      */     //   2928: ldc_w 0.12
/*      */     //   2931: fmul
/*      */     //   2932: fstore #15
/*      */     //   2934: fload #4
/*      */     //   2936: ldc_w 0.32
/*      */     //   2939: fmul
/*      */     //   2940: aload_0
/*      */     //   2941: getfield wingspeed : F
/*      */     //   2944: fmul
/*      */     //   2945: invokestatic sin : (F)F
/*      */     //   2948: ldc_w 3.1415927
/*      */     //   2951: fmul
/*      */     //   2952: ldc_w 0.25
/*      */     //   2955: fmul
/*      */     //   2956: fstore #19
/*      */     //   2958: aload #9
/*      */     //   2960: invokevirtual getHead3Ext : ()I
/*      */     //   2963: bipush #30
/*      */     //   2965: isub
/*      */     //   2966: i2d
/*      */     //   2967: invokestatic toRadians : (D)D
/*      */     //   2970: d2f
/*      */     //   2971: fstore #20
/*      */     //   2973: fload #4
/*      */     //   2975: ldc_w 0.95
/*      */     //   2978: fmul
/*      */     //   2979: aload_0
/*      */     //   2980: getfield wingspeed : F
/*      */     //   2983: fmul
/*      */     //   2984: invokestatic sin : (F)F
/*      */     //   2987: ldc_w 3.1415927
/*      */     //   2990: fmul
/*      */     //   2991: ldc_w 0.12
/*      */     //   2994: fmul
/*      */     //   2995: fstore #21
/*      */     //   2997: fload #4
/*      */     //   2999: ldc_w 0.28
/*      */     //   3002: fmul
/*      */     //   3003: aload_0
/*      */     //   3004: getfield wingspeed : F
/*      */     //   3007: fmul
/*      */     //   3008: invokestatic sin : (F)F
/*      */     //   3011: ldc_w 3.1415927
/*      */     //   3014: fmul
/*      */     //   3015: ldc_w 0.25
/*      */     //   3018: fmul
/*      */     //   3019: fstore #16
/*      */     //   3021: aload #9
/*      */     //   3023: invokevirtual getHead2Ext : ()I
/*      */     //   3026: bipush #30
/*      */     //   3028: isub
/*      */     //   3029: i2d
/*      */     //   3030: invokestatic toRadians : (D)D
/*      */     //   3033: d2f
/*      */     //   3034: fstore #17
/*      */     //   3036: fload #4
/*      */     //   3038: ldc_w 0.75
/*      */     //   3041: fmul
/*      */     //   3042: aload_0
/*      */     //   3043: getfield wingspeed : F
/*      */     //   3046: fmul
/*      */     //   3047: invokestatic sin : (F)F
/*      */     //   3050: ldc_w 3.1415927
/*      */     //   3053: fmul
/*      */     //   3054: ldc_w 0.12
/*      */     //   3057: fmul
/*      */     //   3058: fstore #18
/*      */     //   3060: fload #15
/*      */     //   3062: ldc_w 0.5
/*      */     //   3065: fadd
/*      */     //   3066: fstore #15
/*      */     //   3068: fload #15
/*      */     //   3070: fload #14
/*      */     //   3072: fadd
/*      */     //   3073: fstore #15
/*      */     //   3075: fload #18
/*      */     //   3077: ldc_w 0.5
/*      */     //   3080: fadd
/*      */     //   3081: fstore #18
/*      */     //   3083: fload #18
/*      */     //   3085: fload #17
/*      */     //   3087: fadd
/*      */     //   3088: fstore #18
/*      */     //   3090: fload #21
/*      */     //   3092: ldc_w 0.5
/*      */     //   3095: fadd
/*      */     //   3096: fstore #21
/*      */     //   3098: fload #21
/*      */     //   3100: fload #20
/*      */     //   3102: fadd
/*      */     //   3103: fstore #21
/*      */     //   3105: goto -> 3611
/*      */     //   3108: aload #9
/*      */     //   3110: invokevirtual getActivity : ()I
/*      */     //   3113: ifeq -> 3308
/*      */     //   3116: fload #4
/*      */     //   3118: ldc_w 0.17
/*      */     //   3121: fmul
/*      */     //   3122: aload_0
/*      */     //   3123: getfield wingspeed : F
/*      */     //   3126: fmul
/*      */     //   3127: invokestatic sin : (F)F
/*      */     //   3130: ldc_w 3.1415927
/*      */     //   3133: fmul
/*      */     //   3134: ldc_w 0.08
/*      */     //   3137: fmul
/*      */     //   3138: fstore #13
/*      */     //   3140: aload #9
/*      */     //   3142: invokevirtual getHead1Ext : ()I
/*      */     //   3145: bipush #30
/*      */     //   3147: isub
/*      */     //   3148: i2d
/*      */     //   3149: invokestatic toRadians : (D)D
/*      */     //   3152: d2f
/*      */     //   3153: fstore #14
/*      */     //   3155: fload #4
/*      */     //   3157: ldc_w 0.45
/*      */     //   3160: fmul
/*      */     //   3161: aload_0
/*      */     //   3162: getfield wingspeed : F
/*      */     //   3165: fmul
/*      */     //   3166: invokestatic sin : (F)F
/*      */     //   3169: ldc_w 3.1415927
/*      */     //   3172: fmul
/*      */     //   3173: ldc_w 0.04
/*      */     //   3176: fmul
/*      */     //   3177: fstore #15
/*      */     //   3179: fload #4
/*      */     //   3181: ldc_w 0.19
/*      */     //   3184: fmul
/*      */     //   3185: aload_0
/*      */     //   3186: getfield wingspeed : F
/*      */     //   3189: fmul
/*      */     //   3190: invokestatic sin : (F)F
/*      */     //   3193: ldc_w 3.1415927
/*      */     //   3196: fmul
/*      */     //   3197: ldc_w 0.08
/*      */     //   3200: fmul
/*      */     //   3201: fstore #19
/*      */     //   3203: aload #9
/*      */     //   3205: invokevirtual getHead3Ext : ()I
/*      */     //   3208: bipush #30
/*      */     //   3210: isub
/*      */     //   3211: i2d
/*      */     //   3212: invokestatic toRadians : (D)D
/*      */     //   3215: d2f
/*      */     //   3216: fstore #20
/*      */     //   3218: fload #4
/*      */     //   3220: ldc_w 0.55
/*      */     //   3223: fmul
/*      */     //   3224: aload_0
/*      */     //   3225: getfield wingspeed : F
/*      */     //   3228: fmul
/*      */     //   3229: invokestatic sin : (F)F
/*      */     //   3232: ldc_w 3.1415927
/*      */     //   3235: fmul
/*      */     //   3236: ldc_w 0.04
/*      */     //   3239: fmul
/*      */     //   3240: fstore #21
/*      */     //   3242: fload #4
/*      */     //   3244: ldc_w 0.13
/*      */     //   3247: fmul
/*      */     //   3248: aload_0
/*      */     //   3249: getfield wingspeed : F
/*      */     //   3252: fmul
/*      */     //   3253: invokestatic sin : (F)F
/*      */     //   3256: ldc_w 3.1415927
/*      */     //   3259: fmul
/*      */     //   3260: ldc_w 0.08
/*      */     //   3263: fmul
/*      */     //   3264: fstore #16
/*      */     //   3266: aload #9
/*      */     //   3268: invokevirtual getHead2Ext : ()I
/*      */     //   3271: bipush #30
/*      */     //   3273: isub
/*      */     //   3274: i2d
/*      */     //   3275: invokestatic toRadians : (D)D
/*      */     //   3278: d2f
/*      */     //   3279: fstore #17
/*      */     //   3281: fload #4
/*      */     //   3283: ldc_w 0.65
/*      */     //   3286: fmul
/*      */     //   3287: aload_0
/*      */     //   3288: getfield wingspeed : F
/*      */     //   3291: fmul
/*      */     //   3292: invokestatic sin : (F)F
/*      */     //   3295: ldc_w 3.1415927
/*      */     //   3298: fmul
/*      */     //   3299: ldc_w 0.04
/*      */     //   3302: fmul
/*      */     //   3303: fstore #18
/*      */     //   3305: goto -> 3566
/*      */     //   3308: aload #9
/*      */     //   3310: invokevirtual getHead1Ext : ()I
/*      */     //   3313: bipush #30
/*      */     //   3315: isub
/*      */     //   3316: i2d
/*      */     //   3317: invokestatic toRadians : (D)D
/*      */     //   3320: d2f
/*      */     //   3321: fstore #14
/*      */     //   3323: aload #9
/*      */     //   3325: invokevirtual getHead3Ext : ()I
/*      */     //   3328: bipush #30
/*      */     //   3330: isub
/*      */     //   3331: i2d
/*      */     //   3332: invokestatic toRadians : (D)D
/*      */     //   3335: d2f
/*      */     //   3336: fstore #20
/*      */     //   3338: aload #9
/*      */     //   3340: invokevirtual getHead2Ext : ()I
/*      */     //   3343: bipush #30
/*      */     //   3345: isub
/*      */     //   3346: i2d
/*      */     //   3347: invokestatic toRadians : (D)D
/*      */     //   3350: d2f
/*      */     //   3351: fstore #17
/*      */     //   3353: fload #5
/*      */     //   3355: fconst_2
/*      */     //   3356: fmul
/*      */     //   3357: ldc_w 3.0
/*      */     //   3360: fdiv
/*      */     //   3361: dup
/*      */     //   3362: fstore #24
/*      */     //   3364: dup
/*      */     //   3365: fstore #23
/*      */     //   3367: fstore #22
/*      */     //   3369: fload #6
/*      */     //   3371: fconst_2
/*      */     //   3372: fmul
/*      */     //   3373: ldc_w 3.0
/*      */     //   3376: fdiv
/*      */     //   3377: dup
/*      */     //   3378: fstore #27
/*      */     //   3380: dup
/*      */     //   3381: fstore #26
/*      */     //   3383: fstore #25
/*      */     //   3385: fload #22
/*      */     //   3387: fconst_0
/*      */     //   3388: fcmpg
/*      */     //   3389: ifge -> 3413
/*      */     //   3392: fload #22
/*      */     //   3394: fconst_2
/*      */     //   3395: fdiv
/*      */     //   3396: dup
/*      */     //   3397: fstore #24
/*      */     //   3399: fstore #23
/*      */     //   3401: fload #25
/*      */     //   3403: fconst_2
/*      */     //   3404: fdiv
/*      */     //   3405: dup
/*      */     //   3406: fstore #27
/*      */     //   3408: fstore #26
/*      */     //   3410: goto -> 3431
/*      */     //   3413: fload #24
/*      */     //   3415: fconst_2
/*      */     //   3416: fdiv
/*      */     //   3417: dup
/*      */     //   3418: fstore #22
/*      */     //   3420: fstore #23
/*      */     //   3422: fload #27
/*      */     //   3424: fconst_2
/*      */     //   3425: fdiv
/*      */     //   3426: dup
/*      */     //   3427: fstore #25
/*      */     //   3429: fstore #26
/*      */     //   3431: fload #22
/*      */     //   3433: f2d
/*      */     //   3434: invokestatic toRadians : (D)D
/*      */     //   3437: d2f
/*      */     //   3438: fstore #13
/*      */     //   3440: fload #23
/*      */     //   3442: f2d
/*      */     //   3443: invokestatic toRadians : (D)D
/*      */     //   3446: d2f
/*      */     //   3447: fstore #16
/*      */     //   3449: fload #24
/*      */     //   3451: f2d
/*      */     //   3452: invokestatic toRadians : (D)D
/*      */     //   3455: d2f
/*      */     //   3456: fstore #19
/*      */     //   3458: fload #14
/*      */     //   3460: fload #25
/*      */     //   3462: f2d
/*      */     //   3463: invokestatic toRadians : (D)D
/*      */     //   3466: d2f
/*      */     //   3467: fadd
/*      */     //   3468: fstore #14
/*      */     //   3470: fload #17
/*      */     //   3472: fload #26
/*      */     //   3474: f2d
/*      */     //   3475: invokestatic toRadians : (D)D
/*      */     //   3478: d2f
/*      */     //   3479: fadd
/*      */     //   3480: fstore #17
/*      */     //   3482: fload #20
/*      */     //   3484: fload #27
/*      */     //   3486: f2d
/*      */     //   3487: invokestatic toRadians : (D)D
/*      */     //   3490: d2f
/*      */     //   3491: fadd
/*      */     //   3492: fstore #20
/*      */     //   3494: fload #4
/*      */     //   3496: ldc_w 0.25
/*      */     //   3499: fmul
/*      */     //   3500: aload_0
/*      */     //   3501: getfield wingspeed : F
/*      */     //   3504: fmul
/*      */     //   3505: invokestatic sin : (F)F
/*      */     //   3508: ldc_w 3.1415927
/*      */     //   3511: fmul
/*      */     //   3512: ldc_w 0.03
/*      */     //   3515: fmul
/*      */     //   3516: fstore #15
/*      */     //   3518: fload #4
/*      */     //   3520: ldc_w 0.35
/*      */     //   3523: fmul
/*      */     //   3524: aload_0
/*      */     //   3525: getfield wingspeed : F
/*      */     //   3528: fmul
/*      */     //   3529: invokestatic sin : (F)F
/*      */     //   3532: ldc_w 3.1415927
/*      */     //   3535: fmul
/*      */     //   3536: ldc_w 0.03
/*      */     //   3539: fmul
/*      */     //   3540: fstore #21
/*      */     //   3542: fload #4
/*      */     //   3544: ldc_w 0.45
/*      */     //   3547: fmul
/*      */     //   3548: aload_0
/*      */     //   3549: getfield wingspeed : F
/*      */     //   3552: fmul
/*      */     //   3553: invokestatic sin : (F)F
/*      */     //   3556: ldc_w 3.1415927
/*      */     //   3559: fmul
/*      */     //   3560: ldc_w 0.03
/*      */     //   3563: fmul
/*      */     //   3564: fstore #18
/*      */     //   3566: fload #15
/*      */     //   3568: ldc_w 0.25
/*      */     //   3571: fadd
/*      */     //   3572: fstore #15
/*      */     //   3574: fload #15
/*      */     //   3576: fload #14
/*      */     //   3578: fadd
/*      */     //   3579: fstore #15
/*      */     //   3581: fload #18
/*      */     //   3583: ldc_w 0.25
/*      */     //   3586: fadd
/*      */     //   3587: fstore #18
/*      */     //   3589: fload #18
/*      */     //   3591: fload #17
/*      */     //   3593: fadd
/*      */     //   3594: fstore #18
/*      */     //   3596: fload #21
/*      */     //   3598: ldc_w 0.25
/*      */     //   3601: fadd
/*      */     //   3602: fstore #21
/*      */     //   3604: fload #21
/*      */     //   3606: fload #20
/*      */     //   3608: fadd
/*      */     //   3609: fstore #21
/*      */     //   3611: fload #13
/*      */     //   3613: fload #16
/*      */     //   3615: fcmpl
/*      */     //   3616: ifle -> 3623
/*      */     //   3619: fload #16
/*      */     //   3621: fstore #13
/*      */     //   3623: fload #19
/*      */     //   3625: fload #16
/*      */     //   3627: fcmpg
/*      */     //   3628: ifge -> 3635
/*      */     //   3631: fload #16
/*      */     //   3633: fstore #19
/*      */     //   3635: aload_0
/*      */     //   3636: fload #13
/*      */     //   3638: fload #14
/*      */     //   3640: fload #15
/*      */     //   3642: invokespecial moveLeftHead : (FFF)V
/*      */     //   3645: aload_0
/*      */     //   3646: fload #16
/*      */     //   3648: fload #17
/*      */     //   3650: fload #18
/*      */     //   3652: invokespecial moveCenterHead : (FFF)V
/*      */     //   3655: aload_0
/*      */     //   3656: fload #19
/*      */     //   3658: fload #20
/*      */     //   3660: fload #21
/*      */     //   3662: invokespecial moveRightHead : (FFF)V
/*      */     //   3665: aload_0
/*      */     //   3666: getfield LCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3669: fload #7
/*      */     //   3671: invokevirtual render : (F)V
/*      */     //   3674: aload_0
/*      */     //   3675: getfield LThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3678: fload #7
/*      */     //   3680: invokevirtual render : (F)V
/*      */     //   3683: aload_0
/*      */     //   3684: getfield LUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3687: fload #7
/*      */     //   3689: invokevirtual render : (F)V
/*      */     //   3692: aload_0
/*      */     //   3693: getfield TailTip : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3696: fload #7
/*      */     //   3698: invokevirtual render : (F)V
/*      */     //   3701: aload_0
/*      */     //   3702: getfield Tail1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3705: fload #7
/*      */     //   3707: invokevirtual render : (F)V
/*      */     //   3710: aload_0
/*      */     //   3711: getfield Tail2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3714: fload #7
/*      */     //   3716: invokevirtual render : (F)V
/*      */     //   3719: aload_0
/*      */     //   3720: getfield Tail3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3723: fload #7
/*      */     //   3725: invokevirtual render : (F)V
/*      */     //   3728: aload_0
/*      */     //   3729: getfield Tail4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3732: fload #7
/*      */     //   3734: invokevirtual render : (F)V
/*      */     //   3737: aload_0
/*      */     //   3738: getfield Tail5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3741: fload #7
/*      */     //   3743: invokevirtual render : (F)V
/*      */     //   3746: aload_0
/*      */     //   3747: getfield Tail6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3750: fload #7
/*      */     //   3752: invokevirtual render : (F)V
/*      */     //   3755: aload_0
/*      */     //   3756: getfield Tail7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3759: fload #7
/*      */     //   3761: invokevirtual render : (F)V
/*      */     //   3764: aload_0
/*      */     //   3765: getfield Body1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3768: fload #7
/*      */     //   3770: invokevirtual render : (F)V
/*      */     //   3773: aload_0
/*      */     //   3774: getfield Chest : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3777: fload #7
/*      */     //   3779: invokevirtual render : (F)V
/*      */     //   3782: aload_0
/*      */     //   3783: getfield NeckC1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3786: fload #7
/*      */     //   3788: invokevirtual render : (F)V
/*      */     //   3791: aload_0
/*      */     //   3792: getfield LLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3795: fload #7
/*      */     //   3797: invokevirtual render : (F)V
/*      */     //   3800: aload_0
/*      */     //   3801: getfield LFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3804: fload #7
/*      */     //   3806: invokevirtual render : (F)V
/*      */     //   3809: aload_0
/*      */     //   3810: getfield LLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3813: fload #7
/*      */     //   3815: invokevirtual render : (F)V
/*      */     //   3818: aload_0
/*      */     //   3819: getfield LRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3822: fload #7
/*      */     //   3824: invokevirtual render : (F)V
/*      */     //   3827: aload_0
/*      */     //   3828: getfield LCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3831: fload #7
/*      */     //   3833: invokevirtual render : (F)V
/*      */     //   3836: aload_0
/*      */     //   3837: getfield LLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3840: fload #7
/*      */     //   3842: invokevirtual render : (F)V
/*      */     //   3845: aload_0
/*      */     //   3846: getfield TailSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3849: fload #7
/*      */     //   3851: invokevirtual render : (F)V
/*      */     //   3854: aload_0
/*      */     //   3855: getfield LRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3858: fload #7
/*      */     //   3860: invokevirtual render : (F)V
/*      */     //   3863: aload_0
/*      */     //   3864: getfield LClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3867: fload #7
/*      */     //   3869: invokevirtual render : (F)V
/*      */     //   3872: aload_0
/*      */     //   3873: getfield NeckL1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3876: fload #7
/*      */     //   3878: invokevirtual render : (F)V
/*      */     //   3881: aload_0
/*      */     //   3882: getfield NeckR1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3885: fload #7
/*      */     //   3887: invokevirtual render : (F)V
/*      */     //   3890: aload_0
/*      */     //   3891: getfield RThigh : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3894: fload #7
/*      */     //   3896: invokevirtual render : (F)V
/*      */     //   3899: aload_0
/*      */     //   3900: getfield RUpperLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3903: fload #7
/*      */     //   3905: invokevirtual render : (F)V
/*      */     //   3908: aload_0
/*      */     //   3909: getfield RLowerLeg : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3912: fload #7
/*      */     //   3914: invokevirtual render : (F)V
/*      */     //   3917: aload_0
/*      */     //   3918: getfield RFoot : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3921: fload #7
/*      */     //   3923: invokevirtual render : (F)V
/*      */     //   3926: aload_0
/*      */     //   3927: getfield RClawRear : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3930: fload #7
/*      */     //   3932: invokevirtual render : (F)V
/*      */     //   3935: aload_0
/*      */     //   3936: getfield RLClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3939: fload #7
/*      */     //   3941: invokevirtual render : (F)V
/*      */     //   3944: aload_0
/*      */     //   3945: getfield RCClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3948: fload #7
/*      */     //   3950: invokevirtual render : (F)V
/*      */     //   3953: aload_0
/*      */     //   3954: getfield RRClaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3957: fload #7
/*      */     //   3959: invokevirtual render : (F)V
/*      */     //   3962: aload_0
/*      */     //   3963: getfield RLClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3966: fload #7
/*      */     //   3968: invokevirtual render : (F)V
/*      */     //   3971: aload_0
/*      */     //   3972: getfield RCClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3975: fload #7
/*      */     //   3977: invokevirtual render : (F)V
/*      */     //   3980: aload_0
/*      */     //   3981: getfield RRClaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3984: fload #7
/*      */     //   3986: invokevirtual render : (F)V
/*      */     //   3989: aload_0
/*      */     //   3990: getfield NeckL2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   3993: fload #7
/*      */     //   3995: invokevirtual render : (F)V
/*      */     //   3998: aload_0
/*      */     //   3999: getfield NeckC2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4002: fload #7
/*      */     //   4004: invokevirtual render : (F)V
/*      */     //   4007: aload_0
/*      */     //   4008: getfield NeckR2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4011: fload #7
/*      */     //   4013: invokevirtual render : (F)V
/*      */     //   4016: aload_0
/*      */     //   4017: getfield NeckL3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4020: fload #7
/*      */     //   4022: invokevirtual render : (F)V
/*      */     //   4025: aload_0
/*      */     //   4026: getfield NeckC3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4029: fload #7
/*      */     //   4031: invokevirtual render : (F)V
/*      */     //   4034: aload_0
/*      */     //   4035: getfield NeckR3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4038: fload #7
/*      */     //   4040: invokevirtual render : (F)V
/*      */     //   4043: aload_0
/*      */     //   4044: getfield NeckL4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4047: fload #7
/*      */     //   4049: invokevirtual render : (F)V
/*      */     //   4052: aload_0
/*      */     //   4053: getfield LHead1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4056: fload #7
/*      */     //   4058: invokevirtual render : (F)V
/*      */     //   4061: aload_0
/*      */     //   4062: getfield LHead2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4065: fload #7
/*      */     //   4067: invokevirtual render : (F)V
/*      */     //   4070: aload_0
/*      */     //   4071: getfield LHead3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4074: fload #7
/*      */     //   4076: invokevirtual render : (F)V
/*      */     //   4079: aload_0
/*      */     //   4080: getfield LJaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4083: fload #7
/*      */     //   4085: invokevirtual render : (F)V
/*      */     //   4088: aload_0
/*      */     //   4089: getfield LJaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4092: fload #7
/*      */     //   4094: invokevirtual render : (F)V
/*      */     //   4097: aload_0
/*      */     //   4098: getfield LJaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4101: fload #7
/*      */     //   4103: invokevirtual render : (F)V
/*      */     //   4106: aload_0
/*      */     //   4107: getfield LTooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4110: fload #7
/*      */     //   4112: invokevirtual render : (F)V
/*      */     //   4115: aload_0
/*      */     //   4116: getfield LTooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4119: fload #7
/*      */     //   4121: invokevirtual render : (F)V
/*      */     //   4124: aload_0
/*      */     //   4125: getfield LTooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4128: fload #7
/*      */     //   4130: invokevirtual render : (F)V
/*      */     //   4133: aload_0
/*      */     //   4134: getfield LTooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4137: fload #7
/*      */     //   4139: invokevirtual render : (F)V
/*      */     //   4142: aload_0
/*      */     //   4143: getfield NeckC4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4146: fload #7
/*      */     //   4148: invokevirtual render : (F)V
/*      */     //   4151: aload_0
/*      */     //   4152: getfield NeckR4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4155: fload #7
/*      */     //   4157: invokevirtual render : (F)V
/*      */     //   4160: aload_0
/*      */     //   4161: getfield CHead1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4164: fload #7
/*      */     //   4166: invokevirtual render : (F)V
/*      */     //   4169: aload_0
/*      */     //   4170: getfield RHead1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4173: fload #7
/*      */     //   4175: invokevirtual render : (F)V
/*      */     //   4178: aload_0
/*      */     //   4179: getfield CHead2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4182: fload #7
/*      */     //   4184: invokevirtual render : (F)V
/*      */     //   4187: aload_0
/*      */     //   4188: getfield RHead2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4191: fload #7
/*      */     //   4193: invokevirtual render : (F)V
/*      */     //   4196: aload_0
/*      */     //   4197: getfield CHead3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4200: fload #7
/*      */     //   4202: invokevirtual render : (F)V
/*      */     //   4205: aload_0
/*      */     //   4206: getfield RHead3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4209: fload #7
/*      */     //   4211: invokevirtual render : (F)V
/*      */     //   4214: aload_0
/*      */     //   4215: getfield CJaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4218: fload #7
/*      */     //   4220: invokevirtual render : (F)V
/*      */     //   4223: aload_0
/*      */     //   4224: getfield CJaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4227: fload #7
/*      */     //   4229: invokevirtual render : (F)V
/*      */     //   4232: aload_0
/*      */     //   4233: getfield CJaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4236: fload #7
/*      */     //   4238: invokevirtual render : (F)V
/*      */     //   4241: aload_0
/*      */     //   4242: getfield RJaw1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4245: fload #7
/*      */     //   4247: invokevirtual render : (F)V
/*      */     //   4250: aload_0
/*      */     //   4251: getfield RJaw2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4254: fload #7
/*      */     //   4256: invokevirtual render : (F)V
/*      */     //   4259: aload_0
/*      */     //   4260: getfield RJaw3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4263: fload #7
/*      */     //   4265: invokevirtual render : (F)V
/*      */     //   4268: aload_0
/*      */     //   4269: getfield CTooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4272: fload #7
/*      */     //   4274: invokevirtual render : (F)V
/*      */     //   4277: aload_0
/*      */     //   4278: getfield CTooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4281: fload #7
/*      */     //   4283: invokevirtual render : (F)V
/*      */     //   4286: aload_0
/*      */     //   4287: getfield CTooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4290: fload #7
/*      */     //   4292: invokevirtual render : (F)V
/*      */     //   4295: aload_0
/*      */     //   4296: getfield CTooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4299: fload #7
/*      */     //   4301: invokevirtual render : (F)V
/*      */     //   4304: aload_0
/*      */     //   4305: getfield RTooth3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4308: fload #7
/*      */     //   4310: invokevirtual render : (F)V
/*      */     //   4313: aload_0
/*      */     //   4314: getfield RTooth4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4317: fload #7
/*      */     //   4319: invokevirtual render : (F)V
/*      */     //   4322: aload_0
/*      */     //   4323: getfield RTooth1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4326: fload #7
/*      */     //   4328: invokevirtual render : (F)V
/*      */     //   4331: aload_0
/*      */     //   4332: getfield RTooth2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4335: fload #7
/*      */     //   4337: invokevirtual render : (F)V
/*      */     //   4340: aload_0
/*      */     //   4341: getfield LLEye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4344: fload #7
/*      */     //   4346: invokevirtual render : (F)V
/*      */     //   4349: aload_0
/*      */     //   4350: getfield LREye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4353: fload #7
/*      */     //   4355: invokevirtual render : (F)V
/*      */     //   4358: aload_0
/*      */     //   4359: getfield CLEye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4362: fload #7
/*      */     //   4364: invokevirtual render : (F)V
/*      */     //   4367: aload_0
/*      */     //   4368: getfield CREye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4371: fload #7
/*      */     //   4373: invokevirtual render : (F)V
/*      */     //   4376: aload_0
/*      */     //   4377: getfield RLEye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4380: fload #7
/*      */     //   4382: invokevirtual render : (F)V
/*      */     //   4385: aload_0
/*      */     //   4386: getfield RREye : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4389: fload #7
/*      */     //   4391: invokevirtual render : (F)V
/*      */     //   4394: aload_0
/*      */     //   4395: getfield LHeadMane : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4398: fload #7
/*      */     //   4400: invokevirtual render : (F)V
/*      */     //   4403: aload_0
/*      */     //   4404: getfield CHeadMane : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4407: fload #7
/*      */     //   4409: invokevirtual render : (F)V
/*      */     //   4412: aload_0
/*      */     //   4413: getfield RHeadMane : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4416: fload #7
/*      */     //   4418: invokevirtual render : (F)V
/*      */     //   4421: aload_0
/*      */     //   4422: getfield LLNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4425: fload #7
/*      */     //   4427: invokevirtual render : (F)V
/*      */     //   4430: aload_0
/*      */     //   4431: getfield LRNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4434: fload #7
/*      */     //   4436: invokevirtual render : (F)V
/*      */     //   4439: aload_0
/*      */     //   4440: getfield CLNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4443: fload #7
/*      */     //   4445: invokevirtual render : (F)V
/*      */     //   4448: aload_0
/*      */     //   4449: getfield CRNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4452: fload #7
/*      */     //   4454: invokevirtual render : (F)V
/*      */     //   4457: aload_0
/*      */     //   4458: getfield RLNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4461: fload #7
/*      */     //   4463: invokevirtual render : (F)V
/*      */     //   4466: aload_0
/*      */     //   4467: getfield RRNoseSpike : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4470: fload #7
/*      */     //   4472: invokevirtual render : (F)V
/*      */     //   4475: aload_0
/*      */     //   4476: getfield Back1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4479: fload #7
/*      */     //   4481: invokevirtual render : (F)V
/*      */     //   4484: aload_0
/*      */     //   4485: getfield Back2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4488: fload #7
/*      */     //   4490: invokevirtual render : (F)V
/*      */     //   4493: aload_0
/*      */     //   4494: getfield Lwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4497: fload #7
/*      */     //   4499: invokevirtual render : (F)V
/*      */     //   4502: aload_0
/*      */     //   4503: getfield Lwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4506: fload #7
/*      */     //   4508: invokevirtual render : (F)V
/*      */     //   4511: aload_0
/*      */     //   4512: getfield Lwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4515: fload #7
/*      */     //   4517: invokevirtual render : (F)V
/*      */     //   4520: aload_0
/*      */     //   4521: getfield Lwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4524: fload #7
/*      */     //   4526: invokevirtual render : (F)V
/*      */     //   4529: aload_0
/*      */     //   4530: getfield Lwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4533: fload #7
/*      */     //   4535: invokevirtual render : (F)V
/*      */     //   4538: aload_0
/*      */     //   4539: getfield Rwing1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4542: fload #7
/*      */     //   4544: invokevirtual render : (F)V
/*      */     //   4547: aload_0
/*      */     //   4548: getfield Rwing3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4551: fload #7
/*      */     //   4553: invokevirtual render : (F)V
/*      */     //   4556: aload_0
/*      */     //   4557: getfield Rwing5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4560: fload #7
/*      */     //   4562: invokevirtual render : (F)V
/*      */     //   4565: aload_0
/*      */     //   4566: getfield Rwing7 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4569: fload #7
/*      */     //   4571: invokevirtual render : (F)V
/*      */     //   4574: aload_0
/*      */     //   4575: getfield Rwing9 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4578: fload #7
/*      */     //   4580: invokevirtual render : (F)V
/*      */     //   4583: aload_0
/*      */     //   4584: getfield TailTip2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4587: fload #7
/*      */     //   4589: invokevirtual render : (F)V
/*      */     //   4592: aload_0
/*      */     //   4593: getfield Ridge1 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4596: fload #7
/*      */     //   4598: invokevirtual render : (F)V
/*      */     //   4601: aload_0
/*      */     //   4602: getfield Ridge2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4605: fload #7
/*      */     //   4607: invokevirtual render : (F)V
/*      */     //   4610: aload_0
/*      */     //   4611: getfield Ridge3 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4614: fload #7
/*      */     //   4616: invokevirtual render : (F)V
/*      */     //   4619: aload_0
/*      */     //   4620: getfield Ridge4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4623: fload #7
/*      */     //   4625: invokevirtual render : (F)V
/*      */     //   4628: aload_0
/*      */     //   4629: getfield Ridge5 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4632: fload #7
/*      */     //   4634: invokevirtual render : (F)V
/*      */     //   4637: aload_0
/*      */     //   4638: getfield Ridge6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4641: fload #7
/*      */     //   4643: invokevirtual render : (F)V
/*      */     //   4646: invokestatic glPushMatrix : ()V
/*      */     //   4649: sipush #2977
/*      */     //   4652: invokestatic glEnable : (I)V
/*      */     //   4655: sipush #3042
/*      */     //   4658: invokestatic glEnable : (I)V
/*      */     //   4661: sipush #770
/*      */     //   4664: sipush #771
/*      */     //   4667: invokestatic glBlendFunc : (II)V
/*      */     //   4670: ldc_w 0.75
/*      */     //   4673: ldc_w 0.75
/*      */     //   4676: ldc_w 0.75
/*      */     //   4679: ldc_w 0.55
/*      */     //   4682: invokestatic glColor4f : (FFFF)V
/*      */     //   4685: aload_0
/*      */     //   4686: getfield Lwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4689: fload #7
/*      */     //   4691: invokevirtual render : (F)V
/*      */     //   4694: aload_0
/*      */     //   4695: getfield Lwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4698: fload #7
/*      */     //   4700: invokevirtual render : (F)V
/*      */     //   4703: aload_0
/*      */     //   4704: getfield Lwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4707: fload #7
/*      */     //   4709: invokevirtual render : (F)V
/*      */     //   4712: aload_0
/*      */     //   4713: getfield Lwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4716: fload #7
/*      */     //   4718: invokevirtual render : (F)V
/*      */     //   4721: aload_0
/*      */     //   4722: getfield Lwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4725: fload #7
/*      */     //   4727: invokevirtual render : (F)V
/*      */     //   4730: aload_0
/*      */     //   4731: getfield Rwing2 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4734: fload #7
/*      */     //   4736: invokevirtual render : (F)V
/*      */     //   4739: aload_0
/*      */     //   4740: getfield Rwing4 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4743: fload #7
/*      */     //   4745: invokevirtual render : (F)V
/*      */     //   4748: aload_0
/*      */     //   4749: getfield Rwing6 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4752: fload #7
/*      */     //   4754: invokevirtual render : (F)V
/*      */     //   4757: aload_0
/*      */     //   4758: getfield Rwing8 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4761: fload #7
/*      */     //   4763: invokevirtual render : (F)V
/*      */     //   4766: aload_0
/*      */     //   4767: getfield Rwing10 : Lnet/minecraft/client/model/ModelRenderer;
/*      */     //   4770: fload #7
/*      */     //   4772: invokevirtual render : (F)V
/*      */     //   4775: sipush #3042
/*      */     //   4778: invokestatic glDisable : (I)V
/*      */     //   4781: invokestatic glPopMatrix : ()V
/*      */     //   4784: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #861	-> 0
/*      */     //   #862	-> 3
/*      */     //   #863	-> 9
/*      */     //   #864	-> 14
/*      */     //   #865	-> 19
/*      */     //   #866	-> 23
/*      */     //   #867	-> 26
/*      */     //   #868	-> 29
/*      */     //   #869	-> 32
/*      */     //   #870	-> 35
/*      */     //   #871	-> 38
/*      */     //   #872	-> 41
/*      */     //   #873	-> 44
/*      */     //   #874	-> 47
/*      */     //   #876	-> 50
/*      */     //   #877	-> 65
/*      */     //   #879	-> 80
/*      */     //   #880	-> 88
/*      */     //   #882	-> 115
/*      */     //   #883	-> 139
/*      */     //   #884	-> 147
/*      */     //   #887	-> 173
/*      */     //   #888	-> 181
/*      */     //   #892	-> 184
/*      */     //   #893	-> 193
/*      */     //   #894	-> 202
/*      */     //   #895	-> 219
/*      */     //   #896	-> 250
/*      */     //   #897	-> 281
/*      */     //   #898	-> 295
/*      */     //   #899	-> 309
/*      */     //   #900	-> 323
/*      */     //   #901	-> 340
/*      */     //   #902	-> 371
/*      */     //   #903	-> 402
/*      */     //   #904	-> 416
/*      */     //   #905	-> 430
/*      */     //   #906	-> 444
/*      */     //   #907	-> 466
/*      */     //   #908	-> 488
/*      */     //   #909	-> 510
/*      */     //   #910	-> 532
/*      */     //   #911	-> 558
/*      */     //   #913	-> 584
/*      */     //   #914	-> 594
/*      */     //   #915	-> 604
/*      */     //   #916	-> 622
/*      */     //   #917	-> 653
/*      */     //   #918	-> 684
/*      */     //   #919	-> 698
/*      */     //   #920	-> 712
/*      */     //   #921	-> 726
/*      */     //   #922	-> 744
/*      */     //   #923	-> 775
/*      */     //   #924	-> 806
/*      */     //   #925	-> 820
/*      */     //   #926	-> 834
/*      */     //   #927	-> 848
/*      */     //   #928	-> 870
/*      */     //   #929	-> 892
/*      */     //   #930	-> 914
/*      */     //   #931	-> 936
/*      */     //   #932	-> 962
/*      */     //   #934	-> 988
/*      */     //   #935	-> 991
/*      */     //   #936	-> 999
/*      */     //   #939	-> 1023
/*      */     //   #941	-> 1044
/*      */     //   #942	-> 1057
/*      */     //   #943	-> 1070
/*      */     //   #944	-> 1083
/*      */     //   #945	-> 1096
/*      */     //   #946	-> 1109
/*      */     //   #948	-> 1122
/*      */     //   #949	-> 1135
/*      */     //   #950	-> 1148
/*      */     //   #951	-> 1161
/*      */     //   #952	-> 1174
/*      */     //   #953	-> 1187
/*      */     //   #955	-> 1200
/*      */     //   #956	-> 1203
/*      */     //   #957	-> 1211
/*      */     //   #959	-> 1238
/*      */     //   #960	-> 1246
/*      */     //   #961	-> 1254
/*      */     //   #966	-> 1280
/*      */     //   #967	-> 1305
/*      */     //   #968	-> 1328
/*      */     //   #969	-> 1367
/*      */     //   #970	-> 1406
/*      */     //   #971	-> 1449
/*      */     //   #972	-> 1492
/*      */     //   #973	-> 1514
/*      */     //   #974	-> 1536
/*      */     //   #975	-> 1558
/*      */     //   #976	-> 1580
/*      */     //   #977	-> 1615
/*      */     //   #981	-> 1650
/*      */     //   #982	-> 1675
/*      */     //   #983	-> 1698
/*      */     //   #984	-> 1737
/*      */     //   #985	-> 1776
/*      */     //   #986	-> 1819
/*      */     //   #987	-> 1862
/*      */     //   #988	-> 1884
/*      */     //   #989	-> 1906
/*      */     //   #990	-> 1928
/*      */     //   #991	-> 1950
/*      */     //   #992	-> 1985
/*      */     //   #995	-> 2020
/*      */     //   #996	-> 2028
/*      */     //   #997	-> 2033
/*      */     //   #999	-> 2038
/*      */     //   #1000	-> 2046
/*      */     //   #1001	-> 2049
/*      */     //   #1004	-> 2052
/*      */     //   #1005	-> 2081
/*      */     //   #1007	-> 2103
/*      */     //   #1008	-> 2134
/*      */     //   #1009	-> 2167
/*      */     //   #1011	-> 2197
/*      */     //   #1012	-> 2228
/*      */     //   #1013	-> 2259
/*      */     //   #1015	-> 2291
/*      */     //   #1016	-> 2322
/*      */     //   #1017	-> 2353
/*      */     //   #1019	-> 2387
/*      */     //   #1020	-> 2416
/*      */     //   #1021	-> 2422
/*      */     //   #1022	-> 2453
/*      */     //   #1023	-> 2484
/*      */     //   #1025	-> 2501
/*      */     //   #1026	-> 2532
/*      */     //   #1027	-> 2563
/*      */     //   #1029	-> 2580
/*      */     //   #1030	-> 2618
/*      */     //   #1031	-> 2656
/*      */     //   #1033	-> 2681
/*      */     //   #1034	-> 2720
/*      */     //   #1035	-> 2759
/*      */     //   #1037	-> 2784
/*      */     //   #1038	-> 2815
/*      */     //   #1039	-> 2846
/*      */     //   #1043	-> 2863
/*      */     //   #1044	-> 2871
/*      */     //   #1045	-> 2895
/*      */     //   #1046	-> 2910
/*      */     //   #1048	-> 2934
/*      */     //   #1049	-> 2958
/*      */     //   #1050	-> 2973
/*      */     //   #1052	-> 2997
/*      */     //   #1053	-> 3021
/*      */     //   #1054	-> 3036
/*      */     //   #1056	-> 3060
/*      */     //   #1057	-> 3068
/*      */     //   #1058	-> 3075
/*      */     //   #1059	-> 3083
/*      */     //   #1060	-> 3090
/*      */     //   #1061	-> 3098
/*      */     //   #1064	-> 3108
/*      */     //   #1065	-> 3116
/*      */     //   #1066	-> 3140
/*      */     //   #1067	-> 3155
/*      */     //   #1069	-> 3179
/*      */     //   #1070	-> 3203
/*      */     //   #1071	-> 3218
/*      */     //   #1073	-> 3242
/*      */     //   #1074	-> 3266
/*      */     //   #1075	-> 3281
/*      */     //   #1079	-> 3308
/*      */     //   #1080	-> 3323
/*      */     //   #1081	-> 3338
/*      */     //   #1083	-> 3353
/*      */     //   #1084	-> 3369
/*      */     //   #1085	-> 3385
/*      */     //   #1086	-> 3392
/*      */     //   #1087	-> 3401
/*      */     //   #1089	-> 3413
/*      */     //   #1090	-> 3422
/*      */     //   #1092	-> 3431
/*      */     //   #1093	-> 3440
/*      */     //   #1094	-> 3449
/*      */     //   #1095	-> 3458
/*      */     //   #1096	-> 3470
/*      */     //   #1097	-> 3482
/*      */     //   #1099	-> 3494
/*      */     //   #1100	-> 3518
/*      */     //   #1101	-> 3542
/*      */     //   #1104	-> 3566
/*      */     //   #1105	-> 3574
/*      */     //   #1106	-> 3581
/*      */     //   #1107	-> 3589
/*      */     //   #1108	-> 3596
/*      */     //   #1109	-> 3604
/*      */     //   #1113	-> 3611
/*      */     //   #1114	-> 3623
/*      */     //   #1117	-> 3635
/*      */     //   #1118	-> 3645
/*      */     //   #1119	-> 3655
/*      */     //   #1126	-> 3665
/*      */     //   #1127	-> 3674
/*      */     //   #1128	-> 3683
/*      */     //   #1129	-> 3692
/*      */     //   #1130	-> 3701
/*      */     //   #1131	-> 3710
/*      */     //   #1132	-> 3719
/*      */     //   #1133	-> 3728
/*      */     //   #1134	-> 3737
/*      */     //   #1135	-> 3746
/*      */     //   #1136	-> 3755
/*      */     //   #1137	-> 3764
/*      */     //   #1138	-> 3773
/*      */     //   #1139	-> 3782
/*      */     //   #1140	-> 3791
/*      */     //   #1141	-> 3800
/*      */     //   #1142	-> 3809
/*      */     //   #1143	-> 3818
/*      */     //   #1144	-> 3827
/*      */     //   #1145	-> 3836
/*      */     //   #1146	-> 3845
/*      */     //   #1147	-> 3854
/*      */     //   #1148	-> 3863
/*      */     //   #1149	-> 3872
/*      */     //   #1150	-> 3881
/*      */     //   #1151	-> 3890
/*      */     //   #1152	-> 3899
/*      */     //   #1153	-> 3908
/*      */     //   #1154	-> 3917
/*      */     //   #1155	-> 3926
/*      */     //   #1156	-> 3935
/*      */     //   #1157	-> 3944
/*      */     //   #1158	-> 3953
/*      */     //   #1159	-> 3962
/*      */     //   #1160	-> 3971
/*      */     //   #1161	-> 3980
/*      */     //   #1162	-> 3989
/*      */     //   #1163	-> 3998
/*      */     //   #1164	-> 4007
/*      */     //   #1165	-> 4016
/*      */     //   #1166	-> 4025
/*      */     //   #1167	-> 4034
/*      */     //   #1168	-> 4043
/*      */     //   #1169	-> 4052
/*      */     //   #1170	-> 4061
/*      */     //   #1171	-> 4070
/*      */     //   #1172	-> 4079
/*      */     //   #1173	-> 4088
/*      */     //   #1174	-> 4097
/*      */     //   #1175	-> 4106
/*      */     //   #1176	-> 4115
/*      */     //   #1177	-> 4124
/*      */     //   #1178	-> 4133
/*      */     //   #1179	-> 4142
/*      */     //   #1180	-> 4151
/*      */     //   #1181	-> 4160
/*      */     //   #1182	-> 4169
/*      */     //   #1183	-> 4178
/*      */     //   #1184	-> 4187
/*      */     //   #1185	-> 4196
/*      */     //   #1186	-> 4205
/*      */     //   #1187	-> 4214
/*      */     //   #1188	-> 4223
/*      */     //   #1189	-> 4232
/*      */     //   #1190	-> 4241
/*      */     //   #1191	-> 4250
/*      */     //   #1192	-> 4259
/*      */     //   #1193	-> 4268
/*      */     //   #1194	-> 4277
/*      */     //   #1195	-> 4286
/*      */     //   #1196	-> 4295
/*      */     //   #1197	-> 4304
/*      */     //   #1198	-> 4313
/*      */     //   #1199	-> 4322
/*      */     //   #1200	-> 4331
/*      */     //   #1201	-> 4340
/*      */     //   #1202	-> 4349
/*      */     //   #1203	-> 4358
/*      */     //   #1204	-> 4367
/*      */     //   #1205	-> 4376
/*      */     //   #1206	-> 4385
/*      */     //   #1207	-> 4394
/*      */     //   #1208	-> 4403
/*      */     //   #1209	-> 4412
/*      */     //   #1210	-> 4421
/*      */     //   #1211	-> 4430
/*      */     //   #1212	-> 4439
/*      */     //   #1213	-> 4448
/*      */     //   #1214	-> 4457
/*      */     //   #1215	-> 4466
/*      */     //   #1216	-> 4475
/*      */     //   #1217	-> 4484
/*      */     //   #1218	-> 4493
/*      */     //   #1219	-> 4502
/*      */     //   #1220	-> 4511
/*      */     //   #1221	-> 4520
/*      */     //   #1222	-> 4529
/*      */     //   #1223	-> 4538
/*      */     //   #1224	-> 4547
/*      */     //   #1225	-> 4556
/*      */     //   #1226	-> 4565
/*      */     //   #1227	-> 4574
/*      */     //   #1228	-> 4583
/*      */     //   #1229	-> 4592
/*      */     //   #1230	-> 4601
/*      */     //   #1231	-> 4610
/*      */     //   #1232	-> 4619
/*      */     //   #1233	-> 4628
/*      */     //   #1234	-> 4637
/*      */     //   #1236	-> 4646
/*      */     //   #1237	-> 4649
/*      */     //   #1238	-> 4655
/*      */     //   #1239	-> 4661
/*      */     //   #1241	-> 4670
/*      */     //   #1242	-> 4685
/*      */     //   #1243	-> 4694
/*      */     //   #1244	-> 4703
/*      */     //   #1245	-> 4712
/*      */     //   #1246	-> 4721
/*      */     //   #1247	-> 4730
/*      */     //   #1248	-> 4739
/*      */     //   #1249	-> 4748
/*      */     //   #1250	-> 4757
/*      */     //   #1251	-> 4766
/*      */     //   #1252	-> 4775
/*      */     //   #1253	-> 4781
/*      */     //   #1257	-> 4784
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   3369	197	22	h1	F
/*      */     //   3367	199	23	h2	F
/*      */     //   3364	202	24	h3	F
/*      */     //   3385	181	25	d1	F
/*      */     //   3383	183	26	d2	F
/*      */     //   3380	186	27	d3	F
/*      */     //   0	4785	0	this	Ldanger/orespawn/ModelThePrinceAdult;
/*      */     //   0	4785	1	entity	Lnet/minecraft/entity/Entity;
/*      */     //   0	4785	2	f	F
/*      */     //   0	4785	3	f1	F
/*      */     //   0	4785	4	f2	F
/*      */     //   0	4785	5	f3	F
/*      */     //   0	4785	6	f4	F
/*      */     //   0	4785	7	f5	F
/*      */     //   3	4782	8	newangle	F
/*      */     //   9	4776	9	k	Ldanger/orespawn/ThePrinceAdult;
/*      */     //   14	4771	10	tailspeed	F
/*      */     //   19	4766	11	tailamp	F
/*      */     //   23	4762	12	pi4	F
/*      */     //   26	4759	13	Lheadlr	F
/*      */     //   29	4756	14	Lheadud	F
/*      */     //   32	4753	15	Ljawangle	F
/*      */     //   35	4750	16	Cheadlr	F
/*      */     //   38	4747	17	Cheadud	F
/*      */     //   41	4744	18	Cjawangle	F
/*      */     //   44	4741	19	Rheadlr	F
/*      */     //   47	4738	20	Rheadud	F
/*      */     //   50	4735	21	Rjawangle	F
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 1261 */     model.rotateAngleX = x;
/* 1262 */     model.rotateAngleY = y;
/* 1263 */     model.rotateAngleZ = z;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 1268 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveLeftHead(float Lheadlr, float Lheadud, float Ljawangle) {
/* 1276 */     this.LJaw1.rotateAngleX = Ljawangle;
/* 1277 */     this.LJaw2.rotateAngleX = Ljawangle;
/* 1278 */     this.LJaw3.rotateAngleX = Ljawangle;
/* 1279 */     this.LTooth1.rotateAngleX = Ljawangle;
/* 1280 */     this.LTooth2.rotateAngleX = Ljawangle;
/* 1281 */     this.LTooth3.rotateAngleX = Ljawangle;
/* 1282 */     this.LTooth4.rotateAngleX = Ljawangle;
/*      */ 
/*      */ 
/*      */     
/* 1286 */     this.NeckL1.rotateAngleY = Lheadlr * 0.125F;
/* 1287 */     this.NeckL1.rotationPointZ -= (float)Math.cos(this.NeckL1.rotateAngleY) * 20.0F;
/* 1288 */     this.NeckL1.rotationPointX -= (float)Math.sin(this.NeckL1.rotateAngleY) * 20.0F;
/* 1289 */     this.NeckL2.rotateAngleY = Lheadlr * 0.25F;
/* 1290 */     this.NeckL2.rotationPointZ -= (float)Math.cos(this.NeckL2.rotateAngleY) * 36.0F;
/* 1291 */     this.NeckL2.rotationPointX -= (float)Math.sin(this.NeckL2.rotateAngleY) * 36.0F;
/* 1292 */     this.NeckL3.rotateAngleY = Lheadlr * 0.38F;
/* 1293 */     this.NeckL3.rotationPointZ -= (float)Math.cos(this.NeckL3.rotateAngleY) * 36.0F;
/* 1294 */     this.NeckL3.rotationPointX -= (float)Math.sin(this.NeckL3.rotateAngleY) * 36.0F;
/* 1295 */     this.NeckL4.rotateAngleY = Lheadlr * 0.5F;
/* 1296 */     this.NeckL4.rotationPointZ -= (float)Math.cos(this.NeckL4.rotateAngleY) * 36.0F;
/* 1297 */     this.NeckL4.rotationPointX -= (float)Math.sin(this.NeckL4.rotateAngleY) * 36.0F;
/* 1298 */     this.LHead1.rotateAngleY = Lheadlr;
/*      */     
/* 1300 */     this.LHead2.rotateAngleY = Lheadlr;
/* 1301 */     this.LHead2.rotationPointZ = this.LHead1.rotationPointZ;
/* 1302 */     this.LHead2.rotationPointX = this.LHead1.rotationPointX;
/* 1303 */     this.LHead3.rotateAngleY = Lheadlr;
/* 1304 */     this.LHead3.rotationPointZ = this.LHead1.rotationPointZ;
/* 1305 */     this.LHead3.rotationPointX = this.LHead1.rotationPointX;
/* 1306 */     this.LHeadMane.rotateAngleY = Lheadlr;
/* 1307 */     this.LHeadMane.rotationPointZ = this.LHead1.rotationPointZ;
/* 1308 */     this.LHeadMane.rotationPointX = this.LHead1.rotationPointX;
/* 1309 */     this.LLEye.rotateAngleY = Lheadlr;
/* 1310 */     this.LLEye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1311 */     this.LLEye.rotationPointX = this.LHead1.rotationPointX;
/* 1312 */     this.LREye.rotateAngleY = Lheadlr;
/* 1313 */     this.LREye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1314 */     this.LREye.rotationPointX = this.LHead1.rotationPointX;
/* 1315 */     this.LLNoseSpike.rotateAngleY = 0.244F + Lheadlr;
/* 1316 */     this.LLNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1317 */     this.LLNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/* 1318 */     this.LRNoseSpike.rotateAngleY = -0.261F + Lheadlr;
/* 1319 */     this.LRNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1320 */     this.LRNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/*      */ 
/*      */     
/* 1323 */     this.LJaw1.rotateAngleY = Lheadlr;
/* 1324 */     this.LJaw2.rotateAngleY = Lheadlr;
/* 1325 */     this.LJaw3.rotateAngleY = Lheadlr;
/* 1326 */     this.LTooth1.rotateAngleY = Lheadlr;
/* 1327 */     this.LTooth2.rotateAngleY = Lheadlr;
/* 1328 */     this.LTooth3.rotateAngleY = Lheadlr;
/* 1329 */     this.LTooth4.rotateAngleY = Lheadlr;
/*      */ 
/*      */ 
/*      */     
/* 1333 */     this.NeckL1.rotateAngleX = Lheadud * 0.125F;
/* 1334 */     this.NeckL1.rotationPointY += (float)Math.sin(this.NeckL1.rotateAngleX) * 20.0F;
/* 1335 */     this.NeckL1.rotationPointZ += (this.NeckL2.rotationPointZ - this.NeckL1.rotationPointZ) * (float)Math.cos(this.NeckL1.rotateAngleX);
/* 1336 */     this.NeckL1.rotationPointX += (this.NeckL2.rotationPointX - this.NeckL1.rotationPointX) * (float)Math.cos(this.NeckL1.rotateAngleX);
/* 1337 */     this.NeckL2.rotateAngleX = Lheadud * 0.25F;
/* 1338 */     this.NeckL2.rotationPointY += (float)Math.sin(this.NeckL2.rotateAngleX) * 36.0F;
/* 1339 */     this.NeckL2.rotationPointZ += (this.NeckL3.rotationPointZ - this.NeckL2.rotationPointZ) * (float)Math.cos(this.NeckL2.rotateAngleX);
/* 1340 */     this.NeckL2.rotationPointX += (this.NeckL3.rotationPointX - this.NeckL2.rotationPointX) * (float)Math.cos(this.NeckL2.rotateAngleX);
/* 1341 */     this.NeckL3.rotateAngleX = Lheadud * 0.38F;
/* 1342 */     this.NeckL3.rotationPointY += (float)Math.sin(this.NeckL3.rotateAngleX) * 36.0F;
/* 1343 */     this.NeckL3.rotationPointZ += (this.NeckL4.rotationPointZ - this.NeckL3.rotationPointZ) * (float)Math.cos(this.NeckL3.rotateAngleX);
/* 1344 */     this.NeckL3.rotationPointX += (this.NeckL4.rotationPointX - this.NeckL3.rotationPointX) * (float)Math.cos(this.NeckL3.rotateAngleX);
/* 1345 */     this.NeckL4.rotateAngleX = Lheadud * 0.5F;
/* 1346 */     this.NeckL4.rotationPointY += (float)Math.sin(this.NeckL4.rotateAngleX) * 36.0F;
/* 1347 */     this.NeckL4.rotationPointZ += (this.LHead1.rotationPointZ - this.NeckL4.rotationPointZ) * (float)Math.cos(this.NeckL4.rotateAngleX);
/* 1348 */     this.NeckL4.rotationPointX += (this.LHead1.rotationPointX - this.NeckL4.rotationPointX) * (float)Math.cos(this.NeckL4.rotateAngleX);
/* 1349 */     this.LHead1.rotateAngleX = Lheadud;
/*      */     
/* 1351 */     this.LHead2.rotateAngleX = Lheadud;
/* 1352 */     this.LHead2.rotationPointZ = this.LHead1.rotationPointZ;
/* 1353 */     this.LHead2.rotationPointX = this.LHead1.rotationPointX;
/* 1354 */     this.LHead2.rotationPointY = this.LHead1.rotationPointY;
/* 1355 */     this.LHead3.rotateAngleX = Lheadud;
/* 1356 */     this.LHead3.rotationPointZ = this.LHead1.rotationPointZ;
/* 1357 */     this.LHead3.rotationPointX = this.LHead1.rotationPointX;
/* 1358 */     this.LHead3.rotationPointY = this.LHead1.rotationPointY;
/* 1359 */     this.LHeadMane.rotateAngleX = 0.384F + Lheadud;
/* 1360 */     this.LHeadMane.rotationPointZ = this.LHead1.rotationPointZ;
/* 1361 */     this.LHeadMane.rotationPointX = this.LHead1.rotationPointX;
/* 1362 */     this.LHeadMane.rotationPointY = this.LHead1.rotationPointY;
/* 1363 */     this.LLEye.rotateAngleX = Lheadud;
/* 1364 */     this.LLEye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1365 */     this.LLEye.rotationPointX = this.LHead1.rotationPointX;
/* 1366 */     this.LLEye.rotationPointY = this.LHead1.rotationPointY;
/* 1367 */     this.LREye.rotateAngleX = Lheadud;
/* 1368 */     this.LREye.rotationPointZ = this.LHead1.rotationPointZ;
/* 1369 */     this.LREye.rotationPointX = this.LHead1.rotationPointX;
/* 1370 */     this.LREye.rotationPointY = this.LHead1.rotationPointY;
/* 1371 */     this.LLNoseSpike.rotateAngleX = 0.244F + Lheadud;
/* 1372 */     this.LLNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1373 */     this.LLNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/* 1374 */     this.LLNoseSpike.rotationPointY = this.LHead1.rotationPointY;
/* 1375 */     this.LRNoseSpike.rotateAngleX = 0.261F + Lheadud;
/* 1376 */     this.LRNoseSpike.rotationPointZ = this.LHead1.rotationPointZ;
/* 1377 */     this.LRNoseSpike.rotationPointX = this.LHead1.rotationPointX;
/* 1378 */     this.LRNoseSpike.rotationPointY = this.LHead1.rotationPointY;
/*      */ 
/*      */     
/* 1381 */     this.LHead1.rotationPointY += (float)Math.cos(this.LHead1.rotateAngleX) * 14.0F;
/* 1382 */     this.NeckL4.rotationPointZ += -38.0F * (float)Math.cos(this.NeckL4.rotateAngleX);
/* 1383 */     this.LJaw1.rotationPointZ += (float)Math.sin(this.LHead1.rotateAngleX) * 12.0F;
/* 1384 */     this.LJaw1.rotationPointX = (float)(this.LHead1.rotationPointX - Math.sin(this.LHead1.rotateAngleY) * 7.0D);
/*      */     
/* 1386 */     this.LJaw2.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1387 */     this.LJaw2.rotationPointX = this.LJaw1.rotationPointX;
/* 1388 */     this.LJaw2.rotationPointY = this.LJaw1.rotationPointY;
/* 1389 */     this.LJaw3.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1390 */     this.LJaw3.rotationPointX = this.LJaw1.rotationPointX;
/* 1391 */     this.LJaw3.rotationPointY = this.LJaw1.rotationPointY;
/* 1392 */     this.LTooth1.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1393 */     this.LTooth1.rotationPointX = this.LJaw1.rotationPointX;
/* 1394 */     this.LTooth1.rotationPointY = this.LJaw1.rotationPointY;
/* 1395 */     this.LTooth2.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1396 */     this.LTooth2.rotationPointX = this.LJaw1.rotationPointX;
/* 1397 */     this.LTooth2.rotationPointY = this.LJaw1.rotationPointY;
/* 1398 */     this.LTooth3.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1399 */     this.LTooth3.rotationPointX = this.LJaw1.rotationPointX;
/* 1400 */     this.LTooth3.rotationPointY = this.LJaw1.rotationPointY;
/* 1401 */     this.LTooth4.rotationPointZ = this.LJaw1.rotationPointZ;
/* 1402 */     this.LTooth4.rotationPointX = this.LJaw1.rotationPointX;
/* 1403 */     this.LTooth4.rotationPointY = this.LJaw1.rotationPointY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveCenterHead(float Cheadlr, float Cheadud, float Cjawangle) {
/* 1411 */     this.CJaw1.rotateAngleX = Cjawangle;
/* 1412 */     this.CJaw2.rotateAngleX = Cjawangle;
/* 1413 */     this.CJaw3.rotateAngleX = Cjawangle;
/* 1414 */     this.CTooth1.rotateAngleX = Cjawangle;
/* 1415 */     this.CTooth2.rotateAngleX = Cjawangle;
/* 1416 */     this.CTooth3.rotateAngleX = Cjawangle;
/* 1417 */     this.CTooth4.rotateAngleX = Cjawangle;
/*      */ 
/*      */ 
/*      */     
/* 1421 */     this.NeckC1.rotateAngleY = Cheadlr * 0.125F;
/* 1422 */     this.NeckC1.rotationPointZ -= (float)Math.cos(this.NeckC1.rotateAngleY) * 20.0F;
/* 1423 */     this.NeckC1.rotationPointX -= (float)Math.sin(this.NeckC1.rotateAngleY) * 20.0F;
/* 1424 */     this.NeckC2.rotateAngleY = Cheadlr * 0.25F;
/* 1425 */     this.NeckC2.rotationPointZ -= (float)Math.cos(this.NeckC2.rotateAngleY) * 36.0F;
/* 1426 */     this.NeckC2.rotationPointX -= (float)Math.sin(this.NeckC2.rotateAngleY) * 36.0F;
/* 1427 */     this.NeckC3.rotateAngleY = Cheadlr * 0.38F;
/* 1428 */     this.NeckC3.rotationPointZ -= (float)Math.cos(this.NeckC3.rotateAngleY) * 36.0F;
/* 1429 */     this.NeckC3.rotationPointX -= (float)Math.sin(this.NeckC3.rotateAngleY) * 36.0F;
/* 1430 */     this.NeckC4.rotateAngleY = Cheadlr * 0.5F;
/* 1431 */     this.NeckC4.rotationPointZ -= (float)Math.cos(this.NeckC4.rotateAngleY) * 36.0F;
/* 1432 */     this.NeckC4.rotationPointX -= (float)Math.sin(this.NeckC4.rotateAngleY) * 36.0F;
/* 1433 */     this.CHead1.rotateAngleY = Cheadlr;
/*      */     
/* 1435 */     this.CHead2.rotateAngleY = Cheadlr;
/* 1436 */     this.CHead2.rotationPointZ = this.CHead1.rotationPointZ;
/* 1437 */     this.CHead2.rotationPointX = this.CHead1.rotationPointX;
/* 1438 */     this.CHead3.rotateAngleY = Cheadlr;
/* 1439 */     this.CHead3.rotationPointZ = this.CHead1.rotationPointZ;
/* 1440 */     this.CHead3.rotationPointX = this.CHead1.rotationPointX;
/* 1441 */     this.CHeadMane.rotateAngleY = Cheadlr;
/* 1442 */     this.CHeadMane.rotationPointZ = this.CHead1.rotationPointZ;
/* 1443 */     this.CHeadMane.rotationPointX = this.CHead1.rotationPointX;
/* 1444 */     this.CLEye.rotateAngleY = Cheadlr;
/* 1445 */     this.CLEye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1446 */     this.CLEye.rotationPointX = this.CHead1.rotationPointX;
/* 1447 */     this.CREye.rotateAngleY = Cheadlr;
/* 1448 */     this.CREye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1449 */     this.CREye.rotationPointX = this.CHead1.rotationPointX;
/* 1450 */     this.CLNoseSpike.rotateAngleY = 0.244F + Cheadlr;
/* 1451 */     this.CLNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1452 */     this.CLNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/* 1453 */     this.CRNoseSpike.rotateAngleY = -0.261F + Cheadlr;
/* 1454 */     this.CRNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1455 */     this.CRNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/*      */ 
/*      */     
/* 1458 */     this.CJaw1.rotateAngleY = Cheadlr;
/* 1459 */     this.CJaw2.rotateAngleY = Cheadlr;
/* 1460 */     this.CJaw3.rotateAngleY = Cheadlr;
/* 1461 */     this.CTooth1.rotateAngleY = Cheadlr;
/* 1462 */     this.CTooth2.rotateAngleY = Cheadlr;
/* 1463 */     this.CTooth3.rotateAngleY = Cheadlr;
/* 1464 */     this.CTooth4.rotateAngleY = Cheadlr;
/*      */ 
/*      */ 
/*      */     
/* 1468 */     this.NeckC1.rotateAngleX = Cheadud * 0.125F;
/* 1469 */     this.NeckC1.rotationPointY += (float)Math.sin(this.NeckC1.rotateAngleX) * 20.0F;
/* 1470 */     this.NeckC1.rotationPointZ += (this.NeckC2.rotationPointZ - this.NeckC1.rotationPointZ) * (float)Math.cos(this.NeckC1.rotateAngleX);
/* 1471 */     this.NeckC1.rotationPointX += (this.NeckC2.rotationPointX - this.NeckC1.rotationPointX) * (float)Math.cos(this.NeckC1.rotateAngleX);
/* 1472 */     this.NeckC2.rotateAngleX = Cheadud * 0.25F;
/* 1473 */     this.NeckC2.rotationPointY += (float)Math.sin(this.NeckC2.rotateAngleX) * 36.0F;
/* 1474 */     this.NeckC2.rotationPointZ += (this.NeckC3.rotationPointZ - this.NeckC2.rotationPointZ) * (float)Math.cos(this.NeckC2.rotateAngleX);
/* 1475 */     this.NeckC2.rotationPointX += (this.NeckC3.rotationPointX - this.NeckC2.rotationPointX) * (float)Math.cos(this.NeckC2.rotateAngleX);
/* 1476 */     this.NeckC3.rotateAngleX = Cheadud * 0.38F;
/* 1477 */     this.NeckC3.rotationPointY += (float)Math.sin(this.NeckC3.rotateAngleX) * 36.0F;
/* 1478 */     this.NeckC3.rotationPointZ += (this.NeckC4.rotationPointZ - this.NeckC3.rotationPointZ) * (float)Math.cos(this.NeckC3.rotateAngleX);
/* 1479 */     this.NeckC3.rotationPointX += (this.NeckC4.rotationPointX - this.NeckC3.rotationPointX) * (float)Math.cos(this.NeckC3.rotateAngleX);
/* 1480 */     this.NeckC4.rotateAngleX = Cheadud * 0.5F;
/* 1481 */     this.NeckC4.rotationPointY += (float)Math.sin(this.NeckC4.rotateAngleX) * 36.0F;
/* 1482 */     this.NeckC4.rotationPointZ += (this.CHead1.rotationPointZ - this.NeckC4.rotationPointZ) * (float)Math.cos(this.NeckC4.rotateAngleX);
/* 1483 */     this.NeckC4.rotationPointX += (this.CHead1.rotationPointX - this.NeckC4.rotationPointX) * (float)Math.cos(this.NeckC4.rotateAngleX);
/* 1484 */     this.CHead1.rotateAngleX = Cheadud;
/*      */     
/* 1486 */     this.CHead2.rotateAngleX = Cheadud;
/* 1487 */     this.CHead2.rotationPointZ = this.CHead1.rotationPointZ;
/* 1488 */     this.CHead2.rotationPointX = this.CHead1.rotationPointX;
/* 1489 */     this.CHead2.rotationPointY = this.CHead1.rotationPointY;
/* 1490 */     this.CHead3.rotateAngleX = Cheadud;
/* 1491 */     this.CHead3.rotationPointZ = this.CHead1.rotationPointZ;
/* 1492 */     this.CHead3.rotationPointX = this.CHead1.rotationPointX;
/* 1493 */     this.CHead3.rotationPointY = this.CHead1.rotationPointY;
/* 1494 */     this.CHeadMane.rotateAngleX = 0.384F + Cheadud;
/* 1495 */     this.CHeadMane.rotationPointZ = this.CHead1.rotationPointZ;
/* 1496 */     this.CHeadMane.rotationPointX = this.CHead1.rotationPointX;
/* 1497 */     this.CHeadMane.rotationPointY = this.CHead1.rotationPointY;
/* 1498 */     this.CLEye.rotateAngleX = Cheadud;
/* 1499 */     this.CLEye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1500 */     this.CLEye.rotationPointX = this.CHead1.rotationPointX;
/* 1501 */     this.CLEye.rotationPointY = this.CHead1.rotationPointY;
/* 1502 */     this.CREye.rotateAngleX = Cheadud;
/* 1503 */     this.CREye.rotationPointZ = this.CHead1.rotationPointZ;
/* 1504 */     this.CREye.rotationPointX = this.CHead1.rotationPointX;
/* 1505 */     this.CREye.rotationPointY = this.CHead1.rotationPointY;
/* 1506 */     this.CLNoseSpike.rotateAngleX = 0.244F + Cheadud;
/* 1507 */     this.CLNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1508 */     this.CLNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/* 1509 */     this.CLNoseSpike.rotationPointY = this.CHead1.rotationPointY;
/* 1510 */     this.CRNoseSpike.rotateAngleX = 0.261F + Cheadud;
/* 1511 */     this.CRNoseSpike.rotationPointZ = this.CHead1.rotationPointZ;
/* 1512 */     this.CRNoseSpike.rotationPointX = this.CHead1.rotationPointX;
/* 1513 */     this.CRNoseSpike.rotationPointY = this.CHead1.rotationPointY;
/*      */ 
/*      */     
/* 1516 */     this.CHead1.rotationPointY += (float)Math.cos(this.CHead1.rotateAngleX) * 14.0F;
/* 1517 */     this.NeckC4.rotationPointZ += -38.0F * (float)Math.cos(this.NeckC4.rotateAngleX);
/* 1518 */     this.CJaw1.rotationPointZ += (float)Math.sin(this.CHead1.rotateAngleX) * 12.0F;
/* 1519 */     this.CJaw1.rotationPointX = (float)(this.CHead1.rotationPointX - Math.sin(this.CHead1.rotateAngleY) * 7.0D);
/*      */     
/* 1521 */     this.CJaw2.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1522 */     this.CJaw2.rotationPointX = this.CJaw1.rotationPointX;
/* 1523 */     this.CJaw2.rotationPointY = this.CJaw1.rotationPointY;
/* 1524 */     this.CJaw3.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1525 */     this.CJaw3.rotationPointX = this.CJaw1.rotationPointX;
/* 1526 */     this.CJaw3.rotationPointY = this.CJaw1.rotationPointY;
/* 1527 */     this.CTooth1.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1528 */     this.CTooth1.rotationPointX = this.CJaw1.rotationPointX;
/* 1529 */     this.CTooth1.rotationPointY = this.CJaw1.rotationPointY;
/* 1530 */     this.CTooth2.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1531 */     this.CTooth2.rotationPointX = this.CJaw1.rotationPointX;
/* 1532 */     this.CTooth2.rotationPointY = this.CJaw1.rotationPointY;
/* 1533 */     this.CTooth3.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1534 */     this.CTooth3.rotationPointX = this.CJaw1.rotationPointX;
/* 1535 */     this.CTooth3.rotationPointY = this.CJaw1.rotationPointY;
/* 1536 */     this.CTooth4.rotationPointZ = this.CJaw1.rotationPointZ;
/* 1537 */     this.CTooth4.rotationPointX = this.CJaw1.rotationPointX;
/* 1538 */     this.CTooth4.rotationPointY = this.CJaw1.rotationPointY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveRightHead(float Rheadlr, float Rheadud, float Rjawangle) {
/* 1546 */     this.RJaw1.rotateAngleX = Rjawangle;
/* 1547 */     this.RJaw2.rotateAngleX = Rjawangle;
/* 1548 */     this.RJaw3.rotateAngleX = Rjawangle;
/* 1549 */     this.RTooth1.rotateAngleX = Rjawangle;
/* 1550 */     this.RTooth2.rotateAngleX = Rjawangle;
/* 1551 */     this.RTooth3.rotateAngleX = Rjawangle;
/* 1552 */     this.RTooth4.rotateAngleX = Rjawangle;
/*      */ 
/*      */ 
/*      */     
/* 1556 */     this.NeckR1.rotateAngleY = Rheadlr * 0.125F;
/* 1557 */     this.NeckR1.rotationPointZ -= (float)Math.cos(this.NeckR1.rotateAngleY) * 20.0F;
/* 1558 */     this.NeckR1.rotationPointX -= (float)Math.sin(this.NeckR1.rotateAngleY) * 20.0F;
/* 1559 */     this.NeckR2.rotateAngleY = Rheadlr * 0.25F;
/* 1560 */     this.NeckR2.rotationPointZ -= (float)Math.cos(this.NeckR2.rotateAngleY) * 36.0F;
/* 1561 */     this.NeckR2.rotationPointX -= (float)Math.sin(this.NeckR2.rotateAngleY) * 36.0F;
/* 1562 */     this.NeckR3.rotateAngleY = Rheadlr * 0.38F;
/* 1563 */     this.NeckR3.rotationPointZ -= (float)Math.cos(this.NeckR3.rotateAngleY) * 36.0F;
/* 1564 */     this.NeckR3.rotationPointX -= (float)Math.sin(this.NeckR3.rotateAngleY) * 36.0F;
/* 1565 */     this.NeckR4.rotateAngleY = Rheadlr * 0.5F;
/* 1566 */     this.NeckR4.rotationPointZ -= (float)Math.cos(this.NeckR4.rotateAngleY) * 36.0F;
/* 1567 */     this.NeckR4.rotationPointX -= (float)Math.sin(this.NeckR4.rotateAngleY) * 36.0F;
/* 1568 */     this.RHead1.rotateAngleY = Rheadlr;
/*      */     
/* 1570 */     this.RHead2.rotateAngleY = Rheadlr;
/* 1571 */     this.RHead2.rotationPointZ = this.RHead1.rotationPointZ;
/* 1572 */     this.RHead2.rotationPointX = this.RHead1.rotationPointX;
/* 1573 */     this.RHead3.rotateAngleY = Rheadlr;
/* 1574 */     this.RHead3.rotationPointZ = this.RHead1.rotationPointZ;
/* 1575 */     this.RHead3.rotationPointX = this.RHead1.rotationPointX;
/* 1576 */     this.RHeadMane.rotateAngleY = Rheadlr;
/* 1577 */     this.RHeadMane.rotationPointZ = this.RHead1.rotationPointZ;
/* 1578 */     this.RHeadMane.rotationPointX = this.RHead1.rotationPointX;
/* 1579 */     this.RLEye.rotateAngleY = Rheadlr;
/* 1580 */     this.RLEye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1581 */     this.RLEye.rotationPointX = this.RHead1.rotationPointX;
/* 1582 */     this.RREye.rotateAngleY = Rheadlr;
/* 1583 */     this.RREye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1584 */     this.RREye.rotationPointX = this.RHead1.rotationPointX;
/* 1585 */     this.RLNoseSpike.rotateAngleY = 0.244F + Rheadlr;
/* 1586 */     this.RLNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1587 */     this.RLNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/* 1588 */     this.RRNoseSpike.rotateAngleY = -0.261F + Rheadlr;
/* 1589 */     this.RRNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1590 */     this.RRNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/*      */ 
/*      */     
/* 1593 */     this.RJaw1.rotateAngleY = Rheadlr;
/* 1594 */     this.RJaw2.rotateAngleY = Rheadlr;
/* 1595 */     this.RJaw3.rotateAngleY = Rheadlr;
/* 1596 */     this.RTooth1.rotateAngleY = Rheadlr;
/* 1597 */     this.RTooth2.rotateAngleY = Rheadlr;
/* 1598 */     this.RTooth3.rotateAngleY = Rheadlr;
/* 1599 */     this.RTooth4.rotateAngleY = Rheadlr;
/*      */ 
/*      */ 
/*      */     
/* 1603 */     this.NeckR1.rotateAngleX = Rheadud * 0.125F;
/* 1604 */     this.NeckR1.rotationPointY += (float)Math.sin(this.NeckR1.rotateAngleX) * 20.0F;
/* 1605 */     this.NeckR1.rotationPointZ += (this.NeckR2.rotationPointZ - this.NeckR1.rotationPointZ) * (float)Math.cos(this.NeckR1.rotateAngleX);
/* 1606 */     this.NeckR1.rotationPointX += (this.NeckR2.rotationPointX - this.NeckR1.rotationPointX) * (float)Math.cos(this.NeckR1.rotateAngleX);
/* 1607 */     this.NeckR2.rotateAngleX = Rheadud * 0.25F;
/* 1608 */     this.NeckR2.rotationPointY += (float)Math.sin(this.NeckR2.rotateAngleX) * 36.0F;
/* 1609 */     this.NeckR2.rotationPointZ += (this.NeckR3.rotationPointZ - this.NeckR2.rotationPointZ) * (float)Math.cos(this.NeckR2.rotateAngleX);
/* 1610 */     this.NeckR2.rotationPointX += (this.NeckR3.rotationPointX - this.NeckR2.rotationPointX) * (float)Math.cos(this.NeckR2.rotateAngleX);
/* 1611 */     this.NeckR3.rotateAngleX = Rheadud * 0.38F;
/* 1612 */     this.NeckR3.rotationPointY += (float)Math.sin(this.NeckR3.rotateAngleX) * 36.0F;
/* 1613 */     this.NeckR3.rotationPointZ += (this.NeckR4.rotationPointZ - this.NeckR3.rotationPointZ) * (float)Math.cos(this.NeckR3.rotateAngleX);
/* 1614 */     this.NeckR3.rotationPointX += (this.NeckR4.rotationPointX - this.NeckR3.rotationPointX) * (float)Math.cos(this.NeckR3.rotateAngleX);
/* 1615 */     this.NeckR4.rotateAngleX = Rheadud * 0.5F;
/* 1616 */     this.NeckR4.rotationPointY += (float)Math.sin(this.NeckR4.rotateAngleX) * 36.0F;
/* 1617 */     this.NeckR4.rotationPointZ += (this.RHead1.rotationPointZ - this.NeckR4.rotationPointZ) * (float)Math.cos(this.NeckR4.rotateAngleX);
/* 1618 */     this.NeckR4.rotationPointX += (this.RHead1.rotationPointX - this.NeckR4.rotationPointX) * (float)Math.cos(this.NeckR4.rotateAngleX);
/* 1619 */     this.RHead1.rotateAngleX = Rheadud;
/*      */     
/* 1621 */     this.RHead2.rotateAngleX = Rheadud;
/* 1622 */     this.RHead2.rotationPointZ = this.RHead1.rotationPointZ;
/* 1623 */     this.RHead2.rotationPointX = this.RHead1.rotationPointX;
/* 1624 */     this.RHead2.rotationPointY = this.RHead1.rotationPointY;
/* 1625 */     this.RHead3.rotateAngleX = Rheadud;
/* 1626 */     this.RHead3.rotationPointZ = this.RHead1.rotationPointZ;
/* 1627 */     this.RHead3.rotationPointX = this.RHead1.rotationPointX;
/* 1628 */     this.RHead3.rotationPointY = this.RHead1.rotationPointY;
/* 1629 */     this.RHeadMane.rotateAngleX = 0.384F + Rheadud;
/* 1630 */     this.RHeadMane.rotationPointZ = this.RHead1.rotationPointZ;
/* 1631 */     this.RHeadMane.rotationPointX = this.RHead1.rotationPointX;
/* 1632 */     this.RHeadMane.rotationPointY = this.RHead1.rotationPointY;
/* 1633 */     this.RLEye.rotateAngleX = Rheadud;
/* 1634 */     this.RLEye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1635 */     this.RLEye.rotationPointX = this.RHead1.rotationPointX;
/* 1636 */     this.RLEye.rotationPointY = this.RHead1.rotationPointY;
/* 1637 */     this.RREye.rotateAngleX = Rheadud;
/* 1638 */     this.RREye.rotationPointZ = this.RHead1.rotationPointZ;
/* 1639 */     this.RREye.rotationPointX = this.RHead1.rotationPointX;
/* 1640 */     this.RREye.rotationPointY = this.RHead1.rotationPointY;
/* 1641 */     this.RLNoseSpike.rotateAngleX = 0.244F + Rheadud;
/* 1642 */     this.RLNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1643 */     this.RLNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/* 1644 */     this.RLNoseSpike.rotationPointY = this.RHead1.rotationPointY;
/* 1645 */     this.RRNoseSpike.rotateAngleX = 0.261F + Rheadud;
/* 1646 */     this.RRNoseSpike.rotationPointZ = this.RHead1.rotationPointZ;
/* 1647 */     this.RRNoseSpike.rotationPointX = this.RHead1.rotationPointX;
/* 1648 */     this.RRNoseSpike.rotationPointY = this.RHead1.rotationPointY;
/*      */ 
/*      */     
/* 1651 */     this.RHead1.rotationPointY += (float)Math.cos(this.RHead1.rotateAngleX) * 14.0F;
/* 1652 */     this.NeckR4.rotationPointZ += -38.0F * (float)Math.cos(this.NeckR4.rotateAngleX);
/* 1653 */     this.RJaw1.rotationPointZ += (float)Math.sin(this.RHead1.rotateAngleX) * 12.0F;
/* 1654 */     this.RJaw1.rotationPointX = (float)(this.RHead1.rotationPointX - Math.sin(this.RHead1.rotateAngleY) * 7.0D);
/*      */     
/* 1656 */     this.RJaw2.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1657 */     this.RJaw2.rotationPointX = this.RJaw1.rotationPointX;
/* 1658 */     this.RJaw2.rotationPointY = this.RJaw1.rotationPointY;
/* 1659 */     this.RJaw3.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1660 */     this.RJaw3.rotationPointX = this.RJaw1.rotationPointX;
/* 1661 */     this.RJaw3.rotationPointY = this.RJaw1.rotationPointY;
/* 1662 */     this.RTooth1.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1663 */     this.RTooth1.rotationPointX = this.RJaw1.rotationPointX;
/* 1664 */     this.RTooth1.rotationPointY = this.RJaw1.rotationPointY;
/* 1665 */     this.RTooth2.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1666 */     this.RTooth2.rotationPointX = this.RJaw1.rotationPointX;
/* 1667 */     this.RTooth2.rotationPointY = this.RJaw1.rotationPointY;
/* 1668 */     this.RTooth3.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1669 */     this.RTooth3.rotationPointX = this.RJaw1.rotationPointX;
/* 1670 */     this.RTooth3.rotationPointY = this.RJaw1.rotationPointY;
/* 1671 */     this.RTooth4.rotationPointZ = this.RJaw1.rotationPointZ;
/* 1672 */     this.RTooth4.rotationPointX = this.RJaw1.rotationPointX;
/* 1673 */     this.RTooth4.rotationPointY = this.RJaw1.rotationPointY;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelThePrinceAdult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
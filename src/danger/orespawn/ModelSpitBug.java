/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.util.MathHelper;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ModelSpitBug
/*      */   extends ModelBase
/*      */ {
/*   22 */   private float wingspeed = 1.0F;
/*      */   
/*      */   ModelRenderer legintersection;
/*      */   
/*      */   ModelRenderer legintersectionpart2;
/*      */   ModelRenderer legintersectionpart3;
/*      */   ModelRenderer leg1start;
/*      */   ModelRenderer leg1startpart2;
/*      */   ModelRenderer leg1startpart3;
/*      */   ModelRenderer leg1;
/*      */   ModelRenderer leg1part2;
/*      */   ModelRenderer leg1part2b;
/*      */   ModelRenderer leg1part2c;
/*      */   ModelRenderer leg1part2d;
/*      */   ModelRenderer leg1part3;
/*      */   ModelRenderer leg1part3b;
/*      */   ModelRenderer leg1part3c;
/*      */   ModelRenderer leg2start;
/*      */   ModelRenderer leg2startpart2;
/*      */   ModelRenderer leg2startpart3;
/*      */   ModelRenderer leg2;
/*      */   ModelRenderer leg2part2;
/*      */   ModelRenderer leg2part2b;
/*      */   ModelRenderer leg2part2c;
/*      */   ModelRenderer leg2part2d;
/*      */   ModelRenderer leg2part3;
/*      */   ModelRenderer leg2part3b;
/*      */   ModelRenderer leg2part3c;
/*      */   ModelRenderer leg3start;
/*      */   ModelRenderer leg3startpart2;
/*      */   ModelRenderer leg3startpart3;
/*      */   ModelRenderer leg3;
/*      */   ModelRenderer leg3part2;
/*      */   ModelRenderer leg3part2b;
/*      */   ModelRenderer leg3part2c;
/*      */   ModelRenderer leg3part2d;
/*      */   ModelRenderer leg3part3;
/*      */   ModelRenderer leg3part3b;
/*      */   ModelRenderer leg3part3c;
/*      */   ModelRenderer leg4start;
/*      */   ModelRenderer leg4startpart2;
/*      */   ModelRenderer leg4startpart3;
/*      */   ModelRenderer leg4;
/*      */   ModelRenderer leg4part2;
/*      */   ModelRenderer leg4part2b;
/*      */   ModelRenderer leg4part2c;
/*      */   ModelRenderer leg4part2d;
/*      */   ModelRenderer leg4part3;
/*      */   ModelRenderer leg4part3b;
/*      */   ModelRenderer leg4part3c;
/*      */   ModelRenderer bodybase;
/*      */   ModelRenderer bodybasepart2;
/*      */   ModelRenderer bodybasepart3;
/*      */   ModelRenderer bodybasepart4;
/*      */   ModelRenderer bodybasepart5;
/*      */   ModelRenderer bodybasepart6;
/*      */   ModelRenderer bodybasepart7;
/*      */   ModelRenderer bodybasepart8;
/*      */   ModelRenderer bodybasepart9;
/*      */   ModelRenderer bodybasepart10;
/*      */   ModelRenderer bodybasepart11;
/*      */   ModelRenderer bodybasepart12;
/*      */   ModelRenderer bodybasepart13;
/*      */   ModelRenderer bodybasepart14;
/*      */   ModelRenderer bodybasepart15;
/*      */   ModelRenderer upperjawbase;
/*      */   ModelRenderer upperjawbasepart1;
/*      */   ModelRenderer upperjawbasepart2;
/*      */   ModelRenderer upperjawbasepart3;
/*      */   ModelRenderer tooth1;
/*      */   ModelRenderer tooth2;
/*      */   ModelRenderer tooth3;
/*      */   ModelRenderer tooth4;
/*      */   ModelRenderer tooth5;
/*      */   ModelRenderer lowerjawbase;
/*      */   ModelRenderer lowerjawbasepart1;
/*      */   ModelRenderer lowerjawbasepart2;
/*      */   ModelRenderer lowerjawbasepart3;
/*      */   ModelRenderer lowerjawbasepart4;
/*      */   ModelRenderer lowerjawbasepart5;
/*      */   ModelRenderer lowerjawbasepart6;
/*      */   ModelRenderer lowerjawbasepart7;
/*      */   ModelRenderer lowerjawbasepart8;
/*      */   ModelRenderer lowerjawbasepart9;
/*      */   ModelRenderer lowerjawbasepart10;
/*      */   ModelRenderer lowerjawbasepart11;
/*      */   ModelRenderer arm1start;
/*      */   ModelRenderer arm1;
/*      */   ModelRenderer arm1part2;
/*      */   ModelRenderer arm1end;
/*      */   ModelRenderer arm2start;
/*      */   ModelRenderer arm2;
/*      */   ModelRenderer arm2part2;
/*      */   ModelRenderer arm2end;
/*      */   ModelRenderer eye1;
/*      */   ModelRenderer eye2;
/*      */   
/*      */   public ModelSpitBug(float f1) {
/*  120 */     this.wingspeed = f1;
/*      */     
/*  122 */     this.textureWidth = 512;
/*  123 */     this.textureHeight = 256;
/*      */     
/*  125 */     this.legintersection = new ModelRenderer(this, 0, 0);
/*  126 */     this.legintersection.addBox(-6.0F, -2.0F, -7.0F, 12, 6, 14);
/*  127 */     this.legintersection.setRotationPoint(0.0F, 3.0F, 1.0F);
/*  128 */     this.legintersection.setTextureSize(512, 256);
/*  129 */     this.legintersection.mirror = true;
/*  130 */     setRotation(this.legintersection, 0.0F, 0.0F, 0.0F);
/*  131 */     this.legintersectionpart2 = new ModelRenderer(this, 0, 21);
/*  132 */     this.legintersectionpart2.addBox(-8.0F, -2.0F, 0.0F, 8, 6, 8);
/*  133 */     this.legintersectionpart2.setRotationPoint(0.0F, 3.0F, 2.0F);
/*  134 */     this.legintersectionpart2.setTextureSize(512, 256);
/*  135 */     this.legintersectionpart2.mirror = true;
/*  136 */     setRotation(this.legintersectionpart2, 0.0F, 0.7853982F, 0.0F);
/*  137 */     this.legintersectionpart3 = new ModelRenderer(this, 282, 18);
/*  138 */     this.legintersectionpart3.addBox(-7.0F, 3.0F, -6.0F, 14, 2, 12);
/*  139 */     this.legintersectionpart3.setRotationPoint(0.0F, 3.0F, 1.0F);
/*  140 */     this.legintersectionpart3.setTextureSize(512, 256);
/*  141 */     this.legintersectionpart3.mirror = true;
/*  142 */     setRotation(this.legintersectionpart3, 0.0F, 0.0F, 0.0F);
/*  143 */     this.leg1start = new ModelRenderer(this, 53, 0);
/*  144 */     this.leg1start.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 4);
/*  145 */     this.leg1start.setRotationPoint(4.0F, 3.0F, -4.0F);
/*  146 */     this.leg1start.setTextureSize(512, 256);
/*  147 */     this.leg1start.mirror = true;
/*  148 */     setRotation(this.leg1start, 0.0F, -0.7853982F, 0.0F);
/*  149 */     this.leg1startpart2 = new ModelRenderer(this, 53, 19);
/*  150 */     this.leg1startpart2.addBox(-2.5F, -2.0F, -3.0F, 5, 5, 4);
/*  151 */     this.leg1startpart2.setRotationPoint(6.0F, 3.0F, -6.0F);
/*  152 */     this.leg1startpart2.setTextureSize(512, 256);
/*  153 */     this.leg1startpart2.mirror = true;
/*  154 */     setRotation(this.leg1startpart2, 0.3717861F, -0.7853982F, 0.0F);
/*  155 */     this.leg1startpart3 = new ModelRenderer(this, 53, 29);
/*  156 */     this.leg1startpart3.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 2);
/*  157 */     this.leg1startpart3.setRotationPoint(6.0F, 3.0F, -6.0F);
/*  158 */     this.leg1startpart3.setTextureSize(512, 256);
/*  159 */     this.leg1startpart3.mirror = true;
/*  160 */     setRotation(this.leg1startpart3, 0.669215F, -0.7853982F, 0.0F);
/*  161 */     this.leg1 = new ModelRenderer(this, 45, 36);
/*  162 */     this.leg1.addBox(-1.5F, -3.0F, -13.0F, 3, 3, 10);
/*  163 */     this.leg1.setRotationPoint(6.0F, 3.0F, -6.0F);
/*  164 */     this.leg1.setTextureSize(512, 256);
/*  165 */     this.leg1.mirror = true;
/*  166 */     setRotation(this.leg1, 1.041001F, -0.7853982F, 0.0F);
/*  167 */     this.leg1part2 = new ModelRenderer(this, 33, 50);
/*  168 */     this.leg1part2.addBox(-2.0F, -1.5F, -13.0F, 4, 3, 15);
/*  169 */     this.leg1part2.setRotationPoint(12.0F, 13.0F, -12.0F);
/*  170 */     this.leg1part2.setTextureSize(512, 256);
/*  171 */     this.leg1part2.mirror = true;
/*  172 */     setRotation(this.leg1part2, -1.152537F, -0.7853982F, 0.0F);
/*  173 */     this.leg1part2b = new ModelRenderer(this, 33, 50);
/*  174 */     this.leg1part2b.addBox(-2.0F, 0.5F, 1.0F, 4, 1, 3);
/*  175 */     this.leg1part2b.setRotationPoint(12.0F, 13.0F, -12.0F);
/*  176 */     this.leg1part2b.setTextureSize(512, 256);
/*  177 */     this.leg1part2b.mirror = true;
/*  178 */     setRotation(this.leg1part2b, -0.7435722F, -0.7853982F, 0.0F);
/*  179 */     this.leg1part2c = new ModelRenderer(this, 33, 50);
/*  180 */     this.leg1part2c.addBox(-2.0F, -7.5F, -13.0F, 4, 1, 3);
/*  181 */     this.leg1part2c.setRotationPoint(12.0F, 13.0F, -12.0F);
/*  182 */     this.leg1part2c.setTextureSize(512, 256);
/*  183 */     this.leg1part2c.mirror = true;
/*  184 */     setRotation(this.leg1part2c, -0.6320451F, -0.7853982F, 0.0F);
/*  185 */     this.leg1part2d = new ModelRenderer(this, 2, 50);
/*  186 */     this.leg1part2d.addBox(-1.5F, -1.5F, -10.0F, 3, 3, 12);
/*  187 */     this.leg1part2d.setRotationPoint(12.0F, 13.0F, -12.0F);
/*  188 */     this.leg1part2d.setTextureSize(512, 256);
/*  189 */     this.leg1part2d.mirror = true;
/*  190 */     setRotation(this.leg1part2d, -1.041001F, -0.7853982F, 0.0F);
/*  191 */     this.leg1part3 = new ModelRenderer(this, 51, 69);
/*  192 */     this.leg1part3.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7);
/*  193 */     this.leg1part3.setRotationPoint(16.0F, 3.0F, -16.0F);
/*  194 */     this.leg1part3.setTextureSize(512, 256);
/*  195 */     this.leg1part3.mirror = true;
/*  196 */     setRotation(this.leg1part3, 0.669215F, -0.7853982F, 0.0F);
/*  197 */     this.leg1part3b = new ModelRenderer(this, 55, 80);
/*  198 */     this.leg1part3b.addBox(-2.0F, -2.0F, -2.0F, 4, 16, 4);
/*  199 */     this.leg1part3b.setRotationPoint(20.0F, 8.0F, -20.0F);
/*  200 */     this.leg1part3b.setTextureSize(512, 256);
/*  201 */     this.leg1part3b.mirror = true;
/*  202 */     setRotation(this.leg1part3b, -0.4833219F, -0.7853982F, -0.0349066F);
/*  203 */     this.leg1part3c = new ModelRenderer(this, 42, 80);
/*  204 */     this.leg1part3c.addBox(-2.0F, 14.0F, 0.0F, 4, 3, 2);
/*  205 */     this.leg1part3c.setRotationPoint(20.0F, 8.0F, -20.0F);
/*  206 */     this.leg1part3c.setTextureSize(512, 256);
/*  207 */     this.leg1part3c.mirror = true;
/*  208 */     setRotation(this.leg1part3c, -0.4833219F, -0.7853982F, -0.0349066F);
/*  209 */     this.leg2start = new ModelRenderer(this, 52, 0);
/*  210 */     this.leg2start.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 4);
/*  211 */     this.leg2start.setRotationPoint(-4.0F, 3.0F, -4.0F);
/*  212 */     this.leg2start.setTextureSize(512, 256);
/*  213 */     this.leg2start.mirror = true;
/*  214 */     setRotation(this.leg2start, 0.0F, 0.7853982F, 0.0F);
/*  215 */     this.leg2startpart2 = new ModelRenderer(this, 53, 19);
/*  216 */     this.leg2startpart2.addBox(-2.5F, -2.0F, -3.0F, 5, 5, 4);
/*  217 */     this.leg2startpart2.setRotationPoint(-6.0F, 3.0F, -6.0F);
/*  218 */     this.leg2startpart2.setTextureSize(512, 256);
/*  219 */     this.leg2startpart2.mirror = true;
/*  220 */     setRotation(this.leg2startpart2, 0.3717861F, 0.7853982F, 0.0F);
/*  221 */     this.leg2startpart3 = new ModelRenderer(this, 53, 29);
/*  222 */     this.leg2startpart3.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 2);
/*  223 */     this.leg2startpart3.setRotationPoint(-6.0F, 3.0F, -6.0F);
/*  224 */     this.leg2startpart3.setTextureSize(512, 256);
/*  225 */     this.leg2startpart3.mirror = true;
/*  226 */     setRotation(this.leg2startpart3, 0.669215F, 0.7853982F, 0.0F);
/*  227 */     this.leg2 = new ModelRenderer(this, 45, 36);
/*  228 */     this.leg2.addBox(-1.5F, -3.0F, -13.0F, 3, 3, 10);
/*  229 */     this.leg2.setRotationPoint(-6.0F, 3.0F, -6.0F);
/*  230 */     this.leg2.setTextureSize(512, 256);
/*  231 */     this.leg2.mirror = true;
/*  232 */     setRotation(this.leg2, 1.041001F, 0.7853982F, 0.0F);
/*  233 */     this.leg2part2 = new ModelRenderer(this, 72, 50);
/*  234 */     this.leg2part2.addBox(-2.0F, -1.5F, -13.0F, 4, 3, 15);
/*  235 */     this.leg2part2.setRotationPoint(-12.0F, 13.0F, -12.0F);
/*  236 */     this.leg2part2.setTextureSize(512, 256);
/*  237 */     this.leg2part2.mirror = true;
/*  238 */     setRotation(this.leg2part2, -1.152537F, 0.7853982F, 0.0F);
/*  239 */     this.leg2part2b = new ModelRenderer(this, 33, 50);
/*  240 */     this.leg2part2b.addBox(-2.0F, 0.5F, 1.0F, 4, 1, 3);
/*  241 */     this.leg2part2b.setRotationPoint(-12.0F, 13.0F, -12.0F);
/*  242 */     this.leg2part2b.setTextureSize(512, 256);
/*  243 */     this.leg2part2b.mirror = true;
/*  244 */     setRotation(this.leg2part2b, -0.7435722F, 0.7853982F, 0.0F);
/*  245 */     this.leg2part2c = new ModelRenderer(this, 33, 50);
/*  246 */     this.leg2part2c.addBox(-2.0F, -7.5F, -13.0F, 4, 1, 3);
/*  247 */     this.leg2part2c.setRotationPoint(-12.0F, 13.0F, -12.0F);
/*  248 */     this.leg2part2c.setTextureSize(512, 256);
/*  249 */     this.leg2part2c.mirror = true;
/*  250 */     setRotation(this.leg2part2c, -0.6320451F, 0.7853982F, 0.0F);
/*  251 */     this.leg2part2d = new ModelRenderer(this, 2, 50);
/*  252 */     this.leg2part2d.addBox(-1.5F, -1.5F, -10.0F, 3, 3, 12);
/*  253 */     this.leg2part2d.setRotationPoint(-12.0F, 13.0F, -12.0F);
/*  254 */     this.leg2part2d.setTextureSize(512, 256);
/*  255 */     this.leg2part2d.mirror = true;
/*  256 */     setRotation(this.leg2part2d, -1.041001F, 0.7853982F, 0.0F);
/*  257 */     this.leg2part3 = new ModelRenderer(this, 51, 69);
/*  258 */     this.leg2part3.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7);
/*  259 */     this.leg2part3.setRotationPoint(-16.0F, 3.0F, -16.0F);
/*  260 */     this.leg2part3.setTextureSize(512, 256);
/*  261 */     this.leg2part3.mirror = true;
/*  262 */     setRotation(this.leg2part3, 0.669215F, 0.7853982F, 0.0F);
/*  263 */     this.leg2part3b = new ModelRenderer(this, 55, 80);
/*  264 */     this.leg2part3b.addBox(-2.0F, -2.0F, -2.0F, 4, 16, 4);
/*  265 */     this.leg2part3b.setRotationPoint(-20.0F, 8.0F, -20.0F);
/*  266 */     this.leg2part3b.setTextureSize(512, 256);
/*  267 */     this.leg2part3b.mirror = true;
/*  268 */     setRotation(this.leg2part3b, -0.4833219F, 0.7853982F, -0.0349066F);
/*  269 */     this.leg2part3c = new ModelRenderer(this, 42, 80);
/*  270 */     this.leg2part3c.addBox(-2.0F, 14.0F, 0.0F, 4, 3, 2);
/*  271 */     this.leg2part3c.setRotationPoint(-20.0F, 8.0F, -20.0F);
/*  272 */     this.leg2part3c.setTextureSize(512, 256);
/*  273 */     this.leg2part3c.mirror = true;
/*  274 */     setRotation(this.leg2part3c, -0.4833219F, 0.7853982F, -0.0349066F);
/*  275 */     this.leg3start = new ModelRenderer(this, 52, 0);
/*  276 */     this.leg3start.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 4);
/*  277 */     this.leg3start.setRotationPoint(4.0F, 3.0F, 6.0F);
/*  278 */     this.leg3start.setTextureSize(512, 256);
/*  279 */     this.leg3start.mirror = true;
/*  280 */     setRotation(this.leg3start, 0.0F, -2.356194F, 0.0F);
/*  281 */     this.leg3startpart2 = new ModelRenderer(this, 72, 19);
/*  282 */     this.leg3startpart2.addBox(-2.5F, -2.0F, -3.0F, 5, 5, 4);
/*  283 */     this.leg3startpart2.setRotationPoint(6.0F, 3.0F, 8.0F);
/*  284 */     this.leg3startpart2.setTextureSize(512, 256);
/*  285 */     this.leg3startpart2.mirror = true;
/*  286 */     setRotation(this.leg3startpart2, 0.3717861F, -2.356194F, 0.0F);
/*  287 */     this.leg3startpart3 = new ModelRenderer(this, 72, 29);
/*  288 */     this.leg3startpart3.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 2);
/*  289 */     this.leg3startpart3.setRotationPoint(6.0F, 3.0F, 8.0F);
/*  290 */     this.leg3startpart3.setTextureSize(512, 256);
/*  291 */     this.leg3startpart3.mirror = true;
/*  292 */     setRotation(this.leg3startpart3, 0.669215F, -2.356194F, 0.0F);
/*  293 */     this.leg3 = new ModelRenderer(this, 72, 36);
/*  294 */     this.leg3.addBox(-1.5F, -3.0F, -13.0F, 3, 3, 10);
/*  295 */     this.leg3.setRotationPoint(6.0F, 3.0F, 8.0F);
/*  296 */     this.leg3.setTextureSize(512, 256);
/*  297 */     this.leg3.mirror = true;
/*  298 */     setRotation(this.leg3, 1.041001F, -2.356194F, 0.0F);
/*  299 */     this.leg3part2 = new ModelRenderer(this, 33, 50);
/*  300 */     this.leg3part2.addBox(-2.0F, -1.5F, -13.0F, 4, 3, 15);
/*  301 */     this.leg3part2.setRotationPoint(12.0F, 13.0F, 14.0F);
/*  302 */     this.leg3part2.setTextureSize(512, 256);
/*  303 */     this.leg3part2.mirror = true;
/*  304 */     setRotation(this.leg3part2, -1.152537F, -2.356194F, 0.0F);
/*  305 */     this.leg3part2b = new ModelRenderer(this, 33, 50);
/*  306 */     this.leg3part2b.addBox(-2.0F, 0.5F, 1.0F, 4, 1, 3);
/*  307 */     this.leg3part2b.setRotationPoint(12.0F, 13.0F, 14.0F);
/*  308 */     this.leg3part2b.setTextureSize(512, 256);
/*  309 */     this.leg3part2b.mirror = true;
/*  310 */     setRotation(this.leg3part2b, -0.7435722F, -2.356194F, 0.0F);
/*  311 */     this.leg3part2c = new ModelRenderer(this, 33, 50);
/*  312 */     this.leg3part2c.addBox(-2.0F, -7.5F, -13.0F, 4, 1, 3);
/*  313 */     this.leg3part2c.setRotationPoint(12.0F, 13.0F, 14.0F);
/*  314 */     this.leg3part2c.setTextureSize(512, 256);
/*  315 */     this.leg3part2c.mirror = true;
/*  316 */     setRotation(this.leg3part2c, -0.6320451F, -2.356194F, 0.0F);
/*  317 */     this.leg3part2d = new ModelRenderer(this, 111, 50);
/*  318 */     this.leg3part2d.addBox(-1.5F, -1.5F, -10.0F, 3, 3, 12);
/*  319 */     this.leg3part2d.setRotationPoint(12.0F, 13.0F, 14.0F);
/*  320 */     this.leg3part2d.setTextureSize(512, 256);
/*  321 */     this.leg3part2d.mirror = true;
/*  322 */     setRotation(this.leg3part2d, -1.041001F, -2.356194F, 0.0F);
/*  323 */     this.leg3part3 = new ModelRenderer(this, 72, 69);
/*  324 */     this.leg3part3.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7);
/*  325 */     this.leg3part3.setRotationPoint(16.0F, 3.0F, 18.0F);
/*  326 */     this.leg3part3.setTextureSize(512, 256);
/*  327 */     this.leg3part3.mirror = true;
/*  328 */     setRotation(this.leg3part3, 0.669215F, -2.356194F, 0.0F);
/*  329 */     this.leg3part3b = new ModelRenderer(this, 72, 80);
/*  330 */     this.leg3part3b.addBox(-2.0F, -2.0F, -2.0F, 4, 16, 4);
/*  331 */     this.leg3part3b.setRotationPoint(20.0F, 8.0F, 22.0F);
/*  332 */     this.leg3part3b.setTextureSize(512, 256);
/*  333 */     this.leg3part3b.mirror = true;
/*  334 */     setRotation(this.leg3part3b, -0.4833219F, -2.356194F, -0.0349066F);
/*  335 */     this.leg3part3c = new ModelRenderer(this, 89, 80);
/*  336 */     this.leg3part3c.addBox(-2.0F, 14.0F, 0.0F, 4, 3, 2);
/*  337 */     this.leg3part3c.setRotationPoint(20.0F, 8.0F, 22.0F);
/*  338 */     this.leg3part3c.setTextureSize(512, 256);
/*  339 */     this.leg3part3c.mirror = true;
/*  340 */     setRotation(this.leg3part3c, -0.4833219F, -2.356194F, -0.0349066F);
/*  341 */     this.leg4start = new ModelRenderer(this, 52, 0);
/*  342 */     this.leg4start.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 4);
/*  343 */     this.leg4start.setRotationPoint(-4.0F, 3.0F, 6.0F);
/*  344 */     this.leg4start.setTextureSize(512, 256);
/*  345 */     this.leg4start.mirror = true;
/*  346 */     setRotation(this.leg4start, 0.0F, 2.356194F, 0.0F);
/*  347 */     this.leg4startpart2 = new ModelRenderer(this, 72, 19);
/*  348 */     this.leg4startpart2.addBox(-2.5F, -2.0F, -3.0F, 5, 5, 4);
/*  349 */     this.leg4startpart2.setRotationPoint(-6.0F, 3.0F, 8.0F);
/*  350 */     this.leg4startpart2.setTextureSize(512, 256);
/*  351 */     this.leg4startpart2.mirror = true;
/*  352 */     setRotation(this.leg4startpart2, 0.3717861F, 2.356194F, 0.0F);
/*  353 */     this.leg4startpart3 = new ModelRenderer(this, 72, 29);
/*  354 */     this.leg4startpart3.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 2);
/*  355 */     this.leg4startpart3.setRotationPoint(-6.0F, 3.0F, 8.0F);
/*  356 */     this.leg4startpart3.setTextureSize(512, 256);
/*  357 */     this.leg4startpart3.mirror = true;
/*  358 */     setRotation(this.leg4startpart3, 0.669215F, 2.356194F, 0.0F);
/*  359 */     this.leg4 = new ModelRenderer(this, 72, 36);
/*  360 */     this.leg4.addBox(-1.5F, -3.0F, -13.0F, 3, 3, 10);
/*  361 */     this.leg4.setRotationPoint(-6.0F, 3.0F, 8.0F);
/*  362 */     this.leg4.setTextureSize(512, 256);
/*  363 */     this.leg4.mirror = true;
/*  364 */     setRotation(this.leg4, 1.041001F, 2.356194F, 0.0F);
/*  365 */     this.leg4part2 = new ModelRenderer(this, 72, 50);
/*  366 */     this.leg4part2.addBox(-2.0F, -1.5F, -13.0F, 4, 3, 15);
/*  367 */     this.leg4part2.setRotationPoint(-12.0F, 13.0F, 14.0F);
/*  368 */     this.leg4part2.setTextureSize(512, 256);
/*  369 */     this.leg4part2.mirror = true;
/*  370 */     setRotation(this.leg4part2, -1.152537F, 2.356194F, 0.0F);
/*  371 */     this.leg4part2b = new ModelRenderer(this, 33, 50);
/*  372 */     this.leg4part2b.addBox(-2.0F, 0.5F, 1.0F, 4, 1, 3);
/*  373 */     this.leg4part2b.setRotationPoint(-12.0F, 13.0F, 14.0F);
/*  374 */     this.leg4part2b.setTextureSize(512, 256);
/*  375 */     this.leg4part2b.mirror = true;
/*  376 */     setRotation(this.leg4part2b, -0.7435722F, 2.363176F, 0.0F);
/*  377 */     this.leg4part2c = new ModelRenderer(this, 33, 50);
/*  378 */     this.leg4part2c.addBox(-2.0F, -7.5F, -13.0F, 4, 1, 3);
/*  379 */     this.leg4part2c.setRotationPoint(-12.0F, 13.0F, 14.0F);
/*  380 */     this.leg4part2c.setTextureSize(512, 256);
/*  381 */     this.leg4part2c.mirror = true;
/*  382 */     setRotation(this.leg4part2c, -0.6320451F, 2.356194F, 0.0F);
/*  383 */     this.leg4part2d = new ModelRenderer(this, 111, 50);
/*  384 */     this.leg4part2d.addBox(-1.5F, -1.5F, -10.0F, 3, 3, 12);
/*  385 */     this.leg4part2d.setRotationPoint(-12.0F, 13.0F, 14.0F);
/*  386 */     this.leg4part2d.setTextureSize(512, 256);
/*  387 */     this.leg4part2d.mirror = true;
/*  388 */     setRotation(this.leg4part2d, -1.041001F, 2.356194F, 0.0F);
/*  389 */     this.leg4part3 = new ModelRenderer(this, 72, 69);
/*  390 */     this.leg4part3.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7);
/*  391 */     this.leg4part3.setRotationPoint(-16.0F, 3.0F, 18.0F);
/*  392 */     this.leg4part3.setTextureSize(512, 256);
/*  393 */     this.leg4part3.mirror = true;
/*  394 */     setRotation(this.leg4part3, 0.669215F, 2.356194F, 0.0F);
/*  395 */     this.leg4part3b = new ModelRenderer(this, 72, 80);
/*  396 */     this.leg4part3b.addBox(-2.0F, -2.0F, -2.0F, 4, 16, 4);
/*  397 */     this.leg4part3b.setRotationPoint(-20.0F, 8.0F, 22.0F);
/*  398 */     this.leg4part3b.setTextureSize(512, 256);
/*  399 */     this.leg4part3b.mirror = true;
/*  400 */     setRotation(this.leg4part3b, -0.4833219F, 2.356194F, -0.0349066F);
/*  401 */     this.leg4part3c = new ModelRenderer(this, 42, 80);
/*  402 */     this.leg4part3c.addBox(-2.0F, 14.0F, 0.0F, 4, 3, 2);
/*  403 */     this.leg4part3c.setRotationPoint(-20.0F, 8.0F, 22.0F);
/*  404 */     this.leg4part3c.setTextureSize(512, 256);
/*  405 */     this.leg4part3c.mirror = true;
/*  406 */     setRotation(this.leg4part3c, -0.4833219F, 2.356194F, -0.0349066F);
/*  407 */     this.bodybase = new ModelRenderer(this, 98, 0);
/*  408 */     this.bodybase.addBox(-5.0F, -20.0F, -6.5F, 10, 20, 13);
/*  409 */     this.bodybase.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  410 */     this.bodybase.setTextureSize(512, 256);
/*  411 */     this.bodybase.mirror = true;
/*  412 */     setRotation(this.bodybase, 0.0F, 0.0F, 0.0F);
/*  413 */     this.bodybasepart2 = new ModelRenderer(this, 146, 0);
/*  414 */     this.bodybasepart2.addBox(-6.0F, -20.0F, -7.5F, 12, 12, 21);
/*  415 */     this.bodybasepart2.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  416 */     this.bodybasepart2.setTextureSize(512, 256);
/*  417 */     this.bodybasepart2.mirror = true;
/*  418 */     setRotation(this.bodybasepart2, 0.0F, 0.0F, 0.0F);
/*  419 */     this.bodybasepart3 = new ModelRenderer(this, 213, 0);
/*  420 */     this.bodybasepart3.addBox(-6.5F, -20.0F, -7.5F, 13, 12, 21);
/*  421 */     this.bodybasepart3.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  422 */     this.bodybasepart3.setTextureSize(512, 256);
/*  423 */     this.bodybasepart3.mirror = true;
/*  424 */     setRotation(this.bodybasepart3, 0.0F, 0.0F, 0.0F);
/*  425 */     this.bodybasepart4 = new ModelRenderer(this, 132, 34);
/*  426 */     this.bodybasepart4.addBox(-5.0F, -18.0F, -16.5F, 10, 8, 9);
/*  427 */     this.bodybasepart4.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  428 */     this.bodybasepart4.setTextureSize(512, 256);
/*  429 */     this.bodybasepart4.mirror = true;
/*  430 */     setRotation(this.bodybasepart4, 0.0F, 0.0F, 0.0F);
/*  431 */     this.bodybasepart5 = new ModelRenderer(this, 172, 36);
/*  432 */     this.bodybasepart5.addBox(-5.0F, -19.0F, 13.5F, 10, 10, 5);
/*  433 */     this.bodybasepart5.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  434 */     this.bodybasepart5.setTextureSize(512, 256);
/*  435 */     this.bodybasepart5.mirror = true;
/*  436 */     setRotation(this.bodybasepart5, 0.0F, 0.0F, 0.0F);
/*  437 */     this.bodybasepart6 = new ModelRenderer(this, 142, 53);
/*  438 */     this.bodybasepart6.addBox(-4.5F, -18.0F, 18.5F, 9, 4, 3);
/*  439 */     this.bodybasepart6.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  440 */     this.bodybasepart6.setTextureSize(512, 256);
/*  441 */     this.bodybasepart6.mirror = true;
/*  442 */     setRotation(this.bodybasepart6, 0.0F, 0.0F, 0.0F);
/*  443 */     this.bodybasepart7 = new ModelRenderer(this, 167, 53);
/*  444 */     this.bodybasepart7.addBox(-2.5F, -26.0F, -10.5F, 5, 2, 9);
/*  445 */     this.bodybasepart7.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  446 */     this.bodybasepart7.setTextureSize(512, 256);
/*  447 */     this.bodybasepart7.mirror = true;
/*  448 */     setRotation(this.bodybasepart7, -1.264073F, 0.0F, 0.0F);
/*  449 */     this.bodybasepart8 = new ModelRenderer(this, 111, 68);
/*  450 */     this.bodybasepart8.addBox(-6.0F, -13.0F, -18.5F, 12, 10, 11);
/*  451 */     this.bodybasepart8.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  452 */     this.bodybasepart8.setTextureSize(512, 256);
/*  453 */     this.bodybasepart8.mirror = true;
/*  454 */     setRotation(this.bodybasepart8, -0.4089647F, 0.0F, 0.0F);
/*  455 */     this.bodybasepart9 = new ModelRenderer(this, 157, 66);
/*  456 */     this.bodybasepart9.addBox(-7.5F, -14.0F, -11.5F, 15, 16, 7);
/*  457 */     this.bodybasepart9.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  458 */     this.bodybasepart9.setTextureSize(512, 256);
/*  459 */     this.bodybasepart9.mirror = true;
/*  460 */     setRotation(this.bodybasepart9, -1.412787F, 0.0F, 0.0F);
/*  461 */     this.bodybasepart10 = new ModelRenderer(this, 204, 35);
/*  462 */     this.bodybasepart10.addBox(-7.5F, -22.0F, -9.5F, 15, 5, 22);
/*  463 */     this.bodybasepart10.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  464 */     this.bodybasepart10.setTextureSize(512, 256);
/*  465 */     this.bodybasepart10.mirror = true;
/*  466 */     setRotation(this.bodybasepart10, 0.0F, 0.0F, 0.0F);
/*  467 */     this.bodybasepart11 = new ModelRenderer(this, 204, 63);
/*  468 */     this.bodybasepart11.addBox(-6.5F, -21.0F, -14.5F, 13, 4, 5);
/*  469 */     this.bodybasepart11.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  470 */     this.bodybasepart11.setTextureSize(512, 256);
/*  471 */     this.bodybasepart11.mirror = true;
/*  472 */     setRotation(this.bodybasepart11, 0.0F, 0.0F, 0.0F);
/*  473 */     this.bodybasepart12 = new ModelRenderer(this, 282, 0);
/*  474 */     this.bodybasepart12.addBox(-5.0F, -3.0F, 2.5F, 10, 4, 12);
/*  475 */     this.bodybasepart12.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  476 */     this.bodybasepart12.setTextureSize(512, 256);
/*  477 */     this.bodybasepart12.mirror = true;
/*  478 */     setRotation(this.bodybasepart12, 0.4833219F, 0.0F, 0.0F);
/*  479 */     this.bodybasepart13 = new ModelRenderer(this, 327, 0);
/*  480 */     this.bodybasepart13.addBox(4.0F, 1.0F, -3.5F, 4, 2, 10);
/*  481 */     this.bodybasepart13.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  482 */     this.bodybasepart13.setTextureSize(512, 256);
/*  483 */     this.bodybasepart13.mirror = true;
/*  484 */     setRotation(this.bodybasepart13, 0.1858931F, 0.0F, -1.003822F);
/*  485 */     this.bodybasepart14 = new ModelRenderer(this, 327, 0);
/*  486 */     this.bodybasepart14.addBox(-8.0F, 1.0F, -3.5F, 4, 2, 10);
/*  487 */     this.bodybasepart14.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  488 */     this.bodybasepart14.setTextureSize(512, 256);
/*  489 */     this.bodybasepart14.mirror = true;
/*  490 */     setRotation(this.bodybasepart14, 0.185895F, 0.0F, 1.003826F);
/*  491 */     this.bodybasepart15 = new ModelRenderer(this, 144, 91);
/*  492 */     this.bodybasepart15.addBox(-2.5F, -25.0F, 1.5F, 5, 3, 7);
/*  493 */     this.bodybasepart15.setRotationPoint(0.0F, 1.0F, 1.0F);
/*  494 */     this.bodybasepart15.setTextureSize(512, 256);
/*  495 */     this.bodybasepart15.mirror = true;
/*  496 */     setRotation(this.bodybasepart15, -0.7504916F, 0.0F, 0.0F);
/*  497 */     this.upperjawbase = new ModelRenderer(this, 0, 37);
/*  498 */     this.upperjawbase.addBox(-3.5F, -2.0F, -6.0F, 7, 5, 6);
/*  499 */     this.upperjawbase.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  500 */     this.upperjawbase.setTextureSize(512, 256);
/*  501 */     this.upperjawbase.mirror = true;
/*  502 */     setRotation(this.upperjawbase, 0.0F, 0.0F, 0.0F);
/*  503 */     this.upperjawbasepart1 = new ModelRenderer(this, 35, 28);
/*  504 */     this.upperjawbasepart1.addBox(-4.5F, -1.0F, -7.0F, 3, 3, 2);
/*  505 */     this.upperjawbasepart1.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  506 */     this.upperjawbasepart1.setTextureSize(512, 256);
/*  507 */     this.upperjawbasepart1.mirror = true;
/*  508 */     setRotation(this.upperjawbasepart1, 0.0F, 0.0F, 0.0F);
/*  509 */     this.upperjawbasepart2 = new ModelRenderer(this, 35, 28);
/*  510 */     this.upperjawbasepart2.addBox(1.5F, -1.0F, -7.0F, 3, 3, 2);
/*  511 */     this.upperjawbasepart2.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  512 */     this.upperjawbasepart2.setTextureSize(512, 256);
/*  513 */     this.upperjawbasepart2.mirror = true;
/*  514 */     setRotation(this.upperjawbasepart2, 0.0F, 0.0F, 0.0F);
/*  515 */     this.upperjawbasepart3 = new ModelRenderer(this, 27, 37);
/*  516 */     this.upperjawbasepart3.addBox(-1.0F, -1.0F, -7.0F, 2, 3, 2);
/*  517 */     this.upperjawbasepart3.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  518 */     this.upperjawbasepart3.setTextureSize(512, 256);
/*  519 */     this.upperjawbasepart3.mirror = true;
/*  520 */     setRotation(this.upperjawbasepart3, 0.0F, 0.0F, 0.0F);
/*  521 */     this.tooth1 = new ModelRenderer(this, 116, 34);
/*  522 */     this.tooth1.addBox(-1.5F, -2.0F, -14.0F, 2, 2, 7);
/*  523 */     this.tooth1.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  524 */     this.tooth1.setTextureSize(512, 256);
/*  525 */     this.tooth1.mirror = true;
/*  526 */     setRotation(this.tooth1, 0.2602503F, 0.3717861F, 0.0F);
/*  527 */     this.tooth2 = new ModelRenderer(this, 116, 34);
/*  528 */     this.tooth2.addBox(-0.5F, -2.0F, -14.0F, 2, 2, 7);
/*  529 */     this.tooth2.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  530 */     this.tooth2.setTextureSize(512, 256);
/*  531 */     this.tooth2.mirror = true;
/*  532 */     setRotation(this.tooth2, 0.2602503F, -0.3717861F, 0.0F);
/*  533 */     this.tooth3 = new ModelRenderer(this, 116, 34);
/*  534 */     this.tooth3.addBox(-1.0F, -2.0F, -14.0F, 2, 2, 7);
/*  535 */     this.tooth3.setRotationPoint(0.0F, -13.0F, -15.0F);
/*  536 */     this.tooth3.setTextureSize(512, 256);
/*  537 */     this.tooth3.mirror = true;
/*  538 */     setRotation(this.tooth3, 0.2602503F, 0.0F, 0.0F);
/*  539 */     this.tooth4 = new ModelRenderer(this, 90, 111);
/*  540 */     this.tooth4.addBox(-5.5F, 1.5F, -23.5F, 3, 2, 5);
/*  541 */     this.tooth4.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  542 */     this.tooth4.setTextureSize(512, 256);
/*  543 */     this.tooth4.mirror = true;
/*  544 */     setRotation(this.tooth4, -0.2230717F, 0.0F, 0.0F);
/*  545 */     this.tooth5 = new ModelRenderer(this, 90, 111);
/*  546 */     this.tooth5.addBox(2.5F, 1.5F, -23.5F, 3, 2, 5);
/*  547 */     this.tooth5.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  548 */     this.tooth5.setTextureSize(512, 256);
/*  549 */     this.tooth5.mirror = true;
/*  550 */     setRotation(this.tooth5, -0.2230717F, 0.0F, 0.0F);
/*  551 */     this.lowerjawbase = new ModelRenderer(this, 90, 91);
/*  552 */     this.lowerjawbase.addBox(-5.0F, -1.0F, -15.5F, 10, 2, 16);
/*  553 */     this.lowerjawbase.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  554 */     this.lowerjawbase.setTextureSize(512, 256);
/*  555 */     this.lowerjawbase.mirror = true;
/*  556 */     setRotation(this.lowerjawbase, 0.0F, 0.0F, 0.0F);
/*  557 */     this.lowerjawbasepart1 = new ModelRenderer(this, 0, 69);
/*  558 */     this.lowerjawbasepart1.addBox(-5.0F, -3.0F, -15.5F, 1, 2, 16);
/*  559 */     this.lowerjawbasepart1.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  560 */     this.lowerjawbasepart1.setTextureSize(512, 256);
/*  561 */     this.lowerjawbasepart1.mirror = true;
/*  562 */     setRotation(this.lowerjawbasepart1, 0.0F, 0.0F, 0.0F);
/*  563 */     this.lowerjawbasepart2 = new ModelRenderer(this, 0, 69);
/*  564 */     this.lowerjawbasepart2.addBox(4.0F, -3.0F, -15.5F, 1, 2, 16);
/*  565 */     this.lowerjawbasepart2.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  566 */     this.lowerjawbasepart2.setTextureSize(512, 256);
/*  567 */     this.lowerjawbasepart2.mirror = true;
/*  568 */     setRotation(this.lowerjawbasepart2, 0.0F, 0.0F, 0.0F);
/*  569 */     this.lowerjawbasepart3 = new ModelRenderer(this, 0, 88);
/*  570 */     this.lowerjawbasepart3.addBox(-4.0F, -2.0F, -15.5F, 1, 1, 16);
/*  571 */     this.lowerjawbasepart3.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  572 */     this.lowerjawbasepart3.setTextureSize(512, 256);
/*  573 */     this.lowerjawbasepart3.mirror = true;
/*  574 */     setRotation(this.lowerjawbasepart3, 0.0F, 0.0F, 0.0F);
/*  575 */     this.lowerjawbasepart4 = new ModelRenderer(this, 0, 88);
/*  576 */     this.lowerjawbasepart4.addBox(3.0F, -2.0F, -15.5F, 1, 1, 16);
/*  577 */     this.lowerjawbasepart4.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  578 */     this.lowerjawbasepart4.setTextureSize(512, 256);
/*  579 */     this.lowerjawbasepart4.mirror = true;
/*  580 */     setRotation(this.lowerjawbasepart4, 0.0F, 0.0F, 0.0F);
/*  581 */     this.lowerjawbasepart5 = new ModelRenderer(this, 35, 134);
/*  582 */     this.lowerjawbasepart5.addBox(5.0F, -5.0F, -16.5F, 2, 4, 20);
/*  583 */     this.lowerjawbasepart5.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  584 */     this.lowerjawbasepart5.setTextureSize(512, 256);
/*  585 */     this.lowerjawbasepart5.mirror = true;
/*  586 */     setRotation(this.lowerjawbasepart5, 0.0F, 0.0F, 0.0F);
/*  587 */     this.lowerjawbasepart6 = new ModelRenderer(this, 35, 109);
/*  588 */     this.lowerjawbasepart6.addBox(-7.0F, -5.0F, -16.5F, 2, 4, 20);
/*  589 */     this.lowerjawbasepart6.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  590 */     this.lowerjawbasepart6.setTextureSize(512, 256);
/*  591 */     this.lowerjawbasepart6.mirror = true;
/*  592 */     setRotation(this.lowerjawbasepart6, 0.0F, 0.0F, 0.0F);
/*  593 */     this.lowerjawbasepart7 = new ModelRenderer(this, 73, 101);
/*  594 */     this.lowerjawbasepart7.addBox(-6.0F, -3.0F, -19.5F, 4, 3, 4);
/*  595 */     this.lowerjawbasepart7.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  596 */     this.lowerjawbasepart7.setTextureSize(512, 256);
/*  597 */     this.lowerjawbasepart7.mirror = true;
/*  598 */     setRotation(this.lowerjawbasepart7, 0.0F, 0.0F, 0.0F);
/*  599 */     this.lowerjawbasepart8 = new ModelRenderer(this, 73, 101);
/*  600 */     this.lowerjawbasepart8.addBox(2.0F, -3.0F, -19.5F, 4, 3, 4);
/*  601 */     this.lowerjawbasepart8.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  602 */     this.lowerjawbasepart8.setTextureSize(512, 256);
/*  603 */     this.lowerjawbasepart8.mirror = true;
/*  604 */     setRotation(this.lowerjawbasepart8, 0.0F, 0.0F, 0.0F);
/*  605 */     this.lowerjawbasepart9 = new ModelRenderer(this, 95, 72);
/*  606 */     this.lowerjawbasepart9.addBox(-2.0F, -2.0F, -18.5F, 4, 2, 3);
/*  607 */     this.lowerjawbasepart9.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  608 */     this.lowerjawbasepart9.setTextureSize(512, 256);
/*  609 */     this.lowerjawbasepart9.mirror = true;
/*  610 */     setRotation(this.lowerjawbasepart9, 0.0F, 0.0F, 0.0F);
/*  611 */     this.lowerjawbasepart10 = new ModelRenderer(this, 0, 106);
/*  612 */     this.lowerjawbasepart10.addBox(-8.0F, -3.0F, -12.5F, 1, 2, 16);
/*  613 */     this.lowerjawbasepart10.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  614 */     this.lowerjawbasepart10.setTextureSize(512, 256);
/*  615 */     this.lowerjawbasepart10.mirror = true;
/*  616 */     setRotation(this.lowerjawbasepart10, 0.0F, 0.0F, 0.0F);
/*  617 */     this.lowerjawbasepart11 = new ModelRenderer(this, 0, 106);
/*  618 */     this.lowerjawbasepart11.addBox(7.0F, -3.0F, -12.5F, 1, 2, 16);
/*  619 */     this.lowerjawbasepart11.setRotationPoint(0.0F, 0.0F, -6.0F);
/*  620 */     this.lowerjawbasepart11.setTextureSize(512, 256);
/*  621 */     this.lowerjawbasepart11.mirror = true;
/*  622 */     setRotation(this.lowerjawbasepart11, 0.0F, 0.0F, 0.0F);
/*  623 */     this.arm1start = new ModelRenderer(this, 0, 50);
/*  624 */     this.arm1start.addBox(-0.5F, -1.0F, -1.0F, 3, 2, 2);
/*  625 */     this.arm1start.setRotationPoint(5.0F, -11.0F, -14.0F);
/*  626 */     this.arm1start.setTextureSize(512, 256);
/*  627 */     this.arm1start.mirror = true;
/*  628 */     setRotation(this.arm1start, 0.0F, 0.0F, 0.0F);
/*  629 */     this.arm1 = new ModelRenderer(this, 9, 125);
/*  630 */     this.arm1.addBox(-0.5F, -1.0F, -1.0F, 2, 5, 2);
/*  631 */     this.arm1.setRotationPoint(7.0F, -11.0F, -14.0F);
/*  632 */     this.arm1.setTextureSize(512, 256);
/*  633 */     this.arm1.mirror = true;
/*  634 */     setRotation(this.arm1, -0.8922867F, 0.0F, 0.0F);
/*  635 */     this.arm1part2 = new ModelRenderer(this, 9, 133);
/*  636 */     this.arm1part2.addBox(-0.5F, -1.0F, -1.0F, 2, 5, 2);
/*  637 */     this.arm1part2.setRotationPoint(7.0F, -9.0F, -16.5F);
/*  638 */     this.arm1part2.setTextureSize(512, 256);
/*  639 */     this.arm1part2.mirror = true;
/*  640 */     setRotation(this.arm1part2, 0.7435722F, 0.0F, 0.0F);
/*  641 */     this.arm1end = new ModelRenderer(this, 9, 141);
/*  642 */     this.arm1end.addBox(1.0F, 3.0F, 1.0F, 1, 1, 2);
/*  643 */     this.arm1end.setRotationPoint(6.0F, -9.0F, -16.5F);
/*  644 */     this.arm1end.setTextureSize(512, 256);
/*  645 */     this.arm1end.mirror = true;
/*  646 */     setRotation(this.arm1end, 0.7435722F, 0.0F, 0.0F);
/*  647 */     this.arm2start = new ModelRenderer(this, 0, 50);
/*  648 */     this.arm2start.addBox(-2.5F, -1.0F, -1.0F, 3, 2, 2);
/*  649 */     this.arm2start.setRotationPoint(-5.0F, -11.0F, -14.0F);
/*  650 */     this.arm2start.setTextureSize(512, 256);
/*  651 */     this.arm2start.mirror = true;
/*  652 */     setRotation(this.arm2start, 0.0F, 0.0F, 0.0F);
/*  653 */     this.arm2 = new ModelRenderer(this, 0, 125);
/*  654 */     this.arm2.addBox(-1.5F, -1.0F, -1.0F, 2, 5, 2);
/*  655 */     this.arm2.setRotationPoint(-7.0F, -11.0F, -14.0F);
/*  656 */     this.arm2.setTextureSize(512, 256);
/*  657 */     this.arm2.mirror = true;
/*  658 */     setRotation(this.arm2, -0.8922867F, 0.0F, 0.0F);
/*  659 */     this.arm2part2 = new ModelRenderer(this, 0, 133);
/*  660 */     this.arm2part2.addBox(-1.5F, -1.0F, -1.0F, 2, 5, 2);
/*  661 */     this.arm2part2.setRotationPoint(-7.0F, -9.0F, -16.5F);
/*  662 */     this.arm2part2.setTextureSize(512, 256);
/*  663 */     this.arm2part2.mirror = true;
/*  664 */     setRotation(this.arm2part2, 0.7435722F, 0.0F, 0.0F);
/*  665 */     this.arm2end = new ModelRenderer(this, 0, 141);
/*  666 */     this.arm2end.addBox(-1.0F, 3.0F, 1.0F, 1, 1, 2);
/*  667 */     this.arm2end.setRotationPoint(-7.0F, -9.0F, -16.5F);
/*  668 */     this.arm2end.setTextureSize(512, 256);
/*  669 */     this.arm2end.mirror = true;
/*  670 */     setRotation(this.arm2end, 0.7435722F, 0.0F, 0.0F);
/*  671 */     this.eye1 = new ModelRenderer(this, 36, 37);
/*  672 */     this.eye1.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2);
/*  673 */     this.eye1.setRotationPoint(6.5F, -10.0F, -11.0F);
/*  674 */     this.eye1.setTextureSize(512, 256);
/*  675 */     this.eye1.mirror = true;
/*  676 */     setRotation(this.eye1, 0.0F, 0.0F, 0.0F);
/*  677 */     this.eye2 = new ModelRenderer(this, 36, 37);
/*  678 */     this.eye2.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2);
/*  679 */     this.eye2.setRotationPoint(-6.5F, -10.0F, -11.0F);
/*  680 */     this.eye2.setTextureSize(512, 256);
/*  681 */     this.eye2.mirror = true;
/*  682 */     setRotation(this.eye2, 0.0F, 0.0F, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  689 */     SpitBug e = (SpitBug)entity;
/*  690 */     RenderInfo r = null;
/*  691 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  692 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*  693 */     float newangle = 0.0F, upangle = 0.0F, nextangle = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  700 */     float pi4 = 1.570795F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  863 */     newangle = MathHelper.sin(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/*  864 */     nextangle = MathHelper.sin((f2 + 0.1F) * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1;
/*  865 */     upangle = 0.0F;
/*  866 */     if (nextangle > newangle)
/*  867 */       upangle = Math.abs(MathHelper.cos(f2 * 2.0F * this.wingspeed) * 3.1415927F * 0.12F * f1); 
/*  868 */     doLeftFrontLeg(newangle, upangle);
/*  869 */     doLeftRearLeg(-newangle, upangle);
/*      */     
/*  871 */     newangle = MathHelper.sin((float)((f2 * 2.0F * this.wingspeed) + Math.PI)) * 3.1415927F * 0.12F * f1;
/*  872 */     nextangle = MathHelper.sin((float)(((f2 + 0.1F) * 2.0F * this.wingspeed) + Math.PI)) * 3.1415927F * 0.12F * f1;
/*  873 */     upangle = 0.0F;
/*  874 */     if (nextangle > newangle)
/*  875 */       upangle = Math.abs(MathHelper.cos((float)((f2 * 2.0F * this.wingspeed) + Math.PI)) * 3.1415927F * 0.12F * f1); 
/*  876 */     doRightFrontLeg(-newangle, upangle);
/*  877 */     doRightRearLeg(newangle, upangle);
/*      */ 
/*      */ 
/*      */     
/*  881 */     if (e.getAttacking() == 0) {
/*  882 */       newangle = MathHelper.cos(f2 * 0.3F * this.wingspeed) * 3.1415927F * 0.015F;
/*      */     } else {
/*  884 */       newangle = MathHelper.cos(f2 * 2.6F * this.wingspeed) * 3.1415927F * 0.1F;
/*      */     } 
/*  886 */     newangle = Math.abs(newangle);
/*      */     
/*  888 */     this.upperjawbasepart1.rotateAngleX = newangle;
/*  889 */     this.upperjawbasepart2.rotateAngleX = newangle;
/*  890 */     this.upperjawbasepart3.rotateAngleX = newangle;
/*  891 */     this.tooth1.rotateAngleX = 0.26F + newangle;
/*  892 */     this.tooth2.rotateAngleX = 0.26F + newangle;
/*  893 */     this.tooth3.rotateAngleX = 0.26F + newangle;
/*      */     
/*  895 */     this.legintersection.render(f5);
/*  896 */     this.legintersectionpart2.render(f5);
/*  897 */     this.legintersectionpart3.render(f5);
/*  898 */     this.leg1start.render(f5);
/*  899 */     this.leg1startpart2.render(f5);
/*  900 */     this.leg1startpart3.render(f5);
/*  901 */     this.leg1.render(f5);
/*  902 */     this.leg1part2.render(f5);
/*  903 */     this.leg1part2b.render(f5);
/*  904 */     this.leg1part2c.render(f5);
/*  905 */     this.leg1part2d.render(f5);
/*  906 */     this.leg1part3.render(f5);
/*  907 */     this.leg1part3b.render(f5);
/*  908 */     this.leg1part3c.render(f5);
/*  909 */     this.leg2start.render(f5);
/*  910 */     this.leg2startpart2.render(f5);
/*  911 */     this.leg2startpart3.render(f5);
/*  912 */     this.leg2.render(f5);
/*  913 */     this.leg2part2.render(f5);
/*  914 */     this.leg2part2b.render(f5);
/*  915 */     this.leg2part2c.render(f5);
/*  916 */     this.leg2part2d.render(f5);
/*  917 */     this.leg2part3.render(f5);
/*  918 */     this.leg2part3b.render(f5);
/*  919 */     this.leg2part3c.render(f5);
/*  920 */     this.leg3start.render(f5);
/*  921 */     this.leg3startpart2.render(f5);
/*  922 */     this.leg3startpart3.render(f5);
/*  923 */     this.leg3.render(f5);
/*  924 */     this.leg3part2.render(f5);
/*  925 */     this.leg3part2b.render(f5);
/*  926 */     this.leg3part2c.render(f5);
/*  927 */     this.leg3part2d.render(f5);
/*  928 */     this.leg3part3.render(f5);
/*  929 */     this.leg3part3b.render(f5);
/*  930 */     this.leg3part3c.render(f5);
/*  931 */     this.leg4start.render(f5);
/*  932 */     this.leg4startpart2.render(f5);
/*  933 */     this.leg4startpart3.render(f5);
/*  934 */     this.leg4.render(f5);
/*  935 */     this.leg4part2.render(f5);
/*  936 */     this.leg4part2b.render(f5);
/*  937 */     this.leg4part2c.render(f5);
/*  938 */     this.leg4part2d.render(f5);
/*  939 */     this.leg4part3.render(f5);
/*  940 */     this.leg4part3b.render(f5);
/*  941 */     this.leg4part3c.render(f5);
/*  942 */     this.bodybase.render(f5);
/*  943 */     this.bodybasepart2.render(f5);
/*  944 */     this.bodybasepart3.render(f5);
/*  945 */     this.bodybasepart4.render(f5);
/*  946 */     this.bodybasepart5.render(f5);
/*  947 */     this.bodybasepart6.render(f5);
/*  948 */     this.bodybasepart7.render(f5);
/*  949 */     this.bodybasepart8.render(f5);
/*  950 */     this.bodybasepart9.render(f5);
/*  951 */     this.bodybasepart10.render(f5);
/*  952 */     this.bodybasepart11.render(f5);
/*  953 */     this.bodybasepart12.render(f5);
/*  954 */     this.bodybasepart13.render(f5);
/*  955 */     this.bodybasepart14.render(f5);
/*  956 */     this.bodybasepart15.render(f5);
/*  957 */     this.upperjawbase.render(f5);
/*  958 */     this.upperjawbasepart1.render(f5);
/*  959 */     this.upperjawbasepart2.render(f5);
/*  960 */     this.upperjawbasepart3.render(f5);
/*  961 */     this.tooth1.render(f5);
/*  962 */     this.tooth2.render(f5);
/*  963 */     this.tooth3.render(f5);
/*  964 */     this.tooth4.render(f5);
/*  965 */     this.tooth5.render(f5);
/*  966 */     this.lowerjawbase.render(f5);
/*  967 */     this.lowerjawbasepart1.render(f5);
/*  968 */     this.lowerjawbasepart2.render(f5);
/*  969 */     this.lowerjawbasepart3.render(f5);
/*  970 */     this.lowerjawbasepart4.render(f5);
/*  971 */     this.lowerjawbasepart5.render(f5);
/*  972 */     this.lowerjawbasepart6.render(f5);
/*  973 */     this.lowerjawbasepart7.render(f5);
/*  974 */     this.lowerjawbasepart8.render(f5);
/*  975 */     this.lowerjawbasepart9.render(f5);
/*  976 */     this.lowerjawbasepart10.render(f5);
/*  977 */     this.lowerjawbasepart11.render(f5);
/*  978 */     this.arm1start.render(f5);
/*  979 */     this.arm1.render(f5);
/*  980 */     this.arm1part2.render(f5);
/*  981 */     this.arm1end.render(f5);
/*  982 */     this.arm2start.render(f5);
/*  983 */     this.arm2.render(f5);
/*  984 */     this.arm2part2.render(f5);
/*  985 */     this.arm2end.render(f5);
/*  986 */     this.eye1.render(f5);
/*  987 */     this.eye2.render(f5);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  993 */     model.rotateAngleX = x;
/*  994 */     model.rotateAngleY = y;
/*  995 */     model.rotateAngleZ = z;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 1001 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doRightFrontLeg(float angle, float upangle) {
/* 1009 */     this.leg1.rotateAngleY = -1.2F + angle;
/* 1010 */     this.leg1part2.rotateAngleY = this.leg1.rotateAngleY;
/* 1011 */     this.leg1part2b.rotateAngleY = this.leg1.rotateAngleY;
/* 1012 */     this.leg1part2c.rotateAngleY = this.leg1.rotateAngleY;
/* 1013 */     this.leg1part2d.rotateAngleY = this.leg1.rotateAngleY;
/* 1014 */     this.leg1part3.rotateAngleY = this.leg1.rotateAngleY;
/* 1015 */     this.leg1part3b.rotateAngleY = this.leg1.rotateAngleY;
/* 1016 */     this.leg1part3c.rotateAngleY = this.leg1.rotateAngleY;
/*      */     
/* 1018 */     float dist = 14.0F;
/* 1019 */     dist = (float)(dist * Math.cos(this.leg1.rotateAngleX));
/* 1020 */     this.leg1part2d.rotationPointZ = (float)(this.leg1.rotationPointZ - Math.cos(this.leg1.rotateAngleY) * dist);
/* 1021 */     this.leg1part2d.rotationPointX = (float)(this.leg1.rotationPointX - Math.sin(this.leg1.rotateAngleY) * dist);
/*      */     
/* 1023 */     this.leg1part2.rotateAngleX = -1.152F + upangle;
/* 1024 */     this.leg1part2b.rotateAngleX = -0.743F + upangle;
/* 1025 */     this.leg1part2c.rotateAngleX = -0.632F + upangle;
/* 1026 */     this.leg1part2d.rotateAngleX = -1.041F + upangle;
/*      */     
/* 1028 */     dist = 14.0F;
/* 1029 */     dist = (float)(dist * Math.cos(this.leg1part2.rotateAngleX));
/* 1030 */     this.leg1part3.rotationPointZ = (float)(this.leg1part2.rotationPointZ - Math.cos(this.leg1part2.rotateAngleY) * dist);
/* 1031 */     this.leg1part3.rotationPointX = (float)(this.leg1part2.rotationPointX - Math.sin(this.leg1part2.rotateAngleY) * dist);
/*      */     
/* 1033 */     this.leg1part3.rotateAngleX = 0.669F - upangle;
/*      */     
/* 1035 */     dist = 8.0F;
/* 1036 */     dist = (float)Math.abs(dist * Math.cos(this.leg1part3.rotateAngleX));
/* 1037 */     this.leg1part3c.rotationPointZ = (float)(this.leg1part3.rotationPointZ - Math.cos(this.leg1part3.rotateAngleY) * dist);
/* 1038 */     this.leg1part3c.rotationPointX = (float)(this.leg1part3.rotationPointX - Math.sin(this.leg1part3.rotateAngleY) * dist);
/*      */     
/* 1040 */     this.leg1part3b.rotateAngleX = -0.48F - upangle;
/* 1041 */     this.leg1part3c.rotateAngleX = -0.48F - upangle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doLeftFrontLeg(float angle, float upangle) {
/* 1048 */     this.leg2.rotateAngleY = 1.2F + angle;
/* 1049 */     this.leg2part2.rotateAngleY = this.leg2.rotateAngleY;
/* 1050 */     this.leg2part2b.rotateAngleY = this.leg2.rotateAngleY;
/* 1051 */     this.leg2part2c.rotateAngleY = this.leg2.rotateAngleY;
/* 1052 */     this.leg2part2d.rotateAngleY = this.leg2.rotateAngleY;
/* 1053 */     this.leg2part3.rotateAngleY = this.leg2.rotateAngleY;
/* 1054 */     this.leg2part3b.rotateAngleY = this.leg2.rotateAngleY;
/* 1055 */     this.leg2part3c.rotateAngleY = this.leg2.rotateAngleY;
/*      */     
/* 1057 */     float dist = 14.0F;
/* 1058 */     dist = (float)(dist * Math.cos(this.leg2.rotateAngleX));
/* 1059 */     this.leg2part2d.rotationPointZ = (float)(this.leg2.rotationPointZ - Math.cos(this.leg2.rotateAngleY) * dist);
/* 1060 */     this.leg2part2d.rotationPointX = (float)(this.leg2.rotationPointX - Math.sin(this.leg2.rotateAngleY) * dist);
/*      */     
/* 1062 */     this.leg2part2.rotateAngleX = -1.152F + upangle;
/* 1063 */     this.leg2part2b.rotateAngleX = -0.743F + upangle;
/* 1064 */     this.leg2part2c.rotateAngleX = -0.632F + upangle;
/* 1065 */     this.leg2part2d.rotateAngleX = -1.041F + upangle;
/*      */     
/* 1067 */     dist = 14.0F;
/* 1068 */     dist = (float)(dist * Math.cos(this.leg2part2.rotateAngleX));
/* 1069 */     this.leg2part3.rotationPointZ = (float)(this.leg2part2.rotationPointZ - Math.cos(this.leg2part2.rotateAngleY) * dist);
/* 1070 */     this.leg2part3.rotationPointX = (float)(this.leg2part2.rotationPointX - Math.sin(this.leg2part2.rotateAngleY) * dist);
/*      */     
/* 1072 */     this.leg2part3.rotateAngleX = 0.669F - upangle;
/*      */     
/* 1074 */     dist = 8.0F;
/* 1075 */     dist = (float)Math.abs(dist * Math.cos(this.leg2part3.rotateAngleX));
/* 1076 */     this.leg2part3c.rotationPointZ = (float)(this.leg2part3.rotationPointZ - Math.cos(this.leg2part3.rotateAngleY) * dist);
/* 1077 */     this.leg2part3c.rotationPointX = (float)(this.leg2part3.rotationPointX - Math.sin(this.leg2part3.rotateAngleY) * dist);
/*      */     
/* 1079 */     this.leg2part3b.rotateAngleX = -0.48F - upangle;
/* 1080 */     this.leg2part3c.rotateAngleX = -0.48F - upangle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doRightRearLeg(float angle, float upangle) {
/* 1089 */     this.leg4.rotateAngleY = 2.1F + angle;
/* 1090 */     this.leg4part2.rotateAngleY = this.leg4.rotateAngleY;
/* 1091 */     this.leg4part2b.rotateAngleY = this.leg4.rotateAngleY;
/* 1092 */     this.leg4part2c.rotateAngleY = this.leg4.rotateAngleY;
/* 1093 */     this.leg4part2d.rotateAngleY = this.leg4.rotateAngleY;
/* 1094 */     this.leg4part3.rotateAngleY = this.leg4.rotateAngleY;
/* 1095 */     this.leg4part3b.rotateAngleY = this.leg4.rotateAngleY;
/* 1096 */     this.leg4part3c.rotateAngleY = this.leg4.rotateAngleY;
/*      */     
/* 1098 */     float dist = 14.0F;
/* 1099 */     dist = (float)(dist * Math.cos(this.leg4.rotateAngleX));
/* 1100 */     this.leg4part2d.rotationPointZ = (float)(this.leg4.rotationPointZ - Math.cos(this.leg4.rotateAngleY) * dist);
/* 1101 */     this.leg4part2d.rotationPointX = (float)(this.leg4.rotationPointX - Math.sin(this.leg4.rotateAngleY) * dist);
/*      */     
/* 1103 */     this.leg4part2.rotateAngleX = -1.152F + upangle;
/* 1104 */     this.leg4part2b.rotateAngleX = -0.743F + upangle;
/* 1105 */     this.leg4part2c.rotateAngleX = -0.632F + upangle;
/* 1106 */     this.leg4part2d.rotateAngleX = -1.041F + upangle;
/*      */     
/* 1108 */     dist = 14.0F;
/* 1109 */     dist = (float)(dist * Math.cos(this.leg4part2.rotateAngleX));
/* 1110 */     this.leg4part3.rotationPointZ = (float)(this.leg4part2.rotationPointZ - Math.cos(this.leg4part2.rotateAngleY) * dist);
/* 1111 */     this.leg4part3.rotationPointX = (float)(this.leg4part2.rotationPointX - Math.sin(this.leg4part2.rotateAngleY) * dist);
/*      */     
/* 1113 */     this.leg4part3.rotateAngleX = 0.669F - upangle;
/*      */     
/* 1115 */     dist = 8.0F;
/* 1116 */     dist = (float)Math.abs(dist * Math.cos(this.leg4part3.rotateAngleX));
/* 1117 */     this.leg4part3c.rotationPointZ = (float)(this.leg4part3.rotationPointZ - Math.cos(this.leg4part3.rotateAngleY) * dist);
/* 1118 */     this.leg4part3c.rotationPointX = (float)(this.leg4part3.rotationPointX - Math.sin(this.leg4part3.rotateAngleY) * dist);
/*      */     
/* 1120 */     this.leg4part3b.rotateAngleX = -0.48F - upangle;
/* 1121 */     this.leg4part3c.rotateAngleX = -0.48F - upangle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doLeftRearLeg(float angle, float upangle) {
/* 1128 */     this.leg3.rotateAngleY = -2.1F + angle;
/* 1129 */     this.leg3part2.rotateAngleY = this.leg3.rotateAngleY;
/* 1130 */     this.leg3part2b.rotateAngleY = this.leg3.rotateAngleY;
/* 1131 */     this.leg3part2c.rotateAngleY = this.leg3.rotateAngleY;
/* 1132 */     this.leg3part2d.rotateAngleY = this.leg3.rotateAngleY;
/* 1133 */     this.leg3part3.rotateAngleY = this.leg3.rotateAngleY;
/* 1134 */     this.leg3part3b.rotateAngleY = this.leg3.rotateAngleY;
/* 1135 */     this.leg3part3c.rotateAngleY = this.leg3.rotateAngleY;
/*      */     
/* 1137 */     float dist = 14.0F;
/* 1138 */     dist = (float)(dist * Math.cos(this.leg3.rotateAngleX));
/* 1139 */     this.leg3part2d.rotationPointZ = (float)(this.leg3.rotationPointZ - Math.cos(this.leg3.rotateAngleY) * dist);
/* 1140 */     this.leg3part2d.rotationPointX = (float)(this.leg3.rotationPointX - Math.sin(this.leg3.rotateAngleY) * dist);
/*      */     
/* 1142 */     this.leg3part2.rotateAngleX = -1.152F + upangle;
/* 1143 */     this.leg3part2b.rotateAngleX = -0.743F + upangle;
/* 1144 */     this.leg3part2c.rotateAngleX = -0.632F + upangle;
/* 1145 */     this.leg3part2d.rotateAngleX = -1.041F + upangle;
/*      */     
/* 1147 */     dist = 14.0F;
/* 1148 */     dist = (float)(dist * Math.cos(this.leg3part2.rotateAngleX));
/* 1149 */     this.leg3part3.rotationPointZ = (float)(this.leg3part2.rotationPointZ - Math.cos(this.leg3part2.rotateAngleY) * dist);
/* 1150 */     this.leg3part3.rotationPointX = (float)(this.leg3part2.rotationPointX - Math.sin(this.leg3part2.rotateAngleY) * dist);
/*      */     
/* 1152 */     this.leg3part3.rotateAngleX = 0.669F - upangle;
/*      */     
/* 1154 */     dist = 8.0F;
/* 1155 */     dist = (float)Math.abs(dist * Math.cos(this.leg3part3.rotateAngleX));
/* 1156 */     this.leg3part3c.rotationPointZ = (float)(this.leg3part3.rotationPointZ - Math.cos(this.leg3part3.rotateAngleY) * dist);
/* 1157 */     this.leg3part3c.rotationPointX = (float)(this.leg3part3.rotationPointX - Math.sin(this.leg3part3.rotateAngleY) * dist);
/*      */     
/* 1159 */     this.leg3part3b.rotateAngleX = -0.48F - upangle;
/* 1160 */     this.leg3part3c.rotateAngleX = -0.48F - upangle;
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSpitBug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
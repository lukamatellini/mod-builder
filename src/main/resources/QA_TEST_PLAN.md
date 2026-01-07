# QA Test Plan: Lucky Loot Blocks

Generated: 2026-01-07T01:45:41.918Z
Minecraft Version: 1.21.1
Mod ID: luckylootblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 59 |
| Passed | 53 |
| Failed | 1 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckylootblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p luckylootblocks:lucky_block_item` | ☐ | ☐ | ☐ |
| Zombie  | `/give @p luckylootblocks:zombie_` | ☐ | ☐ | ☐ |
| Skeleton  | `/give @p luckylootblocks:skeleton_` | ☐ | ☐ | ☐ |
| Creeper  | `/give @p luckylootblocks:creeper_` | ☐ | ☐ | ☐ |
| Spider  | `/give @p luckylootblocks:spider_` | ☐ | ☐ | ☐ |
| Oak Planks  | `/give @p luckylootblocks:oak_planks_` | ☐ | ☐ | ☐ |
| Cobblestone  | `/give @p luckylootblocks:cobblestone_` | ☐ | ☐ | ☐ |
| Cooked Beef  | `/give @p luckylootblocks:cooked_beef_` | ☐ | ☐ | ☐ |
| Cooked Chicken  | `/give @p luckylootblocks:cooked_chicken_` | ☐ | ☐ | ☐ |
| Bread  | `/give @p luckylootblocks:bread_` | ☐ | ☐ | ☐ |
| Regeneration Effect | `/give @p luckylootblocks:regeneration_effect` | ☐ | ☐ | ☐ |
| Strength Effect | `/give @p luckylootblocks:strength_effect` | ☐ | ☐ | ☐ |
| Poison Effect | `/give @p luckylootblocks:poison_effect` | ☐ | ☐ | ☐ |
| Slowness Effect | `/give @p luckylootblocks:slowness_effect` | ☐ | ☐ | ☐ |
| Explosion | `/give @p luckylootblocks:explosion` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Zombie 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Zombie "

#### Skeleton 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Skeleton "

#### Creeper 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Creeper "

#### Spider 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Spider "

#### Oak Planks 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Oak Planks "

#### Cobblestone 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cobblestone "

#### Cooked Beef 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Beef "

#### Cooked Chicken 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Chicken "

#### Bread 

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Bread "

#### Regeneration Effect

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Regeneration Effect"

#### Strength Effect

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Strength Effect"

#### Poison Effect

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Poison Effect"

#### Slowness Effect

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Slowness Effect"

#### Explosion

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Explosion"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckylootblocks:lucky_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable

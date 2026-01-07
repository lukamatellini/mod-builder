# QA Test Plan: Fortune Fates

Generated: 2026-01-07T05:51:59.121Z
Minecraft Version: 1.21.1
Mod ID: fortunefates

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 47 |
| Passed | 41 |
| Failed | 1 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `fortunefates.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p fortunefates:lucky_block_item` | ☐ | ☐ | ☐ |
| Hasteregeneration Effect | `/give @p fortunefates:hasteregeneration_effect` | ☐ | ☐ | ☐ |
| Small Chest With Valuable Loot | `/give @p fortunefates:small_chest_with_valuable_loot` | ☐ | ☐ | ☐ |
| Cooked Porkchops | `/give @p fortunefates:cooked_porkchops` | ☐ | ☐ | ☐ |
| Silverfish Swarm | `/give @p fortunefates:silverfish_swarm` | ☐ | ☐ | ☐ |
| Small Explosion | `/give @p fortunefates:small_explosion` | ☐ | ☐ | ☐ |
| Slownessweakness Effect | `/give @p fortunefates:slownessweakness_effect` | ☐ | ☐ | ☐ |
| Set Player On Fire | `/give @p fortunefates:set_player_on_fire` | ☐ | ☐ | ☐ |
| Poisonous Potatoes | `/give @p fortunefates:poisonous_potatoes` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Hasteregeneration Effect

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Hasteregeneration Effect"

#### Small Chest With Valuable Loot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Small Chest With Valuable Loot"

#### Cooked Porkchops

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Porkchops"

#### Silverfish Swarm

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Silverfish Swarm"

#### Small Explosion

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Small Explosion"

#### Slownessweakness Effect

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Slownessweakness Effect"

#### Set Player On Fire

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Set Player On Fire"

#### Poisonous Potatoes

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Poisonous Potatoes"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p fortunefates:lucky_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
